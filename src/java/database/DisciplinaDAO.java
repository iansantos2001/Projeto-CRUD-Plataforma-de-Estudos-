package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Disciplina;

public class DisciplinaDAO {
    private Connection conn;

    public DisciplinaDAO() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConn();
    }

    public void novaDisciplina(Disciplina d) throws SQLException {
        String query = "INSERT INTO disciplina(nome_disciplina, descricao_disciplina)" + 
                "VALUES(?, ?);";
        
        PreparedStatement p = conn.prepareStatement(query);
        p.setString(1, d.getNomeDisciplina());
        p.setString(2, d.getDescricaoDisciplina());
        
        p.execute();
        conn.close();
    }

    public ArrayList<Disciplina> selecionaTodas() throws SQLException {
        ArrayList<Disciplina> lista = new ArrayList<>();
        String query = "SELECT * FROM disciplina;";
        
        PreparedStatement prep = conn.prepareStatement(query);
        ResultSet res = prep.executeQuery();

        while (res.next()) {
            Disciplina d = new Disciplina();
            d.setIdDisciplina(res.getInt("id_disciplina"));
            d.setNomeDisciplina(res.getString("nome_disciplina"));
            d.setDescricaoDisciplina(res.getString("descricao_disciplina"));
            lista.add(d);
            System.out.println(d);
        }
        
        prep.close();
        return lista;
    }

    public void atualizaDisciplina(Disciplina d) throws SQLException {
        String query = "UPDATE disciplina SET nome_disciplina = ?, "
                     + "descricao_disciplina = ? "
                     + "WHERE id_disciplina = ?";
        
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, d.getNomeDisciplina());
        prep.setString(2, d.getDescricaoDisciplina());
        prep.setInt(3, d.getIdDisciplina());
        
        prep.execute();
        prep.close();
    }

    public void apagaDisciplina(int id) throws SQLException {
        String query = "DELETE FROM disciplina WHERE id_disciplina = ?";
   
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setInt(1, id);
        prep.executeUpdate();
        prep.close();
    }
}