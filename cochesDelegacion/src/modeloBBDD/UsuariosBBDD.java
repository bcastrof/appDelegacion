/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBBDD;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class UsuariosBBDD {
    
    public boolean insertUsuarios (modeloVentanas.Usuarios us){
        modeloBBDD.ConexionBBDD cn = new ConexionBBDD();
        String sql = "{call insertarFuncionario(?,?,?,?,?)}";
        
        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.setString(1, us.getAccesoUsuarios().getUserWin());
            cs.setString(2, us.getNombre());
            cs.setString(3, us.getApellidos());
            cs.setString(4, us.getCorreo());
            cs.setInt(5, us.getTelefono());
            
            cs.execute();
            cs.close();
            cn.desconexionBBDD();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
    
}
