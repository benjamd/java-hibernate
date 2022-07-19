package ar.com.benjamd.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {
    
   private static final long serialVersionUID = 1L;
   
   @Column(name = "id_persona")
   @Id
   private int idPersona;
   
   private String nombre;
   
   private String email;
   
   private String telefono;

    public Persona() {
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("idPersona=").append(idPersona);
        sb.append(", nombre=").append(nombre);
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }




   
}
