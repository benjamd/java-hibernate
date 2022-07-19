package ar.com.benjamd.test.ciclodevida;

import ar.com.benjamd.domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Estado4EliminarObjeto {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //Definimos la variable
        Contacto contacto = null;

        //1. Recuperar objeto en la base de datos
        //Estado Detached
        contacto = em.find(Contacto.class, 3);

        //Estado Detached (Separado de la base de datos)
        System.out.println("contacto = " + contacto);

       
        em.getTransaction().begin();

        //2. Remove (previo merge para sincronizar objeto con el de la db)
        em.remove(em.merge(contacto));

        em.getTransaction().commit();

        //3. Estado Transient (Transitivo)
        //El estado queda en memoria, no se puede sincronizar con la db
        System.out.println("contacto = " + contacto);

    }

}
