
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import model.Pedido;
import model.Produto;
import model.StatusPedido;

public class PedidoTest {

    @Test
    void deveCalcularTotalPedido() {

        Pedido pedido = new Pedido();

        pedido.adicionarProduto(new Produto("Café", 5.0));
        pedido.adicionarProduto(new Produto("Pão", 3.0));

        assertEquals(8.0, pedido.calcularTotal());
    }

    @Test
    void deveAlterarStatusParaPago() {

        Pedido pedido = new Pedido();

        pedido.pagar();

        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

    @Test
    void naoDevePagarPedidoJaPago() {

        Pedido pedido = new Pedido();

        pedido.pagar();

        assertThrows(IllegalStateException.class, pedido::pagar);
    }

    @Test
    void naoDeveEnviarParaCozinhaSemPagamento() {

        Pedido pedido = new Pedido();

        assertThrows(IllegalStateException.class, pedido::enviarParaCozinha);
    }

    @Test
    void naoDeveFinalizarPedidoSemPreparacao() {

        Pedido pedido = new Pedido();

        assertThrows(IllegalStateException.class, pedido::finalizarPedido);
    }

    @Test
    void deveCalcularTotalPedidoVazio() {
        Pedido pedido = new Pedido();
        assertEquals(0.0, pedido.calcularTotal());
    }

    @Test
    void deveAlterarStatusParaEmPreparacaoAposPagamento() {
        Pedido pedido = new Pedido();
        pedido.pagar();
        pedido.enviarParaCozinha();
        assertEquals(StatusPedido.EM_PREPARACAO, pedido.getStatus());
    }

    @Test
    void deveAlterarStatusParaFinalizadoAposPreparacao() {
        Pedido pedido = new Pedido();
        pedido.pagar();
        pedido.enviarParaCozinha();
        pedido.finalizarPedido();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }

    @Test
    void naoDevePagarPedidoEmPreparacao() {
        Pedido pedido = new Pedido();
        pedido.pagar();
        pedido.enviarParaCozinha();
        assertThrows(IllegalStateException.class, pedido::pagar);
    }

    @Test
    void naoDevePagarPedidoFinalizado() {
        Pedido pedido = new Pedido();
        pedido.pagar();
        pedido.enviarParaCozinha();
        pedido.finalizarPedido();
        assertThrows(IllegalStateException.class, pedido::pagar);
    }

    @Test
    void naoDeveAdicionarProdutoNulo() {
        Pedido pedido = new Pedido();
        assertThrows(IllegalArgumentException.class, () -> pedido.adicionarProduto(null));
    }
}
