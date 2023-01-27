package org.iesabastos.dam.datos.MAAP;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "etapa")
public class Etapa implements Serializable {
    @Id
    private short netapa;
    @Column
    private short km;
    @Column
    private String llegada;
    @Column
    private String salida;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "dorsal")
    private Ciclista ciclista;
    @OneToMany(mappedBy = "etapa", cascade = CascadeType.DETACH)
    private List<Puerto> puerto;

    public Etapa() {
    }

    public short getNetapa() {
        return netapa;
    }

    public void setNetapa(short netapa) {
        this.netapa = netapa;
    }

    public short getKm() {
        return km;
    }

    public void setKm(short km) {
        this.km = km;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public Ciclista getCiclista() {
        return ciclista;
    }

    public void setCiclista(Ciclista ciclista) {
        this.ciclista = ciclista;
    }

    public List<Puerto> getPuerto() {
        return puerto;
    }

    public void setPuerto(List<Puerto> puerto) {
        this.puerto = puerto;
    }
}
