<%@page import="java.util.ArrayList"%>
<%@page import="model.Disciplina"%>
<%@page import="database.DisciplinaDAO"%>
<%@page import="model.Usuario"%>
<%
Usuario u = new Usuario();

if( session.getAttribute("userLogged") == null ){
    response.sendRedirect("index.jsp");
} else {
    u = (Usuario)session.getAttribute("userLogged");
}

DisciplinaDAO dao = new DisciplinaDAO();
ArrayList<Disciplina> lista = dao.selecionaTodas();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/disciplina.css"/>
        <title>Disciplinas</title>
    </head>
    <body>
        
        <aside>
            <h2>Menu do Estudante</h2>
            <br>
            
             <a href="inicio.jsp">🏠 Inicio </a>
            <br>
             <a href="disciplinas.jsp">📚 Disciplinas </a>
            <br>
             <a href="grupo.jsp">👥 Grupo </a>
            <br>
             <a href="agenda.jsp">🗓️ Agenda </a>
            <br>
             <a href="progresso.jsp">📈 Progresso </a>
            <br>
             <a href="perfil.jsp">👤 Perfil </a>
        </aside>
        
        <main>
        <h1>Disciplinas</h1>
        <p>Usuário logado: <strong><%= u.getNomeUsuario() %></strong> | <a href="inicio.jsp">Voltar</a></p>
        
        <form action="DisciplinaController" method="post" onsubmit="return confirm('Confirma a alteração da disciplina?')">
            <input type="hidden" name="flag" id="flag" value="salvar">
            <input type="hidden" name="id" id="id" value="0">

            <input type="text" name="nome_disciplina" id="nome_disciplina" placeholder="Nome da disciplina" required>
            <br><br>

            <textarea name="descricao_disciplina" id="descricao_disciplina" rows="3" cols="30" placeholder="Descrição..."></textarea>
            <br><br>

            <input type="submit" id="btn-submit" value="Cadastrar">
            <button type="button" onclick="limpar()">Cancelar</button>
        </form>

        <hr>

        <h2>Disciplinas Cadastradas</h2>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Ações</th>
            </tr>
            <% for (Disciplina d : lista) { %>
            <tr>
                <td><%= d.getNomeDisciplina() %></td>
                <td><%= d.getDescricaoDisciplina() %></td>
                <td>
                    <button type="button" onclick="prepararEdicao('<%= d.getIdDisciplina() %>', '<%= d.getNomeDisciplina() %>', '<%= d.getDescricaoDisciplina() %>')">Editar</button>
                    <a href="DisciplinaController?flag=excluir&id=<%= d.getIdDisciplina() %>" onclick="return confirm('Excluir disciplina?')">Excluir</a>
                </td>
            </tr>
            <% } %>
        </table>

        <script>
            function prepararEdicao(id, nome, descricao) {
                document.getElementById("flag").value = "editar";
                document.getElementById("id").value = id;
                document.getElementById("nome_disciplina").value = nome;
                document.getElementById("descricao_disciplina").value = descricao;
                document.getElementById("btn-submit").value = "Editar";
            }

            function limpar() {
                document.getElementById("flag").value = "salvar";
                document.getElementById("id").value = "0";
                document.getElementById("nome_disciplina").value = "";
                document.getElementById("descricao_disciplina").value = "";
                document.getElementById("btn-submit").value = "Cadastrar";
            }
        </script>
        </main>
    </body>
</html>