/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVentanas;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author bcastrof
 */
public class Usuarios {


    /*Atributos de la clase*/
    private String nombre;
    private String apellidos;
    private String userwin;
    private String xlnet;
    private String correo;
    private int planta;
    private int telefono;

    /*Constructores*/
    public Usuarios() {
    }

    public Usuarios(String nombre, String apellidos, String userwin, String xlnet, String correo, int planta, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.userwin = userwin;
        this.xlnet = xlnet;
        this.correo = correo;
        this.planta = planta;
        this.telefono = telefono;
    }

    /*Getters y Setters de los atributos*/
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

    public String getUserwin() {
        return userwin;
    }

    public void setUserwin(String userwin) {
        this.userwin = userwin;
    }

    public String getXlnet() {
        return xlnet;
    }

    public void setXlnet(String xlnet) {
        this.xlnet = xlnet;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.apellidos);
        hash = 43 * hash + Objects.hashCode(this.userwin);
        hash = 43 * hash + Objects.hashCode(this.xlnet);
        hash = 43 * hash + Objects.hashCode(this.correo);
        hash = 43 * hash + this.planta;
        hash = 43 * hash + this.telefono;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuarios other = (Usuarios) obj;
        if (this.planta != other.planta) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.userwin, other.userwin)) {
            return false;
        }
        if (!Objects.equals(this.xlnet, other.xlnet)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }
    
    
    
}
