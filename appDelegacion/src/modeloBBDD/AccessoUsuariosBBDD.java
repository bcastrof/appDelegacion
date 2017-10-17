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
 * @author bcastrof
 */
public class AccessoUsuariosBBDD {
    
    public boolean altaAccessoUsuariosBBD(modeloVentanas.AccesoUsuarios accesoUsuario) {
        try {
            modeloBBDD.ConexionBBDD conexion = new ConexionBBDD();
            String sql = "{call insertarAccessoUsuario(?,?,?)}";

            CallableStatement cs = conexion.getConnection().prepareCall(sql);

            cs.setString(1, accesoUsuario.getUserWin());
            cs.setString(2, accesoUsuario.getPassword());
            cs.setString(3, accesoUsuario.getFechaPassword());


            cs.execute();
            cs.close();

            conexion.desconexionBBDD();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
