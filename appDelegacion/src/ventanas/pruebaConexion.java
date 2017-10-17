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
     con.desconexionBBDD();
       
//       String sql = "{call public.insertarUsuario(?,?,?,?,?,?,?)}";
//        
//        CallableStatement cs = con.getConnection().prepareCall(sql);
//
//            cs.setString(1, "esto1");
//            cs.setString(2, "es1");
//            cs.setString(3, "una1");
//            cs.setString(4, "prueba1");
//            cs.setString(5, "insercion1");
//            cs.setInt(6, 1);
//            cs.setInt(7, 2);
//            
//            cs.execute();
//            cs.close();
//
//            con.desconexionBBDD();  
//            String clave =  "H4sjf3cK";
//             int hashCode = clave.hashCode();
//             System.out.println(hashCode);

    }       
   
    
}
