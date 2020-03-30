/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JorgeLPR
 */
public class ConexionDefault {
 
    private final String DB="paises";
    private final String URL="jdbc:mysql://192.168.1.2:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER="DBpaises_user";
    private final String PASS="1234";
    
    public Connection openConnection() {
        
        Connection connect=null;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect=(Connection) DriverManager.getConnection(URL,USER,PASS);
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("error "+ex.getMessage());
        }
        
        return connect;
    }    
    
    
    public boolean closeConnection(Connection connect){
        
        boolean condicion = false;
        
        try {
            connect.close();
            condicion=true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDefault.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return condicion;
    
    }
    
}
