package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conn;
    
    public static Connection getConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/proj_plataforma_de_estudos_db", 
            "root", 
            ""
        );
        
        System.out.println(conn.getCatalog());
        return conn;
    }
}