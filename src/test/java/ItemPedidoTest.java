
import model.ItemPedido;
import model.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemPedidoTest {

    @Test
    void deveCriarItemPedidoValido() {
        Produto produto = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(produto, 2);

        assertNotNull(item);
        assertEquals(produto, item.getProduto());
        assertEquals(2, item.getQuantidade());
    }

    @Test
    void naoDevePermitirQuantidadeZero() {
        Produto produto = new Produto("Café", 5.0);
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido(produto, 0));
    }

    @Test
    void naoDevePermitirQuantidadeNegativa() {
        Produto produto = new Produto("Café", 5.0);
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido(produto, -1));
    }

    @Test
    void deveCalcularSubtotalCorretamente() {
        Produto produto = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(produto, 3);
        assertEquals(15.0, item.calcularSubtotal());
    }

    @Test
    void deveCalcularSubtotalParaQuantidadeUm() {
        Produto produto = new Produto("Pão", 3.0);
        ItemPedido item = new ItemPedido(produto, 1);
        assertEquals(3.0, item.calcularSubtotal());
    }

    @Test
    void deveRetornarProdutoCorreto() {
        Produto produto = new Produto("Suco", 7.0);
        ItemPedido item = new ItemPedido(produto, 1);
        assertEquals(produto, item.getProduto());
    }

    @Test
    void deveRetornarQuantidadeCorreta() {
        Produto produto = new Produto("Bolo", 10.0);
        ItemPedido item = new ItemPedido(produto, 2);
        assertEquals(2, item.getQuantidade());
    }
}
