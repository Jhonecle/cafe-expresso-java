import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

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

ProdutoTest.java

import model.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void deveCriarProdutoValido() {
        Produto produto = new Produto("Café", 5.0);

        assertEquals("Café", produto.getNome());
        assertEquals(5.0, produto.getPrecoUnitario());
    }

    @Test
    public void naoDevePermitirPrecoZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Café", 0)
        );
    }

    @Test
    public void naoDevePermitirNomeVazio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("", 5.0)
        );
    }
}

