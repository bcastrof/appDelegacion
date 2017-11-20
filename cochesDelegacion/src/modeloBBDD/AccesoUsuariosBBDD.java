/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBBDD;

import java.sql.CallableStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVentanas.AccesoUsuarios;
import modeloVentanas.Usuarios;

/**
 *
 * @author Bruno
 */
public class AccesoUsuariosBBDD {

    public boolean insertUsuarios(AccesoUsuarios au) {
        modeloBBDD.ConexionBBDD cn = new ConexionBBDD();
        String sql = "{call insertUser(?,?,?)}";

        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.setString(1, au.getUserWin());
            cs.setString(2, au.getPass());
            cs.setString(3, au.getTipo());
            cs.execute();
            cs.close();
            cn.desconexionBBDD();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccesoUsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /* public AccesoUsuarios recuUsuarios(AccesoUsuarios au) {
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
                acc = new AccesoUsuarios(rs.getString("userwin"), rs.getString("pass"), rs.getString("tipo"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccesoUsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (acc.getUserWin() != null) {
            return acc;
        }
        return null;
    }
     */
    public AccesoUsuarios recuUsuarios(AccesoUsuarios au) {
        modeloBBDD.ConexionBBDD cn = new ConexionBBDD();
        AccesoUsuarios acc = new AccesoUsuarios();
        try {
            CallableStatement cs = cn.getConnection().prepareCall("call recuperar_Usuario(?,?,?,?)");
            cs.setString(1, au.getUserWin());
            cs.setString(2, au.getPass());
            cs.execute();
            acc.setUserWin(cs.getString(3));
            acc.setTipo(cs.getString(4));

            cs.close();
            cn.desconexionBBDD();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoUsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (acc.getUserWin() != null) {
            return acc;
        }
        return null;
    }

    public boolean modificarPass(String usuario, String passo, String newPass) {

        modeloBBDD.ConexionBBDD cn = new ConexionBBDD();
        String sql = "{call modificarUsuario (?,?,?)}";

        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.setString(1, usuario);
            cs.setString(2, passo);
            cs.setString(3, newPass);
            cs.execute();
            cs.close();
            cn.desconexionBBDD();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoUsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public AccesoUsuarios cargaCompleta(AccesoUsuarios ac) {
        modeloBBDD.ConexionBBDD cn = new ConexionBBDD();

        String sql = "{call cargaUsuario (?,?,?,?,?,?,?,?)}";
        AccesoUsuarios acc = new AccesoUsuarios();
        Usuarios us = new Usuarios();
        try {

            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.setString(1, ac.getUserWin());
            cs.setString(2, ac.getPass());
            cs.execute();

            acc = new AccesoUsuarios(cs.getString(3), cs.getString(4));
            us = new Usuarios(cs.getString(5), cs.getString(6), cs.getString(7), cs.getInt(8));
            acc.setUsuario(us);
            us.setAccesoUsuarios(acc);

            cs.close();
            cn.desconexionBBDD();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoUsuariosBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (acc.getUserWin() == null) {
            return null;
        } else {
            return acc;
        }
    }
}
