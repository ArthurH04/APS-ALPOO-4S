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
            
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbPass = properties.getProperty("db.password");
            
            return DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
