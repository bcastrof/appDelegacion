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

    private String usuario;
    private String coche;
    private String fechaRecogida;
    private String horaRecogida;
    private String horaEntrega;
    private String motivo;

    public Conducen() {
    }

    public Conducen(String usuario, String coche, String fechaRecogida, String horaRecogida, String horaEntrega, String motivo) {
        this.usuario = usuario;
        this.coche = coche;
        this.fechaRecogida = fechaRecogida;
        this.horaRecogida = horaRecogida;
        this.horaEntrega = horaEntrega;
        this.motivo = motivo;
    }

    public Conducen(String fechaRecogida, String horaRecogida, String horaEntrega, String motivo) {
        this.fechaRecogida = fechaRecogida;
        this.horaRecogida = horaRecogida;
        this.horaEntrega = horaEntrega;
        this.motivo = motivo;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCoche() {
        return coche;
    }

    public void setCoche(String coche) {
        this.coche = coche;
    }
    

}
