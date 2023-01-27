package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;

public class _01c02EtapasGanadasPorCiclista {

    public _01c02EtapasGanadasPorCiclista(short id) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Ciclista ciclista = (Ciclista) sesion.get(Ciclista.class, id);
        for (int i = 0; i < ciclista.getEtapa().size(); i++) {
            System.out.println("El ciclista " + ciclista.getNombre() + " salio de " + ciclista.getEtapa().get(i).getSalida() + " y llegaron a " + ciclista.getEtapa().get(i).getLlegada() + ".");
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
}
