/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVentanas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bcastrof
 */
public class Usuarios {

    /*relacion con accesso a usuarios.*/
    private AccesoUsuarios usuarios;

    /*relacion con equipos lista por un usuario puede tener varios equipos pero
    pero un equipo es de un usuario.*/
    private List<Equipos> equipos = new ArrayList<>();

    /*relacion con impresoras lista porque un usuario puede tener varias 
    impresoras pero esta es de un solo usuario.*/
    private List<Impresoras> impresoras = new ArrayList<>();

    /*Atributos de la clase*/
    private String nombre;
    private String apellidos;
    private String xlnet;
    private String correo;
    private Long planta;
    private Long telefono;

    /*Constructores*/
    public Usuarios() {
    }

    public Usuarios(String nombre, String apellidos, String xlnet, String correo, Long planta, Long telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
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

    public Long getPlanta() {
        return planta;
    }

    public void setPlanta(Long planta) {
        this.planta = planta;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

}
