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

    /*relacion con usuarios*/
    private Usuarios user;

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

    /* Geters y Seters de los atributos*/
    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
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

    private void añadirUsuario(Usuarios usuario) {
        user.setAccesUser(this);
    }
}
