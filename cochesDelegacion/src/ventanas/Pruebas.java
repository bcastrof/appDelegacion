/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloBBDD.AccesoUsuariosBBDD;
import modeloBBDD.ConexionBBDD;
import modeloVentanas.AccesoUsuarios;


/**
 *
 * @author Bruno
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ConexionBBDD con = new ConexionBBDD();
      //  String sql = "{call recuperar_Usuarios(?,?,?,?)}";
        
        try {
            CallableStatement cs = con.getConnection().prepareCall("call recuperar_Usuario(?,?,?,?)");
            cs.setString(1, "bcastrof");
            cs.setString(2, "123456");
            cs.execute();
            String user = cs.getString(3);
            String tipo = cs.getString(4);
            cs.close();
            con.desconexionBBDD();
            
         
            
        } catch (SQLException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /* String sql = "{call recuperarUsuario(?,?)}";

        try {
            CallableStatement cs = con.getConnection().prepareCall(sql);
            cs.setString(1, "bcastrof");
            cs.setString(2, "123456");
            cs.execute();
            cs.getMoreResults();

            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                String user = rs.getString("userwin");
                String tipo = rs.getString("tipo");
                System.out.println(user+" "+tipo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccesoUsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } 
        */
    }
    
}
