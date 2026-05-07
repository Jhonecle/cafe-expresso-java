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
