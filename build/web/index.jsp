<%
    String flag = "";
if( request.getAttribute("flag") != null ) {
    flag = (String)request.getAttribute("flag"); 
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/index.css"/>
        <title>EduConnect - Entrar</title>
    </head>
    <body>
        
        <aside>
            <h1>EduConnect</h1>
            <p>PLANO FOCO EVOLUÇÃO</p>
            <h1>Bem-vindo Estudante!</h1>
            <h2>Faça um login para continuar sua jornada de estudo.</h2>
        </aside>
        
        <main>
        <h1>LOGIN</h1>
        <form action="UsuarioController" method="post">
            <input type="hidden" name="flag" value="login">
            
            <input type="email" name="email" id="email" placeholder="E-mail" required >
            <br><br>
            <input type="password" name="senha" id="senha" placeholder="Senha" required >
            <br><br>
            <input type="submit" value="Entrar">
            <br><br>
            <span>Não tem uma conta? </span>
            <br>
            <a href="registro-usuario.jsp"> Cadastre-se aqui!</a>
        </form>
        
        <%
        if(request.getAttribute("flag") != null) {
            if( flag.equals("ok") ) {
                out.print("<script>"
                        + "alert('Usuário cadastrado com sucesso!')"
                        + "</script>");
            } else {
                out.print("<script>"
                        + "alert('Ocorreu algum erro no cadastro :(')"
                        + "</script>");
            }
        }
        
        if( request.getAttribute("autenticado") != null && 
                !(boolean)request.getAttribute("autenticado")){
            out.print("<script>"
                    + "alert('E-mail ou senha incorretos.')"
                    + "</script>");
        }
        %>
        </main>
    </body>
</html>