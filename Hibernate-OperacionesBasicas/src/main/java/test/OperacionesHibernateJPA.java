package test;

import ar.com.benjamd.dao.PersonaDAO;
import ar.com.benjamd.domain.Persona;

public class OperacionesHibernateJPA {

    public static void main(String[] args) {

        PersonaDAO personaDao = new PersonaDAO();
        personaDao.listar();

        /*
        Persona persona1 = new Persona();
        persona1.setNombre("Nadia");
        persona1.setEmail("nadu92@gmail.com");
        persona1.setTelefono("42780923");
        personaDao.insertar(persona1);
         */
        Persona personaModificar = new Persona();
        personaModificar.setIdPersona(24);
        personaModificar = personaDao.buscarPersonaPorId(personaModificar);
        System.out.println("personaModificar = " + personaModificar);
        personaModificar.setApellido("Alvarez");
        personaModificar.setEmail("nadualva92@gmail.com");
        personaDao.modificar(personaModificar);
        System.out.println("personaModificar = " + personaModificar);

        personaDao.listar();

        Persona personaEliminar = new Persona();
        personaEliminar.setIdPersona(24);
        personaDao.eliminar(personaEliminar);

        personaDao.listar();

        personaDao.close();
    }
}
