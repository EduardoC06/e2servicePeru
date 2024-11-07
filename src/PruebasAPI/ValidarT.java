package PruebasAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ValidarT {
    
    private static final String VALIDATE_URL = "http://localhost/API-PROYECTOI/ValidarT.php"; // Cambia esto por tu URL

    public static void main(String[] args) {
        // Tu token aquí
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MzA1ODM3MDgsImV4cCI6MTczMDU4NzMwOCwidXNlcklkIjoxfQ.OBU4687KYDc-2EuqZJh1RBjvxd2oj5BbN_WV6ngzSVA"; 

        try {
            // Crear la conexión HTTP
            URL url = new URL(VALIDATE_URL + "?token=" + token);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET"); // Método GET
            
            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Mostrar la respuesta
            System.out.println("Respuesta del servidor: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
