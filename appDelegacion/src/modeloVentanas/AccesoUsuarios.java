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
      private Usuarios usuario;

    /*atributos de la clase*/
    private String userWin;
    private String password;
    private String fechaPassword;

    /*Constructores*/
    public AccesoUsuarios() {
    }

    public AccesoUsuarios(String userWin, String password, String fechaPassword) {
        this.userWin = userWin;
        this.password = password;
        this.fechaPassword = fechaPassword;
    }

    public String getUserWin() {
        return userWin;
    }

    public void setUserWin(String userWin) {
        this.userWin = userWin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaPassword() {
        return fechaPassword;
    }

    public void setFechaPassword(String fechaPassword) {
        this.fechaPassword = fechaPassword;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
