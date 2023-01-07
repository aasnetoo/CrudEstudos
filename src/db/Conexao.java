package db;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Conexao instance;

    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;

    private Connection conectar() {
        try {
            String usuario = "postgres";
            String senha = "waer9a0s";
            String ipDoBanco = "localhost:5432";
            String nomeDoBanco = "produtos";
            String stringDeConexao = "jdbc:postgresql://" + ipDoBanco + "/" + nomeDoBanco;
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(stringDeConexao, usuario, senha);
            System.out.println("Conectou no banco de dados.");
        } catch (SQLException ex) {
            System.out.println("Erro: Não conseguiu conectar no BD.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: Não encontrou o driver do BD.");
        }

        return conn;
    }
    public ResultSet executarConsulta(String consulta) {

        conn = conectar();
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
        } catch (SQLException ex) {
            System.out.println("Não conseguiu executar a consulta\n" + consulta);
            //Caso ocorra algum erro desconecta do banco de dados.
            desconectar();
        }

        return rs;
    }

    public ResultSet executarListar (String listar) {
        conn = conectar();
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(listar);
        } catch (SQLException ex) {
            System.out.println("Não conseguiu executar a listagem\n" + listar);
            //Caso ocorra algum erro desconecta do banco de dados.
            desconectar();
        }

        return rs;
    }



    public boolean executeQuery(String query) {
        boolean ok = false;

        conn = conectar();
        try {
            stm = conn.createStatement();
            stm.executeUpdate(query);
            ok = true;
        } catch (SQLException ex) {
            System.out.println("Nao conseguiu executar o DML\n" + query);
        } finally {
            desconectar();
        }

        return ok;
    }

    public void desconectar() {
        fecharResultSet(this.rs);
        fecharStatement(this.stm);
        fecharConnection(this.conn);
    }

    public void fecharConnection(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconectou do banco de dados.");
            }
        } catch (SQLException ex) {
            System.out.println("Nao conseguiu desconectar do BD.");
        }
    }

    public void fecharStatement(Statement stm) {
        try {
            if(stm != null && !stm.isClosed()) {
                stm.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar o procedimento de consulta.");
        }
    }

    public void fecharResultSet(ResultSet resultado) {
        try {
            if(resultado != null && !resultado.isClosed()) {
                resultado.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar o resultado da consulta.");
        }
    }


    public Connection getConnection() {
        return conn;
    }
    public static Conexao getInstance() throws SQLException {
        if (instance == null) {
            instance = new Conexao();
        } else if (instance.getConnection().isClosed()) {
            instance = new Conexao();
        }
        return instance;
    }


    public void desconectar(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconectou do banco de dados.");
            }
        } catch (SQLException ex) {
            System.out.println("Não conseguiu desconectar do BD.");
        }
    }

}
