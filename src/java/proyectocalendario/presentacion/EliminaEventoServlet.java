/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proyectocalendario.entitys.Evento;
import proyectocalendario.persistencia.EventoSessionBean;

/**
 *
 * @author Oscar
 */
@WebServlet(name = "EliminaEventoServlet", urlPatterns = {"/eliminaEvento"})
public class EliminaEventoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminaEventoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminaEventoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @EJB
    private EventoSessionBean objEventoSessionbean;
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        int codigoEvento = Integer.parseInt(request.getParameter("codigoEvento"));
        
        try {
            Evento infoEvento = this.objEventoSessionbean.buscaEventoXCodigo(codigoEvento);    
            if (infoEvento != null) {
                this.objEventoSessionbean.deleteEvento(codigoEvento);
                response.sendRedirect("mantenedorEvento.jsp");
            } else {
                sesion.setAttribute("msgError", "no existe información a eliminar, problemas asociados ");
                response.sendRedirect("mantenedorEvento.jsp");
            }

        } catch (Exception ex) {
            sesion.setAttribute("msgError", "no se pudo eliminar, problemas asociados " + ex.getLocalizedMessage());
            response.sendRedirect("mantenedorEvento.jsp");
        }                   
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
