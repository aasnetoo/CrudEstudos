package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexaoSingleton {

    private static ResourceBundle config;

    private static ConexaoSingleton instance;

    private Connection conn;

    public ConexaoSingleton() {
        config = ResourceBundle.getBundle("config");
    }


    public void getConexao() {
        try {
            String usuario = "postgres";
            String senha = "waer9a0s";
            String ipDoBanco = "localhost:5432";
            String nomeDoBanco = "produtos";
            String stringDeConexao = "jdbc:postgresql://" + ipDoBanco + "/" + nomeDoBanco;
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(stringDeConexao, usuario, senha);
            System.out.println("Conectou no banco de dados.");
        } catch (SQLException ex) {
            System.out.println("Erro: Não conseguiu conectar no BD.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: Não encontrou o driver do BD.");
        }
    }

    public static ConexaoSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConexaoSingleton();
        }
        return instance;
    }



    public Connection getConnection(){
        return conn;
    }

}
