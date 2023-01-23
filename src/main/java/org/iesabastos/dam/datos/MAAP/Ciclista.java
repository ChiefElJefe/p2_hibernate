package org.iesabastos.dam.datos.MAAP;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
}
