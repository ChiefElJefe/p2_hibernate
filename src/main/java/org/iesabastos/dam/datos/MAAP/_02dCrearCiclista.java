package org.iesabastos.dam.datos.MAAP;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class _02dCrearCiclista {
    public _02dCrearCiclista(Short id, String nombre, String fecha, String nuevoEquipo) {
        try {
            Ciclista ciclista = new Ciclista();
            ciclista.setDorsal(id);
            ciclista.setNombre(nombre);
            ciclista.setNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse(fecha));
            if (ciclista.getDorsal() < 30){
                System.out.println("Ese dorsal ya existe");
            }else {
                HibernateUtil.buildSessionFactory();
                HibernateUtil.openSession();
                Session sesion = HibernateUtil.getCurrentSession();
                sesion.beginTransaction();
                Equipo equipo = (Equipo) sesion.get(Equipo.class, nuevoEquipo);
                ciclista.setEquipo(equipo);
                sesion.save(ciclista);
                sesion.getTransaction().commit();
                sesion.close();
            }
        }catch (ParseException e){
            System.out.println("Formato de fecha incorrecto");
        } catch (ConstraintViolationException e){
            System.out.println("El equipo no existe");
        }
    }
}
