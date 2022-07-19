package ar.com.benjamd.servicio;

import ar.com.benjamd.dao.PersonaDAO;
import ar.com.benjamd.domain.Persona;
import java.util.List;


public class ServicioPersonas {
   
    private PersonaDAO personaDao;
    
    public ServicioPersonas(){
            this.personaDao = new PersonaDAO();
    }
            
            
    public List<Persona> listarPersonas(){
        return this.personaDao.listar();
    }

    public Persona buscarPersonaPorId(Persona persona){
        return this.personaDao.buscarPersonaPorId(persona);
                
    }
    
    public void modificarPersona(Persona persona){
        this.modificarPersona(persona);
    }
    
    public void insertarPersona(Persona persona){
        this.personaDao.insertar(persona);
    }

    public void eliminar(Persona persona){
        this.personaDao.eliminar(persona);
    }

}
