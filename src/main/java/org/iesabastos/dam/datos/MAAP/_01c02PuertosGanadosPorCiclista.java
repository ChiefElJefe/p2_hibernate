package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;

public class _01c02PuertosGanadosPorCiclista {
    public _01c02PuertosGanadosPorCiclista(short id) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Ciclista ciclista = (Ciclista) sesion.get(Ciclista.class, id);
        for (int i = 0; i < ciclista.getPuerto().size(); i++) {
            System.out.println("El ciclista " + ciclista.getNombre() + " gano el puerto " + ciclista.getPuerto().get(i).getNompuerto() + ", con una altura de " + ciclista.getPuerto().get(i).getAltura() + " y es de categoria " + ciclista.getPuerto().get(i).getCategoria());
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
}
