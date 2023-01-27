package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;

public class _02aCrearEquipo {
    public _02aCrearEquipo(String nombreEquipo, String nombreDirector) {
        Equipo equipo = new Equipo();
        equipo.setNomeq(nombreEquipo);
        equipo.setDirector(nombreDirector);

        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();
            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();
            sesion.save(equipo);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (ConstraintViolationException e){
            System.out.println("El equipo que esta intentado introducir ya existe.");
        }

    }
}
