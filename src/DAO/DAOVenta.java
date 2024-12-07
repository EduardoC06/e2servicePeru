package DAO;

import Clases.cliente;
import Clases.comprobante;
import Clases.detalleComprobante;
import Clases.pago;
import Clases.producto;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.JSONArray;

public class DAOVenta {

    public boolean Comprobante(comprobante cm, pago pg) {
        boolean resultado = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // URL de la API para agregar comprobantes
            String urlString = "http://localhost/API-PROYECTOI/SistemaVenta.php";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Crear el objeto JSON para el comprobante incluyendo los datos del cliente
            JSONObject comprobanteJson = new JSONObject();

            // Datos del comprobante
            comprobanteJson.put("id_usuario", cm.getId_usuario());
            comprobanteJson.put("id_cliente", cm.getId_cliente());
            comprobanteJson.put("Fecha", dateFormat.format(cm.getFecha()));
            comprobanteJson.put("IGV", cm.getIgv());
            comprobanteJson.put("Total", cm.getTotal());

            // Añadir datos del cliente directamente al comprobante JSON
            cliente cl = cm.getCliente();
            comprobanteJson.put("dni", cl.getDni());
            comprobanteJson.put("ruc", cl.getRuc());
            comprobanteJson.put("nombre", cl.getNombre());
            comprobanteJson.put("direccion", cl.getDireccion());
            comprobanteJson.put("telefono", cl.getTelefono());
            comprobanteJson.put("correo", cl.getCorreo());

            // Crear JSONArray para los detalles del comprobante
            JSONArray detallesArray = new JSONArray();
            List<detalleComprobante> detalles = cm.getDetalles();

            for (detalleComprobante dt : detalles) {
                JSONObject detalleJson = new JSONObject();
                detalleJson.put("id_producto", dt.getId_Producto());
                detalleJson.put("cantidad", dt.getCantidad());
                detalleJson.put("montoUnitario", dt.getMontoUnitario());
                detalleJson.put("subtotal", dt.getSubtotal());
                detallesArray.put(detalleJson);
                
                boolean stockActualizado = actualizarStock(dt.getId_Producto(), "salida", dt.getCantidad(), cm.getId_usuario(), "Venta de producto");
            }

            // Añadir el array de detalles al JSON de comprobante
            comprobanteJson.put("detalles", detallesArray);
            
            //Añadir compra
            comprobanteJson.put("tipo", pg.getTipo());
            comprobanteJson.put("descripcion", pg.getDescripcion());
            
            // Enviar los datos a la API
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = comprobanteJson.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Verificar la respuesta de la API
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                resultado = true;
            
            } else {
                JOptionPane.showMessageDialog(null,
                        "Error al agregar comprobante. Código de respuesta: " + responseCode,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            conn.disconnect();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error en la conexión o en el procesamiento: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }
    
    public boolean realizarPago(){
        
        
        //Comprobante(cm);
        
        return false;
    }
    public LinkedList<producto> obtenerProductos() {
        LinkedList<producto> listaP = new LinkedList<>();

        try {
            String urlString = "http://localhost/API-PROYECTOI/ObtenerProductos.php";
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            JSONObject jsonResponse = new JSONObject(content.toString());

            if (jsonResponse.getBoolean("success")) {
                JSONArray productosArray = jsonResponse.getJSONArray("productos");

                for (int i = 0; i < productosArray.length(); i++) {
                    JSONObject productoJSON = productosArray.getJSONObject(i);

                    producto producto = new producto(
                            productoJSON.getInt("id_producto"),
                            productoJSON.getString("nombre"),
                            productoJSON.getString("descripcion"),
                            productoJSON.getDouble("precio"),
                            productoJSON.getInt("stock")
                    );

                    listaP.add(producto);
                }
            } else {
                System.out.println("No se encontraron productos: " + jsonResponse.getString("message"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaP;
    }
    
    public boolean actualizarStock(int idProducto, String movimiento, int cantidad, int id_usuario, String observaciones) {
        boolean resultado = false;

        try {
            String urlString = "http://localhost/API-PROYECTOI/gsappJava/Kardex.php";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Crear JSON para enviar al servidor
            JSONObject producto = new JSONObject();
            producto.put("id_producto", idProducto);
            producto.put("tipo_movimiento", movimiento);
            producto.put("cantidad", cantidad);
            producto.put("id_usuario", id_usuario);
            producto.put("observaciones", observaciones);

            // Enviar el JSON al servidor
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = producto.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta del servidor
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }

                    // Procesar la respuesta como JSON
                    JSONObject jsonResponse = new JSONObject(response.toString());
                    if (jsonResponse.getBoolean("success")) {
                        resultado = true; // Operación exitosa
                    } else {
                        // Mostrar mensaje de error del servidor
                        System.err.println(jsonResponse.getString("message"));
                        JOptionPane.showMessageDialog(null, jsonResponse.getString("message"), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                {
                    System.err.println("Error de conexión: Código de respuesta " + responseCode);
                    JOptionPane.showMessageDialog(null, "Error de conexión: Código de respuesta " + responseCode, "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al procesar la solicitud: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al procesar la solicitud: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }
}
