package ar.com.benjamd.test;

import ar.com.benjamd.dao.AlumnoDAO;
import ar.com.benjamd.dao.AsignacionDAO;
import ar.com.benjamd.dao.ContactoDAO;
import ar.com.benjamd.dao.CursoDAO;
import ar.com.benjamd.dao.DomicilioDAO;
import java.util.List;

public class TestDAOs {

    public static void main(String[] args) {
        
        AlumnoDAO alumnoDao = new AlumnoDAO();
        System.out.println("\nAlumnos:");
        imprimir(alumnoDao.listar());
        
        DomicilioDAO domicilioDao = new DomicilioDAO();
        System.out.println("\nDomicilios:");
        imprimir(domicilioDao.listar());
        
        ContactoDAO contactoDao = new ContactoDAO();
        System.out.println("\nContactos:");
        imprimir(contactoDao.listar());
        
        CursoDAO cursoDao = new CursoDAO();
        System.out.println("\nCursos:");
        imprimir(cursoDao.listar());
        
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        System.out.println("\nAsignaciones:");
        imprimir(asignacionDAO.listar());
        
        
        
          
    }
    
    
    public static void imprimir (List coleccion){
        
        for (Object o: coleccion) {
            System.out.println("valor = " + o);
        }
        
        
    }
}
