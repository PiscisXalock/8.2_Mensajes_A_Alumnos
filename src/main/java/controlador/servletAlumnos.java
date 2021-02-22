/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Alumno;
import Modelo.Utilidades;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose
 */
public class servletAlumnos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    private String rutaFicheros;
    private ArrayList<String> grupos;
      
   public void init(ServletConfig config)
          throws ServletException {
       grupos = new ArrayList<String>();
       grupos.add("2DAW_A");
       grupos.add("2DAW_B");
       rutaFicheros = config.getServletContext().getRealPath("").concat(File.separator).concat("ficheros");

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
        String grupoInicial = "2DAW_A";
        if ( request.getParameter("grupo")!=null ) {
            grupoInicial = request.getParameter("grupo");
        }
        String archivoAsociado="";
        switch ( grupoInicial ) {
            case "2DAW_A": 
                archivoAsociado = "2daw_a"; // -.txt
                break;
            case "2DAW_B": 
                archivoAsociado = "2daw_b";
                break;
        }
        String fichero = this.rutaFicheros.concat(File.separator).concat(archivoAsociado);
        ArrayList<Alumno> alumnos = Utilidades.getAlumnos(fichero);
        request.setAttribute("grupo", grupoInicial);
        request.setAttribute("grupos", grupos);
        request.setAttribute("alumnos", alumnos);
        request.getRequestDispatcher("alumnos.jsp").forward(request, response);
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
