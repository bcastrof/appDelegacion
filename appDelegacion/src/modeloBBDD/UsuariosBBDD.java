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
        try {
            String sql = "{call public.insertarUsuario(?,?,?,?,?,?,?)}";

            CallableStatement cs = conexion.getConnection().prepareCall(sql);

            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApellidos());
            cs.setString(3, usuario.getUserwin());
            cs.setString(4, usuario.getXlnet());
            cs.setString(5, usuario.getCorreo());
            cs.setInt(6, usuario.getPlanta());
            cs.setInt(7, usuario.getTelefono());

            cs.execute();
            cs.close();

            conexion.desconexionBBDD();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarUsuarioBBDD(modeloVentanas.Usuarios usuario) {
        
        String sql = "{call public.MODIFICARUSUARIO(?,?,?,?,?,?,?)}";

        try {
            CallableStatement cs = conexion.getConnection().prepareCall(sql);
            
            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApellidos());
            cs.setString(3, usuario.getUserwin());
            cs.setString(4, usuario.getXlnet());
            cs.setString(5, usuario.getCorreo());
            cs.setInt(6, usuario.getPlanta());
            cs.setInt(7, usuario.getTelefono());
            
            
            cs.executeUpdate();
            cs.closeOnCompletion();
            cs.close();
            conexion.desconexionBBDD();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarUsuarioBBDD(String usuario){
        
        String sql = "{call BORRARUSUARIO(?)}";
        
        try {
            CallableStatement cs = conexion.getConnection().prepareCall(sql);
            cs.setString(1, usuario);
            cs.executeUpdate();
            cs.close();
            cs.closeOnCompletion();
            
            conexion.desconexionBBDD();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
