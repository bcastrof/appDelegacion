/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.SQLException;
import modeloBBDD.ConexionBBDD;

/**
 *
 * @author Bruno
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ConexionBBDD con = new ConexionBBDD();
        con.getConnection();
        con.desconexionBBDD();
    }
    
}
