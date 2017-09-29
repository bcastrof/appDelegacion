/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.CallableStatement;
import java.sql.SQLException;
import modeloBBDD.ConexionBBDD;

/**
 *
 * @author bcastrof
 */
public class pruebaConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       ConexionBBDD con = new ConexionBBDD();
       
       con.getConnection();
       
//       String sql = "{call public.insertarUsuario(?,?,?,?,?,?,?)}";
//        
//        CallableStatement cs = con.getConnection().prepareCall(sql);
//
//            cs.setString(1, "esto");
//            cs.setString(2, "es");
//            cs.setString(3, "una");
//            cs.setString(4, "prueba");
//            cs.setString(5, "insercion");
//            cs.setInt(6, 1);
//            cs.setInt(7, 2);
//            
//            cs.execute();
//            cs.close();
//
//            con.desconexionBBDD();  
    }  
}
