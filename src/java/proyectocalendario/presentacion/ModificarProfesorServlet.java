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
import proyectocalendario.entitys.Profesor;
import proyectocalendario.persistencia.ProfesorSessionBean;

/**
 *
 * @author Oscar
 */
@WebServlet(name = "ModificarProfesorServlet", urlPatterns = {"/modificarProfesor"})
public class ModificarProfesorServlet extends HttpServlet {

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
            out.println("<title>Servlet ModificarProfesorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarProfesorServlet at " + request.getContextPath() + "</h1>");
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
    private ProfesorSessionBean objProfesorSessionbean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int codigoProfesor = Integer.parseInt(request.getParameter("codigoProfesor"));
        try {
            Profesor infoProfesor = this.objProfesorSessionbean.buscaProfesorXCodigo(codigoProfesor);
            if (infoProfesor != null) {
                sesion.setAttribute("objetoAeditar", infoProfesor);
                response.sendRedirect("agregarProfesor.jsp");
            } else {
                sesion.setAttribute("msgError", "GET no existe información a modificar, problemas asociados ");
                response.sendRedirect("Home.jsp");
            }

        } catch (Exception ex) {
            sesion.setAttribute("msgError", "GET no se pudo modificar, problemas asociados " + ex.getMessage());
            response.sendRedirect("Home.jsp");
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
        HttpSession sesion = request.getSession();
        
        int codigoProfesor = Integer.parseInt(request.getParameter("txtId"));
        String nuevoNombre=request.getParameter("txtNombre");
        String nuevoApellido= request.getParameter("txtApellido");
        String nuevoCorreo= request.getParameter("txtCorreo");
        String nuevoUsuario= request.getParameter("txtUsuario");
        String nuevoPassword= request.getParameter("txtPassword");
        
        try {
            Profesor infoProfesor = this.objProfesorSessionbean.buscaProfesorXCodigo(codigoProfesor);    
            if (infoProfesor != null) {
                infoProfesor.setIdProfesor(codigoProfesor);
                infoProfesor.setNombreProfesor(nuevoNombre);
                infoProfesor.setApellidoProfesor(nuevoApellido);
                infoProfesor.setCorreoProfesor(nuevoCorreo);
                infoProfesor.setUsuarioProfesor(nuevoUsuario);
                infoProfesor.setPasswordProfesor(nuevoPassword);
                                
                this.objProfesorSessionbean.updateProfesor(infoProfesor);
                response.sendRedirect("mantenedorProfesor.jsp");
            } else {
                sesion.setAttribute("msgError", "no existe información a modificar, problemas asociados ");
                response.sendRedirect("mantenedorProfesor.jsp");
            }

        } catch (Exception ex) {
            sesion.setAttribute("msgError", "no se pudo modificar, problemas asociados " + ex.getLocalizedMessage());
            response.sendRedirect("mantenedorProfesor.jsp");
        }                  
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
