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
    private String usuarioWindows;
    private String password;
    private String fechaPassword;

    /*Constructores*/
    public AccesoUsuarios() {
    }

    public AccesoUsuarios(String usuarioWindows, String password, String fechaPassword) {
        this.usuarioWindows = usuarioWindows;
        this.password = password;
        this.fechaPassword = fechaPassword;
    }

    /* Geters y Seters de los atributos*/
    public String getUsuarioWindows() {
        return usuarioWindows;
    }

    public void setUsuarioWindows(String usuarioWindows) {
        this.usuarioWindows = usuarioWindows;
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

}
