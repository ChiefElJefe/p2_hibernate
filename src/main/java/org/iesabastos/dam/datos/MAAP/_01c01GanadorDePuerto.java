package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;

public class _01c01GanadorDePuerto {
    public _01c01GanadorDePuerto(String nombrePuerto) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Puerto puerto = (Puerto) sesion.get(Puerto.class, nombrePuerto);
        System.out.println("El ganador del puerto " + puerto.getNompuerto() + " se llama " + puerto.getCiclista().getNombre());
        System.out.println();
        sesion.getTransaction().commit();
        sesion.close();
    }
}
