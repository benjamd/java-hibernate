package ar.com.benjamd.dao;

import ar.com.benjamd.domain.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class PersonaDAO {

    private EntityManagerFactory enf;
    private EntityManager en;

    public PersonaDAO() {
        enf = Persistence.createEntityManagerFactory("HibernatePU");
        en = enf.createEntityManager();

    }

    public void listar() {

        String hql = "SELECT p FROM Persona p";
        Query query = en.createQuery(hql);
        List<Persona> personas = query.getResultList();
        for (Persona p : personas) {
            System.out.println("persona: " + p);
        }
    }

    public void insertar(Persona persona) {

        try {
            en.getTransaction().begin();
            en.persist(persona);
            en.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            en.getTransaction().rollback();
        }
        /*finally {
            if(en != null)
                en.close();
        } */
    }

    public void modificar(Persona persona) {
        try {
            en.getTransaction().begin();
            en.merge(persona);
            en.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            en.getTransaction().rollback();
        }
        /* finally {
            if(en != null)
                en.close();
        }  */
    }

    public Persona buscarPersonaPorId(Persona persona) {

        return en.find(Persona.class, persona.getIdPersona());

    }

    public void eliminar(Persona persona) {
        try {
            en.getTransaction().begin();
            en.remove(en.merge(persona));
            en.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            en.getTransaction().rollback();
        }
        /* finally {
            if(en != null)
                en.close();
        }  */
    }

    public void close() {
        en.close();
    }
}
