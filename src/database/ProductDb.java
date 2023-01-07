package database;

import model.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDb {

    public void insert(Connection conn, String table_name, String nome, int quantidade, double preco, String tipo){
        Statement statement;
        try{
            String query= String.format("insert into Produtos1(nome,quantidade,preco,tipo) values('%s',%s,%s,'%s');",nome,quantidade,preco,tipo);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted.");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void read(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s",table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("nome")+" ");
                System.out.println(rs.getString("quantidade")+" ");
                System.out.println(rs.getString("preco")+" ");
                System.out.println(rs.getString("tipo")+" ");
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }
    public List<Produto> getProdutos(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<Produto>();

        try{
            statement = conn.createStatement();
            String query = String.format("select * from %s",table_name);
            rs = statement.executeQuery(query);
            while (rs.next()){
                Produto produto = new Produto();
                produto.setEmpid(rs.getString("empid")+" ");
                produto.setNome(rs.getString("nome")+" ");
                produto.setQuantidade(rs.getString("quantidade")+" ");
                produto.setPreco(rs.getString("preco")+" ");
                produto.setTipoProduto(rs.getString("tipo")+" ");
                produtos.add(produto);
            }


        }catch(Exception e){
            System.out.println(e);
        }
        return produtos;

    }
}
