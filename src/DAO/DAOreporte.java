/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.movimiento;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DAOreporte {

//    public LinkedList<Double> obtenerReporte() {
//        LinkedList<Double> listaD = new LinkedList<>();
//
//        try {
//            // URL de la API
//            String urlString = "http://localhost/API-PROYECTOI/Reportes/entrada.php";
//            URL url = new URL(urlString);
//
//            // Abrir la conexión
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            // Leer la respuesta
//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String inputLine;
//            StringBuilder content = new StringBuilder();
//            while ((inputLine = in.readLine()) != null) {
//                content.append(inputLine);
//            }
//
//            // Cerrar la conexión
//            in.close();
//            conn.disconnect();
//
//            // Parsear el JSON de la respuesta
//            JSONObject jsonResponse = new JSONObject(content.toString());
//
//            if (jsonResponse.getBoolean("success")) {
//                // Obtener los totales como valores double
//                listaD.add(jsonResponse.getDouble("total_entradas"));
//                listaD.add(jsonResponse.getDouble("total_salidas"));
//                listaD.add(jsonResponse.getDouble("total_ventas"));
//                listaD.add(jsonResponse.getDouble("total_clientes"));
//            } else {
//                System.out.println("Error en la respuesta: " + jsonResponse.getString("message"));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return listaD;  // Devolver la lista de totales
//    }
    public LinkedList<Double> obtenerReporte(String filtro) {
        LinkedList<Double> listaD = new LinkedList<>();

        try {
            String urlString = "http://localhost/API-PROYECTOI/Reportes/entradav2.php";
            URL url = new URL(urlString);

            // Abrir la conexión
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);  // Permitir enviar datos en el cuerpo de la solicitud

            // Enviar el parámetro 'filtro' con la solicitud POST
            String urlParameters = "filtro=" + URLEncoder.encode(filtro, "UTF-8");

            // Escribir el parámetro en el cuerpo de la solicitud
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = urlParameters.getBytes("utf-8");
                os.write(input, 0, input.length); // Enviar los datos
            }

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Cerrar la conexión
            in.close();
            conn.disconnect();

            // Parsear el JSON de la respuesta
            JSONObject jsonResponse = new JSONObject(content.toString());

            if (jsonResponse.getBoolean("success")) {
                // Obtener los totales como valores double
                listaD.add(jsonResponse.getDouble("total_entradas"));
                listaD.add(jsonResponse.getDouble("total_salidas"));
                listaD.add(jsonResponse.getDouble("total_ventas"));
                listaD.add(jsonResponse.getDouble("total_clientes"));
            } else {
                System.out.println("Error en la respuesta: " + jsonResponse.getString("message"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaD;  // Devolver la lista de totales
    }

//    public LinkedList<movimiento> ObtenerMovimientos(){
//        LinkedList<movimiento> listaM = new LinkedList();
//
//        try {
//            // URL de la API
//            String urlString = "http://localhost/API-PROYECTOI/Reportes/movimientos.php";
//            URL url = new URL(urlString);
//
//            // Abrir la conexión
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            // Leer la respuesta
//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String inputLine;
//            StringBuilder content = new StringBuilder();
//            while ((inputLine = in.readLine()) != null) {
//                content.append(inputLine);
//            }
//
//            // Cerrar la conexión
//            in.close();
//            conn.disconnect();
//
//            // Parsear el JSON de la respuesta
//            JSONObject jsonResponse = new JSONObject(content.toString());
//
//            if (jsonResponse.getBoolean("success")) {
//                JSONArray movimientosArray = jsonResponse.getJSONArray("movimientos");
//
//                // Recorrer el arreglo y agregar objetos a la lista
//                for (int i = 0; i < movimientosArray.length(); i++) {
//                    JSONObject movimientoJson = movimientosArray.getJSONObject(i);
//                    String fechaMovimiento = movimientoJson.getString("fecha_movimiento");
//                    movimiento mov = new movimiento(
//                        movimientoJson.getInt("id_movimiento"),
//                        movimientoJson.getString("producto"),
//                        movimientoJson.getString("usuario"),
//                        movimientoJson.getString("tipo_movimiento"),
//                        movimientoJson.getInt("cantidad"),
//                        fechaMovimiento,
//                        movimientoJson.optString("observaciones", null) // Manejar observaciones opcionales
//                    );
//
//                    listaM.add(mov);
//                }
//            } else {
//                System.out.println("Error en la respuesta: " + jsonResponse.getString("message"));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return listaM;
//    }
    public LinkedList<movimiento> ObtenerMovimientos(String filtro) {
        LinkedList<movimiento> listaM = new LinkedList<>();

        try {
            // URL de la API
            String urlString = "http://localhost/API-PROYECTOI/Reportes/MovimientosV2.php";
            URL url = new URL(urlString);

            // Abrir la conexión
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            // Enviar los parámetros en el cuerpo de la solicitud
            String params = "filtro=" + URLEncoder.encode(filtro, "UTF-8");
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = params.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                System.out.println("Respuesta del servidor: " + content.toString());
            }

            // Cerrar la conexión
            in.close();
            conn.disconnect();

            // Parsear el JSON de la respuesta
            JSONObject jsonResponse = new JSONObject(content.toString());
            
            if (jsonResponse.getBoolean("success")) {
                JSONArray movimientosArray = jsonResponse.getJSONArray("movimientos");

                // Recorrer el arreglo y agregar objetos a la lista
                for (int i = 0; i < movimientosArray.length(); i++) {
                    JSONObject movimientoJson = movimientosArray.getJSONObject(i);
                    String fechaMovimiento = movimientoJson.getString("fecha_movimiento");
                    movimiento mov = new movimiento(
                            movimientoJson.getInt("id_movimiento"),
                            movimientoJson.getString("producto"),
                            movimientoJson.getString("usuario"),
                            movimientoJson.getString("tipo_movimiento"),
                            movimientoJson.getInt("cantidad"),
                            fechaMovimiento,
                            movimientoJson.optString("observaciones", null) // Manejar observaciones opcionales
                    );

                    listaM.add(mov);
                }
            } else {
                System.out.println("Error en la respuesta: " + jsonResponse.getString("message"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaM;
    }
}
