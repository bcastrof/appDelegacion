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
public class Conducen {

       private String fechaRecogida;
    private String horaRecogida;
    private String horaEntrega;
    private String motivo;

//    private List<AccesoUsuarios> accesoUsuarioses = new ArrayList<>();
//    private List<Coches> cocheses = new ArrayList<>();
    private AccesoUsuarios accesoUsuarios;
    private Coches coches;

    public Conducen() {
    }

    public Conducen(String fechaRecogida, String horaRecogida, String horaEntrega, String motivo) {
        this.fechaRecogida = fechaRecogida;
        this.horaRecogida = horaRecogida;
        this.horaEntrega = horaEntrega;
        this.motivo = motivo;
    }

    public Conducen(String fechaRecogida, String horaRecogida, String horaEntrega) {
        this.fechaRecogida = fechaRecogida;
        this.horaRecogida = horaRecogida;
        this.horaEntrega = horaEntrega;
    }

    public String getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(String fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public String getHoraRecogida() {
        return horaRecogida;
    }

    public void setHoraRecogida(String horaRecogida) {
        this.horaRecogida = horaRecogida;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

//    public void añadirAccesoUsuario(AccesoUsuarios a){
//        accesoUsuarioses.add(a);
//    }
//    
//    public void añadirCoches(Coches c){
//        cocheses.add(c);
//    }ç
    public AccesoUsuarios getAccesoUsuarios() {
        return accesoUsuarios;
    }

    public void setAccesoUsuarios(AccesoUsuarios accesoUsuarios) {
        this.accesoUsuarios = accesoUsuarios;
    }

    public Coches getCoches() {
        return coches;
    }

    public void setCoches(Coches coches) {
        this.coches = coches;
    }
}
