package exceptions;

public class LojaVaziaException extends RuntimeException {

    public LojaVaziaException(){
        super("Loja vazia.");
    }
}
