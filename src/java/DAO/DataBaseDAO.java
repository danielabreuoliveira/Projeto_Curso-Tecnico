package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseDAO {

    public final String url = "jdbc:mysql://localhost:3306/sisps";
    public final String user = "root";
    public final String senha = "";
    public Connection conn;

    public DataBaseDAO() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public void conectar() throws Exception {
        conn = DriverManager.getConnection(url, user, senha);
    }

    public void desconectar() throws Exception {
        conn.close();
    }
}
