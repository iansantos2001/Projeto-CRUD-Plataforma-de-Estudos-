<%@page import="model.Usuario"%>
<%
Usuario u = new Usuario();
    
if( session.getAttribute("userLogged") == null ){
    response.sendRedirect("index.jsp");
} else {
    u = (Usuario)session.getAttribute("userLogged");
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/perfil.css"/>
        <title>EduConnect - Perfil</title>
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
        <h1>⚙️ Perfil</h1>
        <br><br>
        <h2>Sobre mim</h2>
        <p><strong>Instituição:</strong> <%= u.getInstituicao() != null ? u.getInstituicao() : "Não informada" %></p>
        <p><strong>Curso:</strong> <%= u.getCurso() != null ? u.getCurso() : "Não informado" %></p>
        <p><strong>E-mail:</strong> <%= u.getEmail() %></p>
        
        <button type="button" onclick="window.location.href='UsuarioController?flag=sair'"> Sair </button>
        
        </main>
    </body>
</html>
