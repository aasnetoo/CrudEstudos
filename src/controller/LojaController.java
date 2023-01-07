package controller;

import database.DbFunctions;
import db.ProdutoDAO;
import exceptions.BuscaNaoEncontradaException;
import exceptions.LojaVaziaException;
import exceptions.ProdutoExisteException;
import model.Loja;
import model.Produto;
import model.ProdutoDTO;
import utils.Constantes;
import view.LojaView;
import view.Mensagens;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;


public class LojaController {

    ProdutoDAO produtoDAO = new ProdutoDAO();

    DbFunctions db = new DbFunctions();
    Mensagens mensagens = new Mensagens();
    Scanner scan = new Scanner(System.in);

    Loja loja = new Loja();

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
        mensagens.produtoAdicionado();
    }



//    public void produtosDoBanco(){
//
//        db.getProdutos();
//    }
    public void listarProduto(){
        produtoDAO.listar();
    }

    public int selecionarProduto(){
        mensagens.SelecionarProduto();
        for (int i = 0; i < loja.getProdutos().size(); i++) {
            System.out.println((i+1)+" - "+loja.getProdutos().get(i).getNome());
        }
        return (Integer.parseInt(scan.nextLine())-Constantes.INDEX_FATOR);
    }

//    public void editarProduto(){
//        verificarListaVazia();
//        int indiceProdutoAtualizar = selecionarProduto();
//        Produto ProdutoAtualizar = view.editarProduto();
//        loja.getProdutos().set(indiceProdutoAtualizar,ProdutoAtualizar);
//    }

    public void removerProduto(){
        verificarListaVazia();
        int indiceProudtoARemover = selecionarProduto();
        loja.getProdutos().remove(indiceProudtoARemover);
    }

    public void verificarListaVazia(){
        if (loja.getProdutos().isEmpty()){
            throw new LojaVaziaException();
        }
    }

    public void buscarPorNome(String nome){
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
