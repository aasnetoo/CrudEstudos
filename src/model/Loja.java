package model;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    private List<Produto> produtos;

    public Loja() {
        produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

}
