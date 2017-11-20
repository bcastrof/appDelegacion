/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexionBBDD {
   
    private String database = "C:\\Users\\Bruno\\Documents\\gitHub\\appJava\\appDelegacion\\cochesDelegacion\\BBDD\\cochesDelegacion";
    private String database2= "D:\\pogramacion\\Proyecto_Delgacion\\appDelegacion\\cochesDelegacion\\BBDD\\cochesDelegacion";
    private String database3 = "N:\\RESERVA_VEHÍCULOS\\año_2017\\cochesDelegacion\\BBDD\\cochesDelegacion";
    private String username="bcastrof";
    private String password="amets517";
    private String url = "jdbc:hsqldb:"+database3;

    public Connection conexion;
    
    public ConexionBBDD(){
        try {
            conexion=DriverManager.getConnection(url, username, password);
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Ha ocurrido un problema \n"+ex.getMessage()); 
             System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        return conexion;
    }
    
    public void desconexionBBDD() throws SQLException{
        // hago trampa para que varios usuarios puedan usar la BBDD a la vez
        //es un arma de doble filo porque puede dar lectura equivocadas.
        String sql = "shutdown";
        
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.execute();
        conexion.close();   
    }
}
