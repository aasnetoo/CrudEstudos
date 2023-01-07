package db;

import model.Produto;
import model.ProdutoDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {

    public void incluir(ProdutoDTO produto) throws SQLException {
        String query = "INSERT into produtos (nome, quantidade, preco, tipo) values('" + produto.getNome() + "', "
                + produto.getQuantidade() + ", "
                + produto.getPreco() + ", '"  + produto.getTipoProduto()
                + "')";

        Conexao conexao = new Conexao();
        conexao.executeQuery(query);
    }



    public void listar(){
        Conexao conexao = new Conexao();
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s","produtos");
            rs = conexao.executarListar(query);
            while (rs.next()){
                System.out.print(rs.getString("nome")+" ");
                System.out.println(rs.getString("quantidade")+" ");
                System.out.println(rs.getString("preco")+" ");
                System.out.println(rs.getString("tipo")+" ");
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Produto consultarPorNome (String nome) {
        Conexao conexao = new Conexao();
        Produto produto = null;
        try {
            String consulta = "SELECT * FROM produtos WHERE nome = '" + nome + "'";
            ResultSet rs = conexao.executarConsulta(consulta);

            if(rs.next()) {
                produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTipoProduto(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Nao conseguiu consultar os dados do Produto.");
        } finally {
            conexao.desconectar();
        }

        return produto;
    }

//    public void alterarPorQuantidade(Produto produto) {
//        String update = "UPDATE CARRO SET MODELO = '" + carro.getModelo() +
//                "', POTENCIA = " + carro.getPotencia() + "WHERE PLACA = '" +
//                carro.getPlaca() + "'";
//        Conexao conexao = new Conexao();
//        conexao.executarDML(update);
//    }

    public void excluir(Produto produto) throws SQLException {
        String query = "DELETE FROM produtos WHERE nome='" + produto.getNome() + "'";

        Conexao conexao = new Conexao();
        conexao.executeQuery(query);
    }
}



