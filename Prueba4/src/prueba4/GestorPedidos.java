package prueba4;

public class GestorPedidos {
    private final Pedido pedidos[];
    private int cantidad;

    public GestorPedidos(int size) {
        pedidos = new Pedido[size];
        cantidad = 0;
    }

    public void AgregarPedido(Pedido dato) throws CapacidadExcedidaException, PedidoNoEncontradoException {
        if (cantidad == pedidos.length) {
            throw new CapacidadExcedidaException(pedidos.length);
        }
        if(buscarPorId(dato.id)!=null){
            System.out.println("El pedido ya se encuentra registrado");
        }
        pedidos[cantidad] = dato;
        cantidad++;
    }

    public Pedido buscarPorId(int id) throws PedidoNoEncontradoException {
        for (int i = 0; i < cantidad; i++) {
            if (pedidos[i].getId() == id) {
                return pedidos[i];
            }
        }
        throw new PedidoNoEncontradoException(id);
    }

    public void cambiarEstado(int id, EstadoPedido nuevoEstado)
            throws PedidoNoEncontradoException, TransicionEstadoInvalidaException {
        Pedido pedido = buscarPorId(id);
        EstadoPedido estadoActual = pedido.getEstado();
        try {
            estadoActual.puedeTransicionarA(nuevoEstado);
            pedido.setEstado(nuevoEstado);
        } catch (Exception e) {
            throw new TransicionEstadoInvalidaException(estadoActual, nuevoEstado);
        }
    }

    public Pedido[] listarPorEstado(EstadoPedido estado){
        int cPedidos=0;
        int cP=0;
        System.out.println("Pedidos con estado: " + estado);
        for (int i = 0; i < cantidad; i++) {
            if (pedidos[i].getEstado() == estado) {
                cPedidos++;
            }
        }

        Pedido[] lista = new Pedido[cPedidos];
        for (int i = 0; i < lista.length; i++) {
            if (pedidos[i].getEstado() == estado) {
                lista[cP] = pedidos[i];
                cP++;
            }
        }
        return lista;
    }

}
