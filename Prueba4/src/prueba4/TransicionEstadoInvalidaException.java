package prueba4;

public class TransicionEstadoInvalidaException extends Exception{
    public TransicionEstadoInvalidaException(EstadoPedido actual, EstadoPedido nuevo){
        super("No se puede pasar de " + actual + " a " + nuevo + " (estado actual final: " + actual.isesFinal() + ") ");
    }
}
