package ar.com.benjamd.test.ciclodevida;

import ar.com.benjamd.domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Estado3MoficarObjetoPersistente {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //Definimos la variable
        Contacto contacto = null;

        /*
            Si lo recuperamos el objeto dentro de la transaccion podemos
            esta en estado Persist y modemos grabar cambios al hacer flush o commit
         */
        //em.getTransaction().begin();
        //1. Recuperar objeto en la base de datos
        //Estado Detached
        contacto = em.find(Contacto.class, 3);

        //modificamos el objeto
        //em.getTransaction().commit();
        //Estado Detached (Separado de la base de datos)
        System.out.println("contacto = " + contacto);

        contacto.setEmail("clara@hotmail.com");

        em.getTransaction().begin();

        //2. Persistimos el objeto
        //Estado Persistente
        em.merge(contacto);

        em.getTransaction().commit();

        //3. Estado Detached (Separado)
        System.out.println("contacto = " + contacto);

    }

}
