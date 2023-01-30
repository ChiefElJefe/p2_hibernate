package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;

import java.util.ArrayList;

public class _04EliminarEquipoYCambiarCiclistas {
    public _04EliminarEquipoYCambiarCiclistas(String borrarEquipo, String cambioEquipo) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Equipo viejoequipo = (Equipo) sesion.get(Equipo.class, borrarEquipo);
        Equipo nuevoEquipo = (Equipo) sesion.get(Equipo.class, cambioEquipo);
        for (int i = 0; i < viejoequipo.getCiclista().size(); i++) {
            Ciclista ciclista = viejoequipo.getCiclista().get(i);
            nuevoEquipo.getCiclista().add(ciclista);
        }
        viejoequipo.setCiclista(new ArrayList<>());
        sesion.save(nuevoEquipo);
        sesion.delete(viejoequipo);
        sesion.getTransaction().commit();
        sesion.close();
    }
}
