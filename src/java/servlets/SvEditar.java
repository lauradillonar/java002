package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Persona;

@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {
    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int id_editar = Integer.parseInt(request.getParameter("id_editar"));
        Persona person = control.buscarPersona(id_editar);
        HttpSession miSession = request.getSession();
        miSession.setAttribute("persona", person);
        response.sendRedirect("editarPersona.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int id_editar = Integer.parseInt(request.getParameter("id"));
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        Persona per = new Persona(id_editar,dni,nombre,apellido,telefono);
        control.editarPersona(per);
        request.getSession().setAttribute("listaPersonas", control.traerPersonas());
        response.sendRedirect("verPersonas.jsp");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
