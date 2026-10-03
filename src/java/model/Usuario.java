package model;

import database.UsuarioDAO;
import java.sql.SQLException;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String email;
    private String senhaUsuario;
    private String instituicao;
    private String curso;

    public Usuario(){}

    public Usuario(int idUsuario, String nomeUsuario, String email, String senhaUsuario, String instituicao, String curso) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senhaUsuario = senhaUsuario;
        this.instituicao = instituicao;
        this.curso = curso;
    }

    public Usuario(String nomeUsuario, String email, String senhaUsuario, String instituicao, String curso) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senhaUsuario = senhaUsuario;
        this.instituicao = instituicao;
        this.curso = curso;
    }
    


    public int getIdUsuario() { 
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) { 
        this.idUsuario = idUsuario; 
    }

    public String getNomeUsuario() { 
        return nomeUsuario; 
    }
    
    public void setNomeUsuario(String nomeUsuario) { 
        this.nomeUsuario = nomeUsuario; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getSenhaUsuario() { 
        return senhaUsuario; 
    }
    
    public void setSenhaUsuario(String senhaUsuario) { 
        this.senhaUsuario = senhaUsuario; 
    }

    public String getInstituicao() { 
        return instituicao; 
    }
    
    public void setInstituicao(String instituicao) { 
        this.instituicao = instituicao; 
    }

    public String getCurso() { 
        return curso; 
    }
    
    public void setCurso(String curso) { 
        this.curso = curso; 
    }

    // O Model chama o DAO para efetuar o login
    public Usuario efetuarLogin(String email, String senha) throws ClassNotFoundException, SQLException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = dao.selecionaPorEmail(email);

        
        if (user != null && senha.equals(user.getSenhaUsuario())) {
            return user; // Retorna o usuário logado
        }
        return null; // Login incorreto
    }

    // O Model chama o DAO para salvar um novo usuário - Faz sentido isso existir?
//    public void salvar() throws ClassNotFoundException, SQLException {
//        UsuarioDAO dao = new UsuarioDAO();
//        dao.novoUsuario(this);
//    }
    
@Override
public String toString() {
    return "Usuario{" + "idUsuario=" + idUsuario
            + ", nomeUsuario=" + nomeUsuario
            + ", email=" + email
            + ", senhaUsuario=" + senhaUsuario
            + ", instituicao=" + instituicao
            + ", curso=" + curso + '}';
    }
}