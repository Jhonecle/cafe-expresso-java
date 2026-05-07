import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
