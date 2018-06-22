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
import proyectocalendario.entitys.Alumno;
import proyectocalendario.persistencia.AlumnoSessionBean;

/**
 *
 * @author Oscar
 */
@WebServlet(name = "ModificarAlumnoServlet", urlPatterns = {"/modificarAlumno"})
public class ModificarAlumnoServlet extends HttpServlet {

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
            out.println("<title>Servlet ModificarAlumnoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarAlumnoServlet at " + request.getContextPath() + "</h1>");
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
    private AlumnoSessionBean objAlumnoSessionbean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int codigoAlumno = Integer.parseInt(request.getParameter("codigoAlumno"));
        try {
            Alumno infoAlumno = this.objAlumnoSessionbean.buscaAlumnoXCodigo(codigoAlumno);
            if (infoAlumno != null) {
                sesion.setAttribute("objetoAeditar", infoAlumno);
                response.sendRedirect("agregarAlumno.jsp");
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
        
        int codigoAlumno = Integer.parseInt(request.getParameter("txtId"));
        String nuevoNombre=request.getParameter("txtNombre");
        String nuevoApellido= request.getParameter("txtApellido");
        String nuevoCorreo= request.getParameter("txtCorreo");
        String nuevoUsuario= request.getParameter("txtUsuario");
        String nuevoPassword= request.getParameter("txtPassword");
        
        try {
            Alumno infoAlumno = this.objAlumnoSessionbean.buscaAlumnoXCodigo(codigoAlumno);    
            if (infoAlumno != null) {
                infoAlumno.setIdAlumno(codigoAlumno);
                infoAlumno.setNombreAlumno(nuevoNombre);
                infoAlumno.setApellidoAlumno(nuevoApellido);
                infoAlumno.setCorreoAlumno(nuevoCorreo);
                infoAlumno.setUsuarioAlumno(nuevoUsuario);
                infoAlumno.setPasswordAlumno(nuevoPassword);
                                
                this.objAlumnoSessionbean.updateAlumno(infoAlumno);
                response.sendRedirect("mantenedorAlumno.jsp");
            } else {
                sesion.setAttribute("msgError", "no existe información a modificar, problemas asociados ");
                response.sendRedirect("mantenedorAlumno.jsp");
            }

        } catch (Exception ex) {
            sesion.setAttribute("msgError", "no se pudo modificar, problemas asociados " + ex.getLocalizedMessage());
            response.sendRedirect("mantenedorAlumno.jsp");
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
