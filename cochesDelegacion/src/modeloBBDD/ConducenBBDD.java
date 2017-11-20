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
import modeloVentanas.Coches;
import modeloVentanas.Conducen;
import modeloVentanas.Usuarios;

/**
 *
 * @author BCASTROF
 */
public class ConducenBBDD {

    public boolean insertarReserva(modeloVentanas.AccesoUsuarios a, modeloVentanas.Coches co, modeloVentanas.Conducen c) {
        modeloBBDD.ConexionBBDD cn = new ConexionBBDD();
        String sql = "{call insertConducen(?,?,?,?,?,?)}";
        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.setString(1, a.getUserWin());
            cs.setString(2, co.getMatricula());
            cs.setString(3, c.getFechaRecogida());
            cs.setString(4, c.getHoraRecogida());
            cs.setString(5, c.getHoraEntrega());
            cs.setString(6, c.getMotivo());
            cs.execute();
            cs.close();
            cn.desconexionBBDD();
        } catch (SQLException ex) {
            Logger.getLogger(ConducenBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<Conducen> listarReservas(String fecha) {
        modeloBBDD.ConexionBBDD cn = new ConexionBBDD();
        List<Conducen> reservas = new ArrayList<>();
        Conducen re = new Conducen();
        String sql = "{call cargaReservas(?)}";

        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.setString(1, fecha);
            cs.execute();
            cs.getMoreResults();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
             re = new  Conducen(rs.getString("nombre").concat(" ").concat(rs.getString("apellidos")), 
                     rs.getString("marca").concat(" ").concat(rs.getString("modelo")),
                     rs.getString("fechaRecogida"), rs.getString("horaRecogida"), rs.getString("horaEntrega"), rs.getString("motivo"));
               
               
                reservas.add(re);
            }
            cs.close();
            cn.desconexionBBDD();
        } catch (SQLException ex) {
            Logger.getLogger(ConducenBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reservas;

    }
    
     public List<Conducen> listarReservas1() {
        modeloBBDD.ConexionBBDD cn = new ConexionBBDD();
        List<Conducen> reservas = new ArrayList<>();
        Conducen re;
        String sql = "{call cargaReservas1()}";

        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            
            cs.execute();
            cs.getMoreResults();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
             re = new  Conducen(rs.getString("nombre").concat(" ").concat(rs.getString("apellidos")), 
                     rs.getString("marca").concat(" ").concat(rs.getString("modelo")),
                     rs.getString("fechaRecogida"), rs.getString("horaRecogida"), rs.getString("horaEntrega"), rs.getString("motivo"));
               
               
                reservas.add(re);
            }
            cs.close();
            cn.desconexionBBDD();
        } catch (SQLException ex) {
            Logger.getLogger(ConducenBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reservas;

    }
}
