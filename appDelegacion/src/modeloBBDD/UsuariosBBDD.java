/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBBDD;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVentanas.Usuarios;

/**
 *
 * @author bcastrof
 */
public class UsuariosBBDD {

    public boolean altaUsuarioBBDD(modeloVentanas.Usuarios usuario) {
        try {
            modeloBBDD.ConexionBBDD conexion = new ConexionBBDD();
            String sql = "{call insertarUsuario(?,?,?,?,?,?,?)}";

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
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void modificarUsuarioBBDD(modeloVentanas.Usuarios usuario) {

        String sql = "{call MODIFICARUSUARIO(?,?,?,?,?,?,?)}";

        try {
            modeloBBDD.ConexionBBDD conexion = new ConexionBBDD();
            CallableStatement cs = conexion.getConnection().prepareCall(sql);

            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApellidos());
            cs.setString(3, usuario.getUserwin());
            cs.setString(4, usuario.getXlnet());
            cs.setString(5, usuario.getCorreo());
            cs.setInt(6, usuario.getPlanta());
            cs.setInt(7, usuario.getTelefono());

            cs.executeUpdate();
            cs.close();
            conexion.desconexionBBDD();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean borrarUsuarioBBDD(Usuarios usuario) {

        try {
            modeloBBDD.ConexionBBDD conexion = new ConexionBBDD();
            String sql = "{call BORRARUSUARIO(?)}";
            CallableStatement cs = conexion.getConnection().prepareCall(sql);
            cs.setString(1, usuario.getUserwin());
            cs.executeUpdate();
            cs.close();

            conexion.desconexionBBDD();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;
    }

    public List<modeloVentanas.Usuarios> listarUsuarios() {
        List<modeloVentanas.Usuarios> usuarios = new ArrayList<>();

        String sql = "{call listarUsuarios()}";

        try {
            modeloBBDD.ConexionBBDD conexion = new ConexionBBDD();
            CallableStatement cs = conexion.getConnection().prepareCall(sql);
            cs.execute();
            cs.getMoreResults();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                modeloVentanas.Usuarios u = new Usuarios(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("usuariowin"),
                        rs.getString("xlnet"),
                        rs.getString("correo"),
                        rs.getInt("planta"),
                        rs.getInt("telefono")
                );
                usuarios.add(u);
            }
            cs.close();

            rs.close();

            conexion.desconexionBBDD();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBBDD.class
                    .getName()).log(Level.SEVERE, null, ex);

        }

        return usuarios;

    }
}
