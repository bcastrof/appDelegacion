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
public class Equipos {

    /*relacion con usuarios un equipo pertenece a un usuario.*/
    private Usuarios usuario;

    /*atributos de la clase */
    private String ej_equipo;
    private String marca;
    private String modelo;
    private Long planta;
    private String descripcion;
    private String fecha_obscelencia;
    private String renting;

    /*Constructores*/
    public Equipos() {
    }

    public Equipos(String ej_equipo, String marca, String modelo, Long planta, String descripcion, String fecha_obscelencia, String renting) {
        this.ej_equipo = ej_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.planta = planta;
        this.descripcion = descripcion;
        this.fecha_obscelencia = fecha_obscelencia;
        this.renting = renting;
    }

    /*Getters y Setters de los atributos*/
    public String getEj_equipo() {
        return ej_equipo;
    }

    public void setEj_equipo(String ej_equipo) {
        this.ej_equipo = ej_equipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getPlanta() {
        return planta;
    }

    public void setPlanta(Long planta) {
        this.planta = planta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_obscelencia() {
        return fecha_obscelencia;
    }

    public void setFecha_obscelencia(String fecha_obscelencia) {
        this.fecha_obscelencia = fecha_obscelencia;
    }

    public String getRenting() {
        return renting;
    }

    public void setRenting(String renting) {
        this.renting = renting;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void añadirUsuario(Usuarios usuario){
        
    }
}
