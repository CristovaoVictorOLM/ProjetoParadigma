/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.*;
import Conexao.*;
import Controlador.*;
import DAO.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ricardoricrob
 */
public class ServletListagemEndereco extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        Fachada myFacade = new Fachada();
        Endereco myObj = new Endereco();
	int status = 0;

            ArrayList<Endereco> listagemgeral = new ArrayList<Endereco>();
            listagemgeral  = myFacade.listagemGeralEndereco();
            if (listagemgeral!=null){
                for (Iterator<Endereco> it = listagemgeral.iterator(); it.hasNext();) {
                    Endereco municipio = it.next();
                    System.out.println("Listar Tipos de An?ncios: " + municipio.getbairro());
                }

                request.getSession().setAttribute("listagemgeral",(Endereco[]) listagemgeral.toArray(new Endereco[0]));
                request.setAttribute("listagemgeral",listagemgeral);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/list-gerenciar_tipoanuncio.jsp");
                rd.forward(request,response);
            }


    } 

    // <editor-fold defaultstate="collapsed" desc="M?todos HttpServlet. Clique no sinal de + ? esquerda para editar o c?digo.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
