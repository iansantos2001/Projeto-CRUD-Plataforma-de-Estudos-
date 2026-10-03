<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/registro_usuario.css"/>
        <title>EduConnect - Cadastrar</title>
    </head>
    <body>
        
        <aside>
            <h1>EduConnect</h1>
            <p>PLANO FOCO EVOLUÇÃO</p>
            <h2>Crie sua conta e comece a transformar seus estudos.</h2>
            <h2>🎒 📚</h2>
        </aside>
        
        <main>
        <h1>Criar uma conta</h1>
        <form action="UsuarioController" method="post">
            <input type="hidden" name="flag" value="salvar">
            
            <input type="text" name="usuario" id="usuario" placeholder="Nome completo" required >
            <br><br>
            <input type="email" name="email" id="email" placeholder="Seu E-mail" required >
            <br><br>
            <input type="text" name="instituicao" id="instituicao" placeholder="Instituição de ensino" >
            <br><br>
            <input type="text" name="curso" id="curso" placeholder="Nome do seu curso" >
            <br><br>
            
            <div>
                <input type="password" name="senha" id="senha" placeholder="Senha" required >
                <button id="btn-senha" type="button">Mostrar</button>
            </div>
            
            <br>
            
            <div>
                <input type="password" name="senha-conf" id="senha-conf" placeholder="Confirme a senha" required >
                <button id="btn-senha-conf" type="button">Mostrar</button>
            </div>
            
            <br><br>
            <input type="submit" value="Cadastrar">
            <br><br>
            <span>Já tem uma conta? </span>
            <a href="index.jsp"> Faça login aqui! </a>
        </form>
        
        <script>
            const senha = document.getElementById("senha");
            const senhaConf = document.getElementById("senha-conf");
            const btnSenha = document.getElementById("btn-senha");
            const btnSenhaConf = document.getElementById("btn-senha-conf");
            
            console.log(btnSenha);
            
            btnSenha.addEventListener("click", ()=>{
                if( senha.type === "text" ) {
                    senha.type = "password";
                    btnSenha.innerHTML = "Mostrar";
                } else {
                    senha.type = "text";
                    btnSenha.innerHTML = "Esconder";
                }
            });
            
            btnSenhaConf.addEventListener("click", ()=>{
                if( senhaConf.type === "text" ) {
                    senhaConf.type = "password";
                    btnSenhaConf.innerHTML = "Mostrar";
                } else {
                    senhaConf.type = "text";
                    btnSenhaConf.innerHTML = "Esconder";
                }
            });
        </script>
        <footer>
            <hr>
                <small> 2026 - Nenhum direito reservado &COPY; </small>
        </footer>
        </main>
    </body>
</html>