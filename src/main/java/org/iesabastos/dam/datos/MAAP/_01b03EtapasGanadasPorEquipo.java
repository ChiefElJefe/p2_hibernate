package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;

public class _01b03EtapasGanadasPorEquipo {

    public _01b03EtapasGanadasPorEquipo(String nombreEquipo) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Equipo equipo = (Equipo) sesion.get(Equipo.class, nombreEquipo);
        for (int i = 0; i < equipo.getCiclista().size(); i++) {
            System.out.println("El equipo " + equipo.getNomeq() + " con el ciclista " + equipo.getCiclista().get(i).getNombre() + "ha ganado " + equipo.getCiclista().get(i).getEtapa().size() + " etapas.");
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
}

