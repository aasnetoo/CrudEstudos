package view;

import controller.LojaController;
import db.Conexao;
import model.*;
import utils.Constantes;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;


public class LojaView {


    Scanner scan = new Scanner(System.in);

    LojaController controller = new LojaController();

    public LojaView() throws SQLException {
    }

    public String opcaoMenu() {
        System.out.println("---------- MENU ----------");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Listar");
        System.out.println("3 - Editar Produto");
        System.out.println("4 - Remover um produto");
        System.out.println("5 - Buscar por nome");
        System.out.println("6 - Sair do Programa");

        return scan.nextLine();
    }

    public void menu() {
        boolean continueMenu = true;
        while (continueMenu) {
            String option = opcaoMenu();
            try {
                switch (option) {
                    case Constantes.ADICIONAR_PRODUTO -> adicionarProduto(obterInformacoesProduto());
                    case Constantes.LISTAR_PRODUTO -> controller.listarProduto();
                    case Constantes.EDITAR_PRODUTO -> System.out.println();
                    case Constantes.REMOVER_PRODUTO -> controller.removerProduto();
                    case Constantes.BUSCA_POR_NOME -> controller.buscarPorNome(nomeBusca());
                    case Constantes.SAIR_DO_PROGRAMA -> {
                        continueMenu = false;
                        controller.sairPrograma();
                        exit(0);
                    } // 6
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public ProdutoDTO obterInformacoesProduto() {
        System.out.println("Qual nome do produto: ");
        String nomeProduto = scan.nextLine();
        System.out.println("Qual a quantidade: ");
        int quantidadeProduto = scan.nextInt();
        scan.nextLine();
        System.out.println("Qual o valor do produto: ");
        double precoProduto = scan.nextDouble();
        scan.nextLine();
//        System.out.println("Qual o tipo do produto: \n 1 - Eletronicos \n 2 - Alimentos \n 3 - Outros");
//        TipoProduto tipoProduto = TipoProduto.getProduto(scan.nextLine());
        System.out.println("Qual o tipo do Produto? Eletronicos, Alimentos ou Outros");
        String tipoProduto = scan.nextLine();

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome(nomeProduto);
        produtoDTO.setQuantidade(quantidadeProduto);
        produtoDTO.setPreco(precoProduto);
        produtoDTO.setTipoProduto(tipoProduto);

        return produtoDTO;

    }

    public void adicionarProduto(ProdutoDTO produtoDTO) throws SQLException {
        controller.adicionarProduto(produtoDTO);
    }



    public Produto editarProduto() {
        System.out.println("Qual novo nome do produto: ");
        String nomeProduto = scan.nextLine();
        System.out.println("Qual a nova quantidade: ");
        int quantidadeProduto = scan.nextInt();
        scan.nextLine();
        System.out.println("Qual o novo valor do produto: ");
        double precoProduto = scan.nextDouble();
        scan.nextLine();
//        System.out.println("Qual o tipo do produto: \n 1 - Eletronicos \n 2 - Alimentos \n 3 - Outros");
//        TipoProduto tipoProduto = TipoProduto.getProduto(scan.nextLine());
        System.out.println("Qual o novo tipo do Produto? Eletronicos, Alimentos ou Outros");
        String tipoProduto = scan.nextLine();

        return new Produto(nomeProduto, quantidadeProduto, precoProduto, tipoProduto);

    }

    public String nomeBusca(){
        System.out.println("Qual o nome você deseja buscar? ");
        return scan.nextLine();
    }

    public void buscarNome() throws SQLException {
        controller.buscarPorNome(nomeBusca());
    }

    public void sairPrograma(){
        scan.close();
    }








}
