package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private String nome;
    private int quantidade;
    private double preco;
    private String tipoProduto;

    public Produto() {
    }

    public Produto(String nome, int quantidade, double preco, String tipoProduto) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Produto: ").append(getNome());
        sb.append("\n Quantidade: ").append(getQuantidade());
        sb.append("\n Valor: ").append(getPreco());
        sb.append(" Tipo do Produto: ").append(getTipoProduto());

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return quantidade == produto.quantidade && Objects.equals(nome, produto.nome) && Objects.equals(preco, produto.preco) && tipoProduto == produto.tipoProduto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, quantidade, preco, tipoProduto);
    }
}
