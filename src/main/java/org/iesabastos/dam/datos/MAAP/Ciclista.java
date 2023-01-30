package org.iesabastos.dam.datos.MAAP;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ciclista")
public class Ciclista implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short dorsal;
    @Column
    private Date nacimiento;
    @Column
    private String nombre;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "nomeq")
    private Equipo equipo;

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.DETACH)
    private List<Etapa> etapa;

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.ALL)
    private List<Puerto> puerto;

    public Ciclista() {
    }

    public short getDorsal() {
        return dorsal;
    }

    public void setDorsal(short dorsal) {
        this.dorsal = dorsal;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Etapa> getEtapa() {
        return etapa;
    }

    public void setEtapa(List<Etapa> etapa) {
        this.etapa = etapa;
    }

    public List<Puerto> getPuerto() {
        return puerto;
    }

    public void setPuerto(List<Puerto> puerto) {
        this.puerto = puerto;
    }
}
