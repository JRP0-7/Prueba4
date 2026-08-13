package prueba4;

public class CapacidadExcedidaException extends Exception{
    public CapacidadExcedidaException(int capacidad){
        super("Capacidad máxima alcanzada (" + capacidad + " pedidos)");

    }
}
