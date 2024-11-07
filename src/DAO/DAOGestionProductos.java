package DAO;

import Clases.producto;
import Interface.Productos;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.json.JSONArray;

public class DAOGestionProductos implements Productos {

//    public LinkedList<producto> obtenerProductos() {
//        LinkedList<producto> ListaP = new LinkedList<>();
//
//        try {
//            String urlString = "http://localhost/API-PROYECTOI/Productos.php";
//            URL url = new URL(urlString);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String inputLine;
//            StringBuilder content = new StringBuilder();
//            while ((inputLine = in.readLine()) != null) {
//                content.append(inputLine);
//            }
//
//            in.close();
//            conn.disconnect();
//
//            JSONObject jsonResponse = new JSONObject(content.toString());
//
//            if (jsonResponse.getBoolean("success")) {
//                JSONArray productosArray = jsonResponse.getJSONArray("productos");
//
//                for (int i = 0; i < productosArray.length(); i++) {
//                    JSONObject productoJSON = productosArray.getJSONObject(i);
//
//                    producto producto = new producto(
//                            productoJSON.getInt("id_producto"),
//                            productoJSON.getString("nombre"),
//                            productoJSON.getString("descripcion"),
//                            productoJSON.getDouble("precio"),
//                            productoJSON.getInt("stock")
//                    );
//
//                    ListaP.add(producto);
//                }
//            } else {
//                System.out.println("No se encontraron productos: " + jsonResponse.getString("message"));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return ListaP;
//    }
//
//    public boolean AgregarProducto(String nombre, String descripcion, double precio, int stock) {
//        boolean resultado = false;
//
//        try {
//            // URL de la API para agregar productos
//            String urlString = "http://localhost/API-PROYECTOI/agregarProductos.php";
//            URL url = new URL(urlString);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setRequestProperty("Accept", "application/json");
//            conn.setDoOutput(true);
//
//            // Crear objeto JSON con los datos del producto
//            JSONObject producto = new JSONObject();
//            producto.put("nombre", nombre);
//            producto.put("descripcion", descripcion);
//            producto.put("precio", precio);
//            producto.put("stock", stock);
//
//            // Enviar los datos a la API
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = producto.toString().getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            // Verificar la respuesta de la API
//            int responseCode = conn.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                resultado = true;
//            } else {
//                System.out.println("Error al agregar producto. Código de respuesta: " + responseCode);
//            }
//
//            conn.disconnect();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return resultado;
//    }
//
//    public boolean actualizarProducto(int idProducto, String nombre, String descripcion, double precio, int stock) {
//        boolean resultado = false;
//
//        try {
//            // URL de la API para actualizar productos
//            String urlString = "http://localhost/API-PROYECTOI/ActualizarProducto.php";
//            URL url = new URL(urlString);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("PUT");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setRequestProperty("Accept", "application/json");
//            conn.setDoOutput(true);
//
//            // Crear objeto JSON con los datos del producto
//            JSONObject producto = new JSONObject();
//            producto.put("id_producto", idProducto);
//            producto.put("nombre", nombre);
//            producto.put("descripcion", descripcion);
//            producto.put("precio", precio);
//            producto.put("stock", stock);
//
//            // Enviar los datos a la API
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = producto.toString().getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            // Verificar la respuesta de la API
//            int responseCode = conn.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                resultado = true;
//            } else {
//                System.out.println("Error al actualizar producto. Código de respuesta: " + responseCode);
//            }
//
//            conn.disconnect();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return resultado;
//    }
    @Override
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

    @Override
    public boolean agregarProducto(String nombre, String descripcion, double precio, int stock) {
        boolean resultado = false;

        try {
            String urlString = "http://localhost/API-PROYECTOI/agregarProductos.php";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            JSONObject producto = new JSONObject();
            producto.put("nombre", nombre);
            producto.put("descripcion", descripcion);
            producto.put("precio", precio);
            producto.put("stock", stock);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = producto.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                resultado = true;
            } else {
                System.out.println("Error al agregar producto. Código de respuesta: " + responseCode);
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public boolean actualizarProducto(int idProducto, String nombre, String descripcion, double precio, int stock) {
        boolean resultado = false;

        try {
            String urlString = "http://localhost/API-PROYECTOI/ActualizarProducto.php";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            JSONObject producto = new JSONObject();
            producto.put("id_producto", idProducto);
            producto.put("nombre", nombre);
            producto.put("descripcion", descripcion);
            producto.put("precio", precio);
            producto.put("stock", stock);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = producto.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                resultado = true;
            } else {
                System.out.println("Error al actualizar producto. Código de respuesta: " + responseCode);
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public boolean comprobarToken(String token) {
        boolean valido = false;
        try {
            String urlString = "http://localhost/API-PROYECTOI/validarT.php?token=" + token;
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            JSONObject responseJson = new JSONObject(content.toString());

            if (responseJson.getBoolean("success")) {
                valido = true;
            } else { //Que devuelva el manejsae y muestre el error en el joptionpnae
                JOptionPane.showMessageDialog(null, "Token vencido o no valido", "Respuesta", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return valido;
    }

    @Override
    public boolean BorrarProducto(int idProducto) { //int usuario
        boolean resultado = false;

        try {
            String urlString = "http://localhost/API-PROYECTOI/BorrarProducto.php";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            JSONObject producto = new JSONObject();
            producto.put("id_producto", idProducto);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = producto.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                resultado = true;
            } else {
                System.out.println("Error al borrar el producto" + responseCode);
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

}
