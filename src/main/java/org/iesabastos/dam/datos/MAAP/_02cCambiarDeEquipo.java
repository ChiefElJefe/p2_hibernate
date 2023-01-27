package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

public class _02cCambiarDeEquipo {
    public _02cCambiarDeEquipo(short id, String nuevoEquipo) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();
            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();
            Ciclista ciclista = (Ciclista) sesion.get(Ciclista.class, id);
            Equipo equipo = (Equipo) sesion.get(Equipo.class, nuevoEquipo);
            if (ciclista.getEquipo().getNomeq().equals(nuevoEquipo)) {
                System.out.println("Error, el nombre del equipo es el mismo.");
                sesion.getTransaction().rollback();
                sesion.close();
            } else {
                ciclista.setEquipo(equipo);
                sesion.save(ciclista);
                sesion.getTransaction().commit();
                sesion.close();
            }
        }catch (ConstraintViolationException e){
            System.out.println("El equipo introducido no existe");
        }catch (NullPointerException e){
            System.out.println("El dorsal introducido no existe");
        }
    }
}
