package exceptions;

public class BuscaNaoEncontradaException extends RuntimeException{

    public BuscaNaoEncontradaException(){
        super("Busca não encontrada.");
    }
}
