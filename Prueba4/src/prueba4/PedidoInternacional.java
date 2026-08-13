package prueba4;

public class PedidoInternacional extends Pedido{
    protected double TarifaBase = 100;
    protected double costoAduana = 0.15;
    protected String pais;

    public PedidoInternacional(int id, String cliente, double monto, double aduana, String pais){
        super(id, cliente, monto);
        costoAduana = aduana;
        pais=pais;
    }

    public String getTipo(){
        return "INTERNACIONAL, destino a " + this.pais;
    }

    public double calcularCostoEnvio(){
        return TarifaBase+costoAduana;
    }

    public String toString(){
        return super.toString() + ", Pedido Internacion enviado a " + this.pais;
    }


}
