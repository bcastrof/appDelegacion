/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloBBDD.AccesoUsuariosBBDD;
import modeloBBDD.ConducenBBDD;
import modeloBBDD.ConexionBBDD;
import modeloVentanas.AccesoUsuarios;
import modeloVentanas.Conducen;
import modeloVentanas.Usuarios;

/**
 *
 * @author Bruno
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        ConexionBBDD con = new ConexionBBDD();

//        con.getConnection();
//        con.desconexionBBDD();
//        String sql = "{call cargaUsuario (?,?,?,?,?,?,?,?)}";
//
//        try {
//            AccesoUsuarios ac;
//            Usuarios us;
//            CallableStatement cs = con.getConnection().prepareCall(sql);
//            cs.setString(1, "bcastrof");
//            cs.setString(2, "123");
//            cs.execute();
//
//            ac = new AccesoUsuarios(cs.getString(3), cs.getString(4));
//            us = new Usuarios(cs.getString(5), cs.getString(6), cs.getString(7), cs.getInt(8));
//            ac.setUsuario(us);
//            us.setAccesoUsuarios(ac);
//
//            cs.close();
//            con.desconexionBBDD();
//
//            System.out.println(ac.getUserWin() + " " + us.getNombre());
//        } catch (SQLException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }


        ConducenBBDD conducenBBDD = new ConducenBBDD();
        //co=conducenBBDD.listarReservas("2017-11-14");
        List <Conducen> co=conducenBBDD.listarReservas("2017-11-14");
        co.forEach((co1) -> {
            System.out.println(co1.getCoches().getMarca()+" "+co1.getFechaRecogida());
        });
    }
    lol
}
