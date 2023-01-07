package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private String nome;
    private String quantidade;
    private String preco;
    private String empid;

    public String getEmpid() {
        return empid;
    }

    public Produto() {
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    private String tipoProduto;

    public Produto(String nome, String quantidade, String preco, String tipoProduto) {
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

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
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
