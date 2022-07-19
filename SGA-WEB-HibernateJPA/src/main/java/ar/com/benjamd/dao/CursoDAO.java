package ar.com.benjamd.dao;

import static ar.com.benjamd.dao.GenericDAO.em;
import ar.com.benjamd.domain.Curso;
import java.util.List;
import javax.persistence.Query;

public class CursoDAO extends GenericDAO {


    public List<Curso> listar() {
        String consulta = "SELECT c FROM Curso c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        return query.getResultList();

    }

    public void insertar(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void actualizar(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void eliminar(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(curso));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Curso buscarPorId(Curso curso) {
        em = getEntityManager();
        return em.find(Curso.class, curso.getIdCurso());

    }
    
}
