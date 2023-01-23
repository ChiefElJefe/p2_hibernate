package org.iesabastos.dam.datos.MAAP;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {
    @Id
    private String nomeq;
    @Column
    private String director;
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.DETACH)
    List<Ciclista> ciclista;

    public Equipo() {
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getNomeq() {
        return nomeq;
    }

    public void setNomeq(String nomeq) {
        this.nomeq = nomeq;
    }

    public List<Ciclista> getCiclista() {
        return ciclista;
    }

    public void setCiclista(List<Ciclista> ciclista) {
        this.ciclista = ciclista;
    }
}
