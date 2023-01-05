package model;

import exceptions.EntravaInvalidaException;
import utils.Constantes;
public enum TipoProduto {

    ELETRONICOS("Eletronicos","1"),
    ALIMENTOS("Alimentos","2"),
    OUTROS("Outros","3");

    private String nome;
    private String id;

    TipoProduto(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static TipoProduto getProduto(String id){
        switch (id) {
            case Constantes.TIPO_ELETRONICO -> {
                return ELETRONICOS;
            } case Constantes.TIPO_ALIMENTO ->   {
                return ALIMENTOS;
            } case Constantes.TIPO_OUTROS -> {
                return OUTROS;
            }
            default -> throw new EntravaInvalidaException("Entrada inválida!");
        }
    }


}
