/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexionBBDD {
   
    private String database = "D:\\pogramacion\\Proyecto_Delgacion\\appDelegacion\\appDelegacion\\bbdd\\delegacion";
    private String username="bcastrof";
    private String password="amets517";
    private String url = "jdbc:hsqldb:"+database;
    
    public Connection conexion;
    
    public ConexionBBDD(){
        try {
            conexion=DriverManager.getConnection(url, username, password);
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Ha ocurrido un problema \n"+ex.getMessage()); 
        }
    }
    
    public Connection getConnection(){
        return conexion;
    }
    
    public void desconexionBBDD() throws SQLException{
        conexion.close();
    }
}
