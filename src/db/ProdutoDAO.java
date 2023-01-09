package db;

import model.Produto;
import model.ProdutoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    Conexao instance = Conexao.getInstance();

    public ProdutoDAO() throws SQLException {
    }

    public void incluir(ProdutoDTO produto) {
        String query = "INSERT into produtos (nome, quantidade, preco, tipo) values('" + produto.getNome() + "', "
                + produto.getQuantidade() + ", "
                + produto.getPreco() + ", '" + produto.getTipoProduto()
                + "')";
        try {
            Statement stm = instance.getConnection().createStatement();
            stm.executeUpdate(query);
            System.out.println("O produto foi adicionado com sucesso. ");
        } catch (SQLException ex) {
            System.out.println("Nao conseguiu executar o DML\n" + query);
        }
    }

    public void desconectar(){
        instance.desconectar();
    }

    public void atualizar(ProdutoDTO produtoDTO) {
        try {
            String query = "UPDATE produtos " +
                    " SET nome = "+produtoDTO.getNome()+", " +
                    " quantidade = "+produtoDTO.getQuantidade()+"," +
                    " preco = +"+produtoDTO.getPreco()+"," +
                    " tipo = "+produtoDTO.getTipoProduto()+"";

            PreparedStatement statement = instance.getConnection().prepareStatement(query);
            statement.setString(1, produtoDTO.getNome());
            statement.setInt(2, produtoDTO.getQuantidade());
            statement.setDouble(3,produtoDTO.getPreco());
            statement.setString(4,produtoDTO.getTipoProduto());

            statement.execute();
        } catch(Exception e) {
            System.out.println(e);
        }
    }



    public List<Produto> listar() {
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        try{
            String query = String.format("select * from produtos");
            Statement stm = instance.getConnection().createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()){
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTipoProduto(rs.getString("tipo"));
                produtos.add(produto);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return produtos;
    }

    public Produto consultarPorNome (String nome) throws SQLException {
        Produto produto = null;
        try {
            String consulta = "SELECT * FROM produtos WHERE nome = '" + nome + "'";
            Statement stm = instance.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            if(rs.next()) {
                produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTipoProduto(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Nao conseguiu consultar os dados do Produto.");
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



