package controller;

import database.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;



@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String flag = request.getParameter("flag");

        // LOGIN
        if ("login".equals(flag)) {
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");

    try {
        Usuario u = new Usuario();
        Usuario userLogged = u.efetuarLogin(email, senha);

        if (userLogged != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userLogged", userLogged);
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        } else {
            request.setAttribute("autenticado", false);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.err.println("Erro no login: " + e);
    }
}

        // CADASTRO DE NOVO USUÁRIO
        if ("salvar".equals(flag)) {
            String nome = request.getParameter("usuario");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String instituicao = request.getParameter("instituicao");
            String curso = request.getParameter("curso");

            Usuario u = new Usuario();
            u.setNomeUsuario(nome);
            u.setEmail(email);
            u.setSenhaUsuario(senha);
            u.setInstituicao(instituicao);
            u.setCurso(curso);

            try {
                UsuarioDAO ud = new UsuarioDAO();
                ud.novoUsuario(u);
                request.setAttribute("flag", "ok");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Erro ao salvar usuário: " + e);
                request.setAttribute("flag", "erro");
            }

            request.getRequestDispatcher("index.jsp")
                    .forward(request, response);
        }

        // SAIR (LOGOUT)
        if ("sair".equals(flag)) {
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
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
