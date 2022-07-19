package test;

import ar.com.benjamd.domain.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class HolaMundoHibernate {
    public static void main(String[] args) {
        
        String hql = "SELECT p from Persona p";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateHolaMundo");
        EntityManager  entityManager = factory.createEntityManager();
        
        Query query = entityManager.createQuery(hql);
        List<Persona> personas = query.getResultList();
        
        for(Persona p: personas){
            System.out.println("persona: " + p);
        }
        
        
        entityManager.close();
        
    }
}
