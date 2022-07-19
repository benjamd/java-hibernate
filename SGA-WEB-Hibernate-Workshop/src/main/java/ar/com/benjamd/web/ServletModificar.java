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
import javax.servlet.http.HttpSession;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAlumnoSTR = req.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnoSTR);

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        ServicioAlumno servicioAlumno = new ServicioAlumno();
        Alumno alumnoEncontrado = servicioAlumno.buscarAlumnoPorId(alumno);

        //req.setAttribute("alumno", alumnoEncontrado);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("alumno", alumnoEncontrado);

        req.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String modificar = req.getParameter("Modificar");
        ServicioAlumno servicioAlumno = new ServicioAlumno();
            
        if (modificar != null) {

            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String calle = req.getParameter("calle");
            String numeroCalle = req.getParameter("noCalle");
            String pais = req.getParameter("pais");
            String email = req.getParameter("email");
            String telefono = req.getParameter("telefono");

            HttpSession sesion = req.getSession();
            Alumno alumno = (Alumno) sesion.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNumeroCalle(numeroCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

           servicioAlumno.guardarAlumno(alumno);

            sesion.removeAttribute("alumno");
        } else {
            //caso eliminar
            String idAlumnoSTR = req.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoSTR);
            Alumno alumno = new Alumno(idAlumno);
            servicioAlumno.eliminarAlumno(alumno);
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
