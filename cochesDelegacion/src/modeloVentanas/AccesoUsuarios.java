/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVentanas;

/**
 *
 * @author bcastrof
 */
public class AccesoUsuarios {

    private String userWin;
    private String pass;
    private String tipo;
    private Usuarios usuario;

    public AccesoUsuarios(String userWin, String pass, String tipo) {
        this.userWin = userWin;
        this.pass = pass;
        this.tipo = tipo;
    }

    public AccesoUsuarios() {
    }

    public String getUserWin() {
        return userWin;
    }

    public void setUserWin(String userWin) {
        this.userWin = userWin;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
