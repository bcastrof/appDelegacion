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
public class Coches {
    private String marca;
    private String modelo;
    private String matricula;
    
    private Conducen conduce;

    public Coches(String marca, String modelo, String Matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = Matricula;
    }

    public Coches() {
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

    public Conducen getConduce() {
        return conduce;
    }

    public void setConduce(Conducen conduce) {
        this.conduce = conduce;
    }
    
    
}
