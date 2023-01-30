package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _06HQLVariasTablas {
    public _06HQLVariasTablas() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query busqueda = sesion.createQuery("select a.llegada, a.salida, b.nombre from Etapa as a left outer join a.ciclista as b");
        List<Object[]> etapas = busqueda.list();
        for (int i = 0; i < etapas.size(); i++) {
            System.out.println(etapas.get(i)[0] + " " + etapas.get(i)[1] + " " + etapas.get(i)[2]);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _06HQLVariasTablas(int a) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query busqueda = sesion.createQuery("select b.nomeq, b.director, count(a.nombre) from Ciclista as a left outer join a.equipo as b group by a.equipo");
        List<Object[]> etapas = busqueda.list();
        for (int i = 0; i < etapas.size(); i++) {
            System.out.println(etapas.get(i)[0] + " " + etapas.get(i)[1] + " " + etapas.get(i)[2]);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
}
