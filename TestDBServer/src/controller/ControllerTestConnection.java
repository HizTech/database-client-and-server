package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.ConexionDefault;
import testdb.TestConnection;

/**
 *
 * @author JorgeLPR
 */
public class ControllerTestConnection implements ActionListener{
    
    private final TestConnection view;
    
    private Connection connect = null;
    private final ConexionDefault conexionDefault;
    
    public ControllerTestConnection(TestConnection view){
        this.view=view;
        conexionDefault = new ConexionDefault();
        events();
    }

    public final void events(){
        view.btnConnect.addActionListener(this);
        view.btnClose.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        
        if(evt.equals(view.btnConnect)){
        
            connect = conexionDefault.openConnection();
            if(connect != null){
                view.labelState.setForeground(Color.GREEN);                
                view.labelState.setText("onLine");
            }else{
                view.labelState.setForeground(Color.RED);                
                view.labelState.setText("offLine");
            }
        
        }else if(evt.equals(view.btnClose)){
            if(connect!=null){
                if(conexionDefault.closeConnection(connect)){
                    view.labelState.setForeground(Color.RED);                
                    view.labelState.setText("offLine");                    
                }
            }
        }
    
    }
    
}
