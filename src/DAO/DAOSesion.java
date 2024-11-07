
package DAO;

import javax.swing.JOptionPane;
import Clases.usuario;
import java.awt.HeadlessException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class DAOSesion {
    
    private String token; // Para almacenar el token JWT

    public String getToken() {
        return token; // Método para obtener el token
    }
    
//    public static String encriptarPassword(String password) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] hash = md.digest(password.getBytes());
//            StringBuilder sb = new StringBuilder();
//            for (byte b : hash) {
//                sb.append(String.format("%02x", b));
//            }
//            return sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
    /*
    CREATE TABLE Usuario (
    Id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  
    usuario VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,              
    apellidos VARCHAR(100) NOT NULL,          
    email VARCHAR(100) NOT NULL UNIQUE,              
    password VARCHAR(256) NOT NULL,           
    rol VARCHAR(50) NOT NULL,                 
    nivel INT NOT NULL 
 );

INSERT INTO Usuario (usuario, nombre, apellidos, email, password, rol, nivel) 
VALUES ('Eduardo', 'Fabricio', 'Jimenez', 'JJfabricioDSA@email.com', SHA2('Fabricio', 256), 'admin', 1);
INSERT INTO Usuario (usuario, nombre, apellidos, email, password, rol, nivel) 
VALUES ('Daniel', 'Martin', 'Chavez', 'Daniel124USFD@email.com', SHA2('Daniel', 256), 'inventario', 1);
    
    */

//    public boolean login(usuario user){
//        boolean encontrado = false;
//    try {
//        String urlString = "http://localhost/API-PROYECTOI/sesion.php?username=" + user.getUusuario() + "&password=" + user.getPassword();
//        URL url = new URL(urlString);
//
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        String inputLine;
//        StringBuffer content = new StringBuffer();
//        while ((inputLine = in.readLine()) != null) {
//            content.append(inputLine);
//        }
//        in.close();
//        conn.disconnect();
//
//        JSONObject responseJson = new JSONObject(content.toString());
//
//        if (responseJson.getBoolean("success")) {
//            JSONObject userJson = responseJson.getJSONObject("user");
//
//            // Almacenar los datos del usuario en el objeto 'usuario'
//            user.setUCdusuario(userJson.getInt("id"));
//            user.setUusuario(userJson.getString("usuario"));
//            user.setUnombres(userJson.getString("nombres"));
//            user.setUApellidos(userJson.getString("apellidos"));
//            user.setUemail(userJson.getString("email"));
//            user.setUrol(userJson.getString("rol"));
//            user.setNivel(userJson.getInt("nivel"));
//
//            encontrado = true; // Usuario encontrado
//            
//        } else {
//            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos", "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
//        }
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//    return encontrado;
//    }
    
    public boolean login(usuario user) {
        boolean encontrado = false;
        try {
            String urlString = "http://localhost/API-PROYECTOI/sesionT.php";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            // Crear el cuerpo de la solicitud
            String urlParameters = "username=" + user.getUusuario() + "&password=" + user.getPassword();
            conn.getOutputStream().write(urlParameters.getBytes("UTF-8"));

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
                JSONObject userJson = responseJson.getJSONObject("user");
                // Almacenar el token
                token = responseJson.getString("token"); // Almacenar el token JWT

                // Almacenar los datos del usuario en el objeto 'usuario'
                user.setUCdusuario(userJson.getInt("id"));
                user.setUusuario(userJson.getString("usuario"));
                user.setUnombres(userJson.getString("nombres"));
                user.setUApellidos(userJson.getString("apellidos"));
                user.setUemail(userJson.getString("email"));
                user.setUrol(userJson.getString("rol"));
                user.setNivel(userJson.getInt("nivel"));

                encontrado = true; // Usuario encontrado
            } else {
                String mensaje = responseJson.getString("message");
                JOptionPane.showMessageDialog(null, mensaje, "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return encontrado;
    }
}


    
//    public boolean iniciarSesion(usuario user) {
//        boolean encontrado = false;
//        conexion CN = new conexion();
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            conn = CN.Con;
//
//            String sql = "SELECT * FROM Usuario WHERE nombre = ? AND password = ?"; //Usar procedimientos almacenados
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, user.getUnombres());
//            stmt.setString(2, encriptarPassword(user.getPassword()));
//
//            rs = stmt.executeQuery();
//            
//            //Inicio sesion correcto extrae los datos del usuario y manda set a la clase(preferible usar API local)
//            
//            if (rs.next()) {
//                encontrado = true;
//                user.setUCdusuario(rs.getInt("Id_usuario"));
//                user.setUApellidos(rs.getString("apellidos"));
//                user.setUemail(rs.getString("email"));
//                user.setUrol(rs.getString("rol"));
//                user.setNivel(rs.getInt("nivel"));
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos", "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
//            }
//            
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "No es posible validar los datos", "Error", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {rs.close();}
//                if (stmt != null) {stmt.close();}
//                if (conn != null) {conn.close();}
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return encontrado;
//    }        
    
