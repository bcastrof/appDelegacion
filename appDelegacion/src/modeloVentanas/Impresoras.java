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
public class Impresoras {



    /*atributos de la clase.*/
    private String ej_impresora;
    private String marca;
    private String modelo;
    private Long planta;
    private String color;
    private String tipo;
    private String usuarioWin;
    private int idFoto;
    private List <Usuarios> usuarios = new  ArrayList<>();
    /*Constructore*/
    public Impresoras() {
    }

    public Impresoras(String ej_impresora, String marca, String modelo, Long planta, String color, String tipo) {
        this.ej_impresora = ej_impresora;
        this.marca = marca;
        this.modelo = modelo;
        this.planta = planta;
        this.color = color;
        this.tipo = tipo;
    }

    /*Getters y Setters de los atributos*/
    public String getEj_impresora() {
        return ej_impresora;
    }

    public void setEj_impresora(String ej_impresora) {
        this.ej_impresora = ej_impresora;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void añadirUsuario(Usuarios usuario){
        usuarios.add(usuario);
    }

}
