package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConn();
    }

    public void novoUsuario(Usuario u) throws SQLException {
        String query = "INSERT INTO usuario(nome_usuario, email, senha_usuario, instituicao, curso)" +
                "VALUES(?, ?, ?, ?, ?);";
        PreparedStatement p = conn.prepareStatement(query);
        p.setString(1, u.getNomeUsuario());
        p.setString(2, u.getEmail());
        p.setString(3, u.getSenhaUsuario());
        p.setString(4, u.getInstituicao());
        p.setString(5, u.getCurso());
        
        p.execute();
        conn.close();
    }

    public Usuario selecionaPorEmail(String email) throws SQLException {
        String query = "SELECT * FROM usuario WHERE email = ?;";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, email);
        ResultSet res = prep.executeQuery();

        Usuario u = new Usuario(); // Diferente da ver. agenda
        
        if (res.next()) {
            u.setIdUsuario(res.getInt("id_usuario"));
            u.setNomeUsuario(res.getString("nome_usuario"));
            u.setEmail(res.getString("email"));
            u.setSenhaUsuario(res.getString("senha_usuario"));
            u.setInstituicao(res.getString("instituicao"));
            u.setCurso(res.getString("curso"));
        }
        prep.close();
        return u;
    }
}