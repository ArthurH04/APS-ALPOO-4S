/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infra;

import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;


public class ConnectionFactory {
    
    public static Connection getConnection() {
        
        try {
           
            Properties properties = new Properties();
            properties.load(ConnectionFactory.class.getResourceAsStream("/resources/connection.properties"));
            
            String dbUrl = System.getenv("DB_URL") != null ? System.getenv("DB_URL") : properties.getProperty("db.url");
            String dbUser = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : properties.getProperty("db.user");
            String dbPass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : properties.getProperty("db.password");
            System.out.println("DB: " + dbUrl);
            return DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
