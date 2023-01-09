package database;


import java.sql.Connection;
import java.sql.DriverManager;

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

//    public void createTable(Connection conn, String table_name){
//        Statement statement;
//        try{
//            String query ="create table "+table_name+"(empid SERIAL,nome varchar(200),quantidade integer,preco float,tipo varchar(200),primary key(empid));";
//            statement = conn.createStatement();
//            statement.executeUpdate(query);
//            System.out.println("Table created");
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }

//    public void insert_row(Connection conn, String table_name, String nome, int quantidade, double preco, String tipo){
//        Statement statement;
//        try{
//            String query= String.format("insert into %s(nome,quantidade,preco,tipo) values('%s',%s,%s,'%s');",table_name,nome,quantidade,preco,tipo);
//            statement = conn.createStatement();
//            statement.executeUpdate(query);
//            System.out.println("Row Inserted.");
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }
//    public void read_data(Connection conn, String table_name){
//        Statement statement;
//        ResultSet rs = null;
//        try{
//            String query = String.format("select * from %s",table_name);
//            statement = conn.createStatement();
//            rs = statement.executeQuery(query);
//            while (rs.next()){
//                System.out.print(rs.getString("empid")+" ");
//                System.out.print(rs.getString("nome")+" ");
//                System.out.println(rs.getString("quantidade")+" ");
//                System.out.println(rs.getString("preco")+" ");
//                System.out.println(rs.getString("tipo")+" ");
//            }
//
//
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }
//    public List<Produto> getProdutos(Connection conn, String table_name){
//        Statement statement;
//        ResultSet rs = null;
//        List<Produto> produtos = new ArrayList<Produto>();
//
//        try{
//            statement = conn.createStatement();
//            String query = String.format("select * from %s",table_name);
//            rs = statement.executeQuery(query);
//            while (rs.next()){
//                Produto produto = new Produto();
//                produto.setEmpid(rs.getString("empid")+" ");
//                produto.setNome(rs.getString("nome")+" ");
//                produto.setQuantidade(rs.getString("quantidade")+" ");
//                produto.setPreco(rs.getString("preco")+" ");
//                produto.setTipoProduto(rs.getString("tipo")+" ");
//                produtos.add(produto);
//            }
//
//
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        return produtos;
//
//    }
}
