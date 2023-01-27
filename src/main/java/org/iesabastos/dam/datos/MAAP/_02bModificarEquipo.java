package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;

public class _02bModificarEquipo {
    public _02bModificarEquipo(String nombreEquipo, String nuevoDirector) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();
            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();
            Equipo equipo = (Equipo) sesion.get(Equipo.class, nombreEquipo);
            equipo.setDirector(nuevoDirector);
            sesion.save(equipo);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (NullPointerException e){
            System.out.println("El equipo introducido no existe");
        }

    }
}
