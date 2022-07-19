package ar.com.benjamd.test.ciclodevida;

import ar.com.benjamd.domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Estado1Persistido {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. Estado Transtivo (Transient)
        Contacto contacto = new Contacto();
        contacto.setEmail("clara");
        contacto.setTelefono("1353519843");
        
        //2. Persistimos el objeto
        em.getTransaction().begin();
        
        em.persist(contacto);
        //sincroniza los objetos en la db dentro de la transaccion
        //em.flush();
        
        em.getTransaction().commit();
        
        //3. Estado Detached (Separado)
        System.out.println("contacto = " + contacto);
        
        
        
        
    }
    
}
