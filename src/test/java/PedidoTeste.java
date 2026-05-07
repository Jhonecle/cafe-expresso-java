import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTeste {

    @Test
    public void deveCalcularTotalCorretamente() {
        Produto cafe = new Produto("Café", 5.0);
        Produto pao = new Produto("Pão de Queijo", 7.0);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(cafe, 2);
        pedido.adicionarItem(pao, 1);

        assertEquals(17.0, pedido.calcularTotal());
    }

    @Test
    public void deveAlterarStatusParaPago() {
        Pedido pedido = new Pedido();

        pedido.pagar();

        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

    @Test
    public void naoDevePermitirPagamentoDuasVezes() {
        Pedido pedido = new Pedido();

        pedido.pagar();

        assertThrows(
                IllegalStateException.class,
                pedido::pagar
        );
    }

    @Test
    public void deveEnviarParaCozinhaSomenteSePago() {
        Pedido pedido = new Pedido();

        assertThrows(
                IllegalStateException.class,
                pedido::enviarParaCozinha
        );
    }

    @Test
    public void deveFinalizarSomenteSeEmPreparo() {
        Pedido pedido = new Pedido();

        assertThrows(
                IllegalStateException.class,
                pedido::finalizarPedido
        );
    }
}

