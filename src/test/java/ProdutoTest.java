
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import model.Produto;

public class ProdutoTest {

    @Test
    void deveCriarProdutoValido() {

        Produto produto = new Produto("Café Expresso", 5.0);

        assertEquals("Café Expresso", produto.getNome());
        assertEquals(5.0, produto.getPreco());
    }

    @Test
    void naoDevePermitirPrecoZero() {

        assertThrows(IllegalArgumentException.class,
                () -> new Produto("Café", 0));
    }

    @Test
    void naoDevePermitirNomeVazio() {

        assertThrows(IllegalArgumentException.class,
                () -> new Produto("", 5.0));
    }

    @Test
    void naoDevePermitirNomeNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto(null, 5.0));
    }

    @Test
    void naoDevePermitirNomeApenasComEspacos() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto("   ", 5.0));
    }

    @Test
    void naoDevePermitirPrecoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto("Café", -1.0));
    }
}
