/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdb;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JorgeLPR
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*Cargamos Look And Feel para cambiar la apariencia de nuestra ventana JFrame*/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        TestConnection frame = new TestConnection();
        frame.setVisible(true);
        
        /*
        ConexionDefault conectar = new ConexionDefault();
        //ConexionPool conectar = new ConexionPool();
        //conectar.dataSource.getConnection();
        conectar.openConnection();
        */
    }
    
}
