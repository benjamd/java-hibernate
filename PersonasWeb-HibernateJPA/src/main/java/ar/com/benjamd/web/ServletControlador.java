package ar.com.benjamd.web;

import ar.com.benjamd.domain.Persona;
import ar.com.benjamd.servicio.ServicioPersonas;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServicioPersonas servicioPersonas = new ServicioPersonas();

        List<Persona> personas = servicioPersonas.listarPersonas();

        req.setAttribute("personas", personas);

        try {
            req.getRequestDispatcher("/WEB-INF/listado.jsp").forward(req, resp);
        } catch (ServletException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
