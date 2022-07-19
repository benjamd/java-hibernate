package ar.com.benjamd.test.ciclodevida;

import ar.com.benjamd.domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Estado2RecuperarObjetoPersistente {

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


        //Recuperar objeto en la base de datos
        contacto = em.find(Contacto.class, 3);

        //em.getTransaction().commit();

        
        //Estado Detached (Separado de la base de datos)
        System.out.println("contacto = " + contacto);

    }

}
