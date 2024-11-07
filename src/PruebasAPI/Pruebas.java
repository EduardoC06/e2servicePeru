package PruebasAPI;

import Clases.producto;
import DAO.DAOGestionProductos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Pruebas {

    public static void main(String[] args) {
        String username = "Fabricio";
        String password = "Fabricio";
        try {
            // Crear la URL con los parámetros de inicio de sesión
            String urlString = "http://localhost/API-PROYECTOI/sesion.php?username=" + username + "&password=" + password;
            URL url = new URL(urlString);

            // Abrir conexión
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Cerrar las conexiones
            in.close();
            conn.disconnect();

            // Mostrar la respuesta de la API
            System.out.println(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DAOGestionProductos dao = new DAOGestionProductos();

        // Obtener los productos desde la API
        LinkedList<producto> productos = dao.obtenerProductos();

        // Mostrar los productos
        for (producto productoa : productos) {
            System.out.println(productoa);
        }
        
//        String nombre = "Erick", descripcion = "producto 2";
//        float precio = 100;
//        int stock = 2;
//        dao.AgregarProducto(nombre, descripcion, precio, stock);
    }

}
