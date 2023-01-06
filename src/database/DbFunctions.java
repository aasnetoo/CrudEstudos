package database;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbFunctions {
    public Connection connect_to_db(String dbname, String user, String pass){
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
    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query ="create table "+table_name+"(empid SERIAL,nome varchar(200),quantidade integer,preco double(6),tipo varchar(200),primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insert_row(Connection conn, String table_name, String nome, int quantidade, double preco, String tipo){
        Statement statement;
        try{
            String query= String.format("insert into %s(nome,quantidade,preco,tipo) values('%s','%d','%.2f','%s');",table_name,nome,quantidade,preco,tipo);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted.");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
