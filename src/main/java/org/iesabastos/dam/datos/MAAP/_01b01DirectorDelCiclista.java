package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class _01b01DirectorDelCiclista {
    //private List<Ciclista> ciclista;

    public _01b01DirectorDelCiclista(/*List<Ciclista> ciclista,*/ short dorsal) {
        //this.ciclista = ciclista;
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        /*Query busqueda = HibernateUtil.getCurrentSession().createQuery("FROM Ciclista");
        this.ciclista = (ArrayList<Ciclista>) busqueda.list();

        for (int i = 0; i < this.ciclista.size(); i++) {
            if (this.ciclista.get(i).getDorsal() == dorsal) {
                System.out.println("El director del ciclista es: " + this.ciclista.get(i).getEquipo().getDirector());
            }
        }*/
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Ciclista ciclista = (Ciclista) sesion.get(Ciclista.class, dorsal);
        System.out.println("El director del ciclista es: " + ciclista.getEquipo().getDirector());
        sesion.getTransaction().commit();
        sesion.close();

    }
}
