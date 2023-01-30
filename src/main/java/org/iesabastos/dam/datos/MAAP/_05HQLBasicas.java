package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;

public class _05HQLBasicas {
    public _05HQLBasicas() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query busqueda = sesion.createQuery("from Ciclista a where a.nacimiento between '1979-01-01' and '1980-12-31'");
        ArrayList<Ciclista> ciclistas = (ArrayList<Ciclista>) busqueda.list();
        for (int i = 0; i < ciclistas.size(); i++) {
            System.out.println(""+ciclistas.get(i).getNombre());
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _05HQLBasicas(int i) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query busqueda = sesion.createQuery("select count(*) from Ciclista a ");
        long a = (long) busqueda.uniqueResult();
        System.out.println(""+a);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _05HQLBasicas(long a) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query busqueda = sesion.createQuery("select count(nombre) from Ciclista a where a.equipo='Banesto'");
        a = (long) busqueda.uniqueResult();
        System.out.println(""+a);
        sesion.getTransaction().commit();
        sesion.close();
    }
}
