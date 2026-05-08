
import model.Pedido;
import model.Produto;

public class Main {

    public static void main(String[] args) {

        Produto cafe = new Produto("Café", 5.0);
        Produto pao = new Produto("Pão de Queijo", 7.0);

        Pedido pedido = new Pedido();

        pedido.adicionarProduto(cafe);
        pedido.adicionarProduto(cafe);
        pedido.adicionarProduto(pao);

        System.out.println("Total: R$ " + pedido.calcularTotal());

        pedido.pagar();
        pedido.enviarParaCozinha();
        pedido.finalizarPedido();

        System.out.println("Status final: " + pedido.getStatus());
    }
}
