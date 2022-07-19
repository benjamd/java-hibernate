package ar.com.benjamd.web;

import ar.com.benjamd.domain.Alumno;
import ar.com.benjamd.domain.Contacto;
import ar.com.benjamd.domain.Domicilio;
import ar.com.benjamd.servicio.ServicioAlumno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String calle = req.getParameter("calle");
        String numeroCalle = req.getParameter("noCalle");
        String pais = req.getParameter("pais");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNumeroCalle(numeroCalle);
        domicilio.setPais(pais);
        
        Contacto contacto = new Contacto();
        contacto.setEmail(email);
        contacto.setTelefono(telefono);
        
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        servicioAlumno.guardarAlumno(alumno);
        
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
