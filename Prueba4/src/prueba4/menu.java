package prueba4;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorPedidos g = new GestorPedidos(10);
        int opcion;

        do {

            System.out.println("Sistema de manejo de Pedidos");
            System.out.println("1. Agregar Pedido Nacional");
            System.out.println("2. Agregar Pedido Internacional");
            System.out.println("3. Cambiar estado de pedido");
            System.out.println("4. Buscar pedido por id");
            System.out.println("5. Listar pedidos por estado");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    PedidoNacional p = null;
                    System.out.println("Ingrese el id del pedido");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el cliente dueño del pedido");
                    String cliente = sc.nextLine();
                    System.out.print("Monto: ");
                    double monto = sc.nextDouble();
                    System.out.print("Distancia (km): ");
                    double distancia = sc.nextDouble();
                    try {
                        g.AgregarPedido(new PedidoNacional(id, cliente, monto, distancia));
                        System.out.println("Pedido agregado exitosamente");
                    } catch (Exception e) {
                        System.out.println("No se pudo guardar el pedido");
                    }
                    break;
                case 2:
                    System.out.print("Id: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cliente: ");
                    String cliente2 = sc.nextLine();
                    System.out.print("Monto: ");
                    double monto2 = sc.nextDouble();
                    System.out.print("Costo de aduana: ");
                    double aduana = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("País destino: ");
                    String pais = sc.nextLine();
                    try {
                        g.AgregarPedido(new PedidoInternacional(id2, cliente2, monto2, aduana, pais));
                        System.out.println("Pedido agregado exitosamente.");
                    } catch (Exception e) {
                        System.out.println("Error al guardar el pedido");
                    }
                    break;
                case 3:
                    System.out.print("Id del pedido");
                    int idPedido = sc.nextInt();
                    System.out.println(
                            "Elina la oopcion del nuevo estado: 1.PROCESANDO 2.ENVIADO 3.ENTREGADO 4.CANCELADO");
                    int op = sc.nextInt();
                    EstadoPedido nuevoE;
                    switch (op) {
                        case 1:
                            nuevoE = EstadoPedido.PROCESANDO;
                            break;
                        case 2:
                            nuevoE = EstadoPedido.ENVIADO;
                            break;
                        case 3:
                            nuevoE = EstadoPedido.ENTREGADO;
                            break;
                        default:
                            nuevoE = EstadoPedido.CANCELADO;
                            break;
                    }
                    try {
                        g.cambiarEstado(idPedido, nuevoE);
                        System.out.println("Estado actualizado.");
                    } catch (Exception e) {
                        System.out.println("Error al cambiar el estado del pedido" + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Id del pedido: ");
                    int idBuscar = sc.nextInt();
                    try {
                        System.out.println(g.buscarPorId(idBuscar));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Estado: 1.PENDIENTE 2.PROCESANDO 3.ENVIADO 4.ENTREGADO 5.CANCELADO");
                    int opEst = sc.nextInt();
                    EstadoPedido filtro;
                    switch (opEst) {
                        case 1:
                            filtro = EstadoPedido.PENDIENTE;
                            break;
                        case 2:
                            filtro = EstadoPedido.PROCESANDO;
                            break;
                        case 3:
                            filtro = EstadoPedido.ENVIADO;
                            break;
                        case 4:
                            filtro = EstadoPedido.ENTREGADO;
                            break;
                        default:
                            filtro = EstadoPedido.CANCELADO;
                            break;
                    }
                    Pedido[] filtrados = g.listarPorEstado(filtro);
                    if (filtrados.length == 0) {
                        System.out.println("No hay pedidos en ese estado.");
                    } else {
                        for (Pedido p2 : filtrados) {
                            System.out.println(p2);
                        }
                    }
                    break;
                default:
                    break;
            }
        } while (opcion != 6);
        System.out.println("Fin del sistema");
    }
}
