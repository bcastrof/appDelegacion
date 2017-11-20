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

/**
 *
 * @author bcastrof
 */
public class CochesBBDD {

    public boolean insertCoche(modeloVentanas.Coches ch) {

        modeloBBDD.ConexionBBDD cn = new modeloBBDD.ConexionBBDD();
        String sql = "{call insertCoche(?,?,?)}";

        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.setString(1, ch.getMarca());
            cs.setString(2, ch.getModelo());
            cs.setString(3, ch.getMatricula());
            cs.execute();
            cs.close();
            cn.desconexionBBDD();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CochesBBDD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public boolean updateCoche(modeloVentanas.Coches ch) {
        modeloBBDD.ConexionBBDD cn = new modeloBBDD.ConexionBBDD();
        String sql = "{call modificarCoche (?,?,?)}";

        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.setString(1, ch.getMarca());
            cs.setString(2, ch.getModelo());
            cs.setString(3, ch.getMatricula());
            cs.execute();
            cs.close();
            cn.desconexionBBDD();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CochesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteCoche(String mat) {
        ConexionBBDD cn = new ConexionBBDD();
        String sql = "{call borrarCoche (?)}";

        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.setString(1, mat);
            cs.execute();
            cs.close();
            cn.desconexionBBDD();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CochesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<modeloVentanas.Coches> listarCoches() {
        modeloBBDD.ConexionBBDD cn = new modeloBBDD.ConexionBBDD();
        List<modeloVentanas.Coches> ch = new ArrayList<>();
        String sql = "{call cargaCoches()}";

        try {
            CallableStatement cs = cn.getConnection().prepareCall(sql);
            cs.execute();
            cs.getMoreResults();
            ResultSet rs = cs.getResultSet();

            while (rs.next()) {

                modeloVentanas.Coches co = new Coches(rs.getString("marca"), rs.getString("modelo"), rs.getString("matricula"));
                ch.add(co);
            }
            cs.close();
            cn.desconexionBBDD();

        } catch (SQLException ex) {
            Logger.getLogger(CochesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ch;
    }
}
