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
        <link rel="stylesheet" href="css/inicio.css"/>
        <title>EduConnect - Início</title>
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
        <h1>Olá, <%= u.getNomeUsuario() %>!👋</h1>
        <h3>Pronto para mais um dia de conquista?</h3>
        </main>

        <div class="inicio-card">
        
        </div>
    </body>
</html>