/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import beans.BeanCadastroCategoriaRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoriaDTO;
import model.ClienteDTO;

/**
 *
 * @author vini1
 */
@WebServlet(name = "CadastraCategoria", urlPatterns = {"/cadastrocategoria"})
public class CadastraCategoria extends HttpServlet {
    @EJB
   private  BeanCadastroCategoriaRemote bean;
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
        response.setContentType("application/json");
 try (PrintWriter out = response.getWriter()) {
            
            /* Pega o que vem no corpo da requisição */
            String textJSON = "";
            try (BufferedReader leitor = request.getReader()) {
                /* monta a string */
                textJSON = leitor.lines().collect(Collectors.joining());
            }
            /* constroi o leitor para construir o json */
            JsonReader reader = Json.createReader(new StringReader(textJSON));
            /* ele pega o json e transforma em um objeto de valores */
            JsonObject dataJSON = reader.readObject();
           
            /* Monta os objetos necessários e usa os dados do JSON para isso */
            /* Cliente */
            CategoriaDTO categoria = new CategoriaDTO();
            categoria.setMarca(dataJSON.getJsonString("marca").getString());
            categoria.setCor(dataJSON.getJsonString("cor").getString());
            categoria.setTipo(dataJSON.getJsonString("tipo").getString());
           
            String msg = bean.cadastroCategoria(categoria) ? "sucesso" : "falha";
            
            JsonObject resposta = Json.createObjectBuilder()
                    .add("mensagem", msg)
                    .build();
            out.println(resposta.toString());
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
        processRequest(request, response);
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
