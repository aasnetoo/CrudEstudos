package exceptions;

public class ProdutoExisteException extends RuntimeException{

    public ProdutoExisteException(String nome){
        super("O produto "+nome+" já existe");
    }

}
