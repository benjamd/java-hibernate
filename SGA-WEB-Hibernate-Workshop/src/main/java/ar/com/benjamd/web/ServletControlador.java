package ar.com.benjamd.web;

import ar.com.benjamd.domain.Alumno;
import ar.com.benjamd.servicio.ServicioAlumno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        
        List<Alumno> alumnos = servicioAlumno.listarAlumnos();
        req.setAttribute("alumnos", alumnos);
        
        req.getRequestDispatcher("/WEB-INF/listarAlumnos.jsp").forward(req, resp);
        
        
        
    }
    
    
    
}
