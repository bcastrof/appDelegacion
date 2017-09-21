/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBBDD;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bcastrof
 */
public class UsuariosBBDD {

    final modeloBBDD.ConexionBBDD conexion = new ConexionBBDD();

    public void altaUsuarioBBDD(modeloVentanas.Usuarios usuario) {
       conexion.getConnection();
        try {
            String sql = "{call public.insertarUsuario(?,?,?,?,?,?,?)}";

            CallableStatement cs = conexion.getConnection().prepareCall(sql);

            cs.setString(1, "bruno");
            cs.setString(2, "castro");
            cs.setString(3, "bcastrof");
            cs.setString(4, "xlnet");
            cs.setString(5, "correo");
            cs.setInt(6, 1);
            cs.setInt(7, 2);
            
            cs.execute();
            cs.close();

            conexion.desconexionBBDD();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
