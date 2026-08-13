package prueba4;

import prueba4.Pedido;

public class PedidoNacional extends Pedido{
    protected double TarifaBase = 50;
    protected double distanciaKM;

    public PedidoNacional(int id, String cliente, double monto, double distancia){
        super(id, cliente, monto);
        distanciaKM = distancia;
    }

    public String getTipo(){
        return "NACIONAL";
    }

    @Override
    public double calcularCostoEnvio(){
        return TarifaBase+distanciaKM*0.5;
    }
}
