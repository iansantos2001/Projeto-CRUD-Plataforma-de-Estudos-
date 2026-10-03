package controller;

import database.DisciplinaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Disciplina;

@WebServlet(name = "DisciplinaController", urlPatterns = {"/DisciplinaController"})
public class DisciplinaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String flag = request.getParameter("flag");

        if ("salvar".equals(flag)) {
            String nome = request.getParameter("nome_disciplina");
            String descricao = request.getParameter("descricao_disciplina");
            
            Disciplina d = new Disciplina(nome, descricao);
            
            try {
                DisciplinaDAO dao = new DisciplinaDAO();
                dao.novaDisciplina(d);
                request.setAttribute("flag", "ok");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e);
                request.setAttribute("flag", "erro");
            }
            
            request.getRequestDispatcher("disciplinas.jsp").forward(request, response);
        }

        if ("editar".equals(flag)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome_disciplina");
            String descricao = request.getParameter("descricao_disciplina");
            
            Disciplina d = new Disciplina(id, nome, descricao);
            
            try {
                DisciplinaDAO dao = new DisciplinaDAO();
                dao.atualizaDisciplina(d);
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e);
            }
            
            request.getRequestDispatcher("disciplinas.jsp").forward(request, response);
        }

        if ("excluir".equals(flag)) {
            int id = Integer.parseInt(request.getParameter("id"));
            
            try {
                DisciplinaDAO dao = new DisciplinaDAO();
                dao.apagaDisciplina(id);
                request.setAttribute("editar", true);
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e);
                request.setAttribute("editar", false);
            }
            
            request.getRequestDispatcher("disciplinas.jsp").forward(request, response);
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
