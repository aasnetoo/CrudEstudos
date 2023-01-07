package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar("ProdutosLoja","postgres","waer9a0s");
//        conexao.desconectar(conn);
    }

    public Connection conectar (String dbname, String user, String pass){
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if (conn!= null){
                System.out.println("Conexão estabelecida");
            }
            else{
                System.out.println("Conexão falhou");
            }

        }catch(Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public void desconectar(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconectou do banco de dados.");
            }
        } catch (Exception e) {
            System.out.println("Não conseguiu desconectar do BD.");
        }
    }


}
