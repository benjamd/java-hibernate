package ar.com.benjamd.test.cascade;

import ar.com.benjamd.domain.Alumno;
import ar.com.benjamd.domain.Contacto;
import ar.com.benjamd.domain.Domicilio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenciaCascadaTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Nogales");
        domicilio.setNumeroCalle("10");
        domicilio.setPais("Mexico");

        Contacto contacto = new Contacto();
        contacto.setEmail("clara@hotmail.com");
        contacto.setTelefono("1353519843");

        Alumno alumno = new Alumno();
        alumno.setNombre("Carlos");
        alumno.setApellido("Lara");
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);

        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();

        System.out.println("alumno = " + alumno);

    }

}
