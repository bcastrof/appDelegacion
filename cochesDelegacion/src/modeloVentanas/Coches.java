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
public class Coches {
   private String marca;
    private String modelo;
    private String matricula;

    private Conducen conducen;
    private List<Conducen> conducenL = new ArrayList<>();

    public Coches() {
    }

    public Coches(String marca, String modelo, String Matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = Matricula;
    }

    public Coches(String marca) {
        this.marca = marca;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String Matricula) {
        this.matricula = Matricula;
    }

    public Conducen getConducen() {
        return conducen;
    }

    public void setConducen(Conducen conducen) {
        this.conducen = conducen;
    }
    
    public void añadirConducen(Conducen c){
        conducenL.add(c);
    }
}
