package org.iesabastos.dam.datos.MAAP;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "puerto")
public class Puerto implements Serializable {
    @Id
    private String nompuerto;
    @Column
    private short altura;
    @Column
    private String categoria;
    @Column
    private double pendiente;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "netapa")
    private Etapa etapa;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "dorsal")
    private Ciclista ciclista;

    public Puerto() {
    }

    public String getNompuerto() {
        return nompuerto;
    }

    public void setNompuerto(String nompuerto) {
        this.nompuerto = nompuerto;
    }

    public short getAltura() {
        return altura;
    }

    public void setAltura(short altura) {
        this.altura = altura;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPendiente() {
        return pendiente;
    }

    public void setPendiente(double pendiente) {
        this.pendiente = pendiente;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Ciclista getCiclista() {
        return ciclista;
    }

    public void setCiclista(Ciclista ciclista) {
        this.ciclista = ciclista;
    }
}
