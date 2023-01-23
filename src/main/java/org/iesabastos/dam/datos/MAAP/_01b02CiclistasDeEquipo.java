package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;

public class _01b02CiclistasDeEquipo {
    private Equipo equipo;

    public _01b02CiclistasDeEquipo(String nombre) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        this.equipo = (Equipo) sesion.get(Equipo.class, nombre);
        for (int i = 0; i < this.equipo.getCiclista().size(); i++) {
            System.out.println("Equipo: " + this.equipo.getNomeq() + ", Ciclista: " + this.equipo.getCiclista().get(i).getNombre());
        }
        sesion.getTransaction().commit();
        sesion.close();



    }
}
