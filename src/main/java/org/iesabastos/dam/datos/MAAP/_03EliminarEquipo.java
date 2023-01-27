package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

public class _03EliminarEquipo {
    public _03EliminarEquipo(String nombreEquipo) {

        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Equipo equipo = (Equipo) sesion.get(Equipo.class, nombreEquipo);
        for (int i = 0; i < equipo.getCiclista().size(); i++) {
            System.out.println(equipo.getCiclista().get(i).getNombre());
            Ciclista ciclista = equipo.getCiclista().get(i);
            sesion.delete(ciclista);
        }
        sesion.delete(equipo);
        sesion.getTransaction().commit();
        sesion.close();


    }
}
