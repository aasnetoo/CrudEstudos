package controller;

import database.DbFunctions;
import db.ProdutoDAO;
import exceptions.BuscaNaoEncontradaException;
import exceptions.LojaVaziaException;
import model.Produto;
import model.ProdutoDTO;
import utils.Constantes;
import view.Mensagens;

import java.sql.SQLException;
import java.util.Scanner;


public class LojaController {


    ProdutoDAO produtoDAO = new ProdutoDAO();

    DbFunctions db = new DbFunctions();
    Mensagens mensagens = new Mensagens();
    Scanner scan = new Scanner(System.in);

    public LojaController() throws SQLException {
    }

//    public void menu() {
//        boolean continueMenu = true;
//        while (continueMenu) {
//            String option = (view.opcaoMenu());
//            try {
//                switch (option) {
//                    case Constantes.ADICIONAR_PRODUTO -> adicionarProduto();
//                    case Constantes.LISTAR_PRODUTO -> listarProduto();
//                    case Constantes.EDITAR_PRODUTO -> editarProduto();
//                    case Constantes.REMOVER_PRODUTO -> removerProduto();
//                    case Constantes.BUSCA_POR_NOME -> buscarPorNome();
//                    case Constantes.SAIR_DO_PROGRAMA -> {
//                        continueMenu = false;
//                        sairPrograma();
//                    } // 6
//                }
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    public void adicionarProduto(ProdutoDTO produtoDTO) throws SQLException {
        produtoDAO.incluir(produtoDTO);

    }

    public void sairPrograma(){
        produtoDAO.desconectar();
    }



//    public void produtosDoBanco(){
//
//        db.getProdutos();
//    }
    public void listarProduto() throws SQLException {
        for (int i = 0; i < produtoDAO.listar().size(); i++) {
            System.out.println(produtoDAO.listar().get(i));
        };
    }

//    public int selecionarProduto(){
//
//    }

//    public void editarProduto(){
//        verificarListaVazia();
//        int indiceProdutoAtualizar = selecionarProduto();
//        Produto ProdutoAtualizar = view.editarProduto();
//        loja.getProdutos().set(indiceProdutoAtualizar,ProdutoAtualizar);
//    }

    public void removerProduto(){

    }


    public void buscarPorNome(String nome) throws SQLException {
        Produto produtoEncontrado = produtoDAO.consultarPorNome(nome);
        if (produtoEncontrado == null){
            throw new BuscaNaoEncontradaException();
        }
        System.out.println(produtoEncontrado);
    }

//    public void sairPrograma(){
//        view.sairPrograma();
//        scan.close();
//        exit(0);
//    }

}
