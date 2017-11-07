/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVentanas;

import java.util.Random;

/**
 *
 * @author bcastrof
 */
public class Usuarios {

    private String nombre;
    private String apellidos;
    private String correo;
    private int telefono;

    private AccesoUsuarios accesoUsuarios;

    public Usuarios(String nombre, String apellidos, String correo, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Usuarios() {
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public AccesoUsuarios getAccesoUsuarios() {
        return accesoUsuarios;
    }

    public void setAccesoUsuarios(AccesoUsuarios accesoUsuarios) {
        this.accesoUsuarios = accesoUsuarios;
    }

    public String password() {

        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke1234567890";
        StringBuilder pass = new StringBuilder();
        Random rnd = new Random();

        while (pass.length() < 8) {
            int password = (int) (rnd.nextFloat() * (float) caracteres.length());
            pass.append(caracteres.charAt(password));
        }
        return pass.toString();
    }

}
