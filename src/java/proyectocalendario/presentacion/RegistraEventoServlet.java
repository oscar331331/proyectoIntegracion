/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.presentacion;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proyectocalendario.dto.eventoDTO;
import proyectocalendario.persistencia.EventoSessionBean;

/**
 *
 * @author Vito
 */
@WebServlet(name = "RegistraEventoServlet", urlPatterns = {"/RegistraEventoServlet","/registraEvento"})
public class RegistraEventoServlet extends HttpServlet {
@EJB
private EventoSessionBean objEventoSessionBeans;
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
            out.println("<title>Servlet RegistraEventoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistraEventoServlet at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        String urlLink="";
        try {
                                    org.tempuri.WebService service = new org.tempuri.WebService();
                                    org.tempuri.WebServiceSoap port = service.getWebServiceSoap();
                                     // TODO initialize WS operation arguments here
                                    java.lang.String titulo = request.getParameter("txtTitulo");
                                    java.lang.String descripcion = request.getParameter("txtDescripcion");
                                    java.lang.String sala = request.getParameter("txtSala");
                                    
                                    String fecha = request.getParameter("fecha");
                                    DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
                                    Date fechaCal = df.parse(fecha);
                                    DateFormat fecha3 = new SimpleDateFormat("yyyyMMdd");
                                    java.lang.String inicio = fecha3.format(fechaCal);
                                    fechaCal.setDate(fechaCal.getDate()+1);
                                   
                                   titulo=titulo.replace(" ", "%20");
                                   sala=sala.replace(" ", "%20");
                                   descripcion=descripcion.replace(" ", "%20");
                                    
                                    String fin = fecha3.format(fechaCal);
                                    
                                    // TODO process result here
                                    java.lang.String result = port.nuevoLink(titulo, descripcion, sala, inicio,fin);
                                    urlLink=result;
                                    
                                } catch (Exception ex) {
                                    // TODO handle custom exceptions here
                                }
        String nombre=request.getParameter("txtTitulo");
        String descripcion=request.getParameter("txtDescripcion");
        String sala=request.getParameter("txtSala");
        String seccion=request.getParameter("txtSala");
        String fecha = request.getParameter("fecha");
        
        String urlFinal=urlLink;
        
        
        eventoDTO infoEventoDTO=new eventoDTO(0,nombre, descripcion, sala, fecha, urlFinal, seccion);
        try{
            this.objEventoSessionBeans.addEvento(infoEventoDTO);
            response.sendRedirect("mantenedorEvento.jsp");
        }catch(Exception ex){
            sesion.setAttribute("msgError", ex);
            response.sendRedirect("mantenedorEvento.jsp");
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
