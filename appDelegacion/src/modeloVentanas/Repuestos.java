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
public class Repuestos {

    /*relacion con impresoras lista porque un repuesto puede estar en varias
    Impresoras.*/
   // private List<Impresoras> Impresoras = new ArrayList<>();


    /*Atributos de la clase.*/
    private String cd_repuesto;
    private String marca;
    private String color;
    private Long cantidad;

    /*Constructores*/
    public Repuestos() {
    }

    public Repuestos(String cd_repuesto, String marca, String color, Long cantidad) {
        this.cd_repuesto = cd_repuesto;
        this.marca = marca;
        this.color = color;
        this.cantidad = cantidad;
    }

    /*Getters y Setters de los atributos */
    public String getCd_repuesto() {
        return cd_repuesto;
    }

    public void setCd_repuesto(String cd_repuesto) {
        this.cd_repuesto = cd_repuesto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }


}
