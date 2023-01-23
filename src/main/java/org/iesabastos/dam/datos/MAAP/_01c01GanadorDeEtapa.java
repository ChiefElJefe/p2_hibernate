package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;

public class _01c01GanadorDeEtapa {

    public _01c01GanadorDeEtapa(short id) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Session sesion = HibernateUtil.getCurrentSession();
        Etapa etapa =(Etapa) sesion.get(Etapa.class, id);
        System.out.println("El ganador de la Etapa " + etapa.getNetapa() + " es el ciclista " + etapa.getCiclista().getNombre());
        sesion.close();
    }
}
