package view;

import model.*;
import utils.Constantes;

import java.math.BigDecimal;
import java.util.Scanner;


public class LojaView {

    Scanner scan = new Scanner(System.in);


    public String opcaoMenu() {
        System.out.println("---------- MENU ----------");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Listar");
        System.out.println("3 - Editar Produto");
        System.out.println("4 - Remover um produto");
        System.out.println("5 - Remover todos os produtos");
        System.out.println("6 - Sair do Programa");

        return scan.nextLine();
    }

    public Produto adicionarProduto() {
        System.out.println("Qual nome do produto: ");
        String nomeProduto = scan.nextLine();
        System.out.println("Qual a quantidade: ");
        int quantidadeProduto = scan.nextInt();
        scan.nextLine();
        System.out.println("Qual o valor do produto: ");
        Double precoProduto = scan.nextDouble();
        scan.nextLine();
        System.out.println("Qual o tipo do produto: \n 1 - Eletronicos \n 2 - Alimentos \n 3 - Outros");
        TipoProduto tipoProduto = TipoProduto.getProduto(scan.nextLine());

        return new Produto(nomeProduto, quantidadeProduto, precoProduto, tipoProduto);

    }



    public Produto editarProduto() {
        System.out.println("Qual novo nome do produto: ");
        String nomeProduto = scan.nextLine();
        System.out.println("Qual a nova quantidade: ");
        int quantidadeProduto = scan.nextInt();
        scan.nextLine();
        System.out.println("Qual o novo valor do produto: ");
        Double precoProduto = scan.nextDouble();
        scan.nextLine();
        System.out.println("Qual o tipo do produto: \n 1 - Eletronicos \n 2 - Alimentos \n 3 - Outros");
        TipoProduto tipoProduto = TipoProduto.getProduto(scan.nextLine());

        return new Produto(nomeProduto, quantidadeProduto, precoProduto, tipoProduto);

    }

    public void sairPrograma(){
        scan.close();
    }








}
