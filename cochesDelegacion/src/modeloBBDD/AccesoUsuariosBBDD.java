/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBBDD;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVentanas.AccesoUsuarios;

/**
 *
 * @author Bruno
 */
public class AccesoUsuariosBBDD {
    
    public AccesoUsuarios recuUsuarios(AccesoUsuarios au){
      modeloBBDD.ConexionBBDD cn = new ConexionBBDD();
      AccesoUsuarios acc = new AccesoUsuarios();
      String sql = "{call recuperarUsuario(?,?)}";
      
        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
           cs.setString(1, au.getUserWin());
           cs.setString(2, au.getPass());
            cs.execute();
            cs.getMoreResults();
            
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                acc = new AccesoUsuarios(rs.getString("userwin"), rs.getString("pass"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoUsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (acc.getUserWin()!=null){
            return acc;
        }
        return null;
    }
    
}
