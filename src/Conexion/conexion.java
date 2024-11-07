
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexion {
    public Connection Con;

    public conexion() {
    try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Con=DriverManager.getConnection("jdbc:mysql://uar0hhfyuwslqxpt:7aUTGYDiwvFYBTylW6nQ@bnxfwoqzkt373ipvwprf-mysql.services.clever-cloud.com:3306/bnxfwoqzkt373ipvwprf","uar0hhfyuwslqxpt","7aUTGYDiwvFYBTylW6nQ");
        } catch (Exception e) {
          System.err.println("Error: " + e);
        }
    }
    
    public boolean isConected() {
        return Con != null;
    }
}
