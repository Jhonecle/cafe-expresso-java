package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Produto> produtos;
    private StatusPedido status;

    public Pedido() {
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.RECEBIDO;
    }

    // MÉTODO QUE ESTÁ FALTANDO
    public void adicionarProduto(Produto produto) {

        if (produto == null) {
            throw new IllegalArgumentException("Produto inválido");
        }

        produtos.add(produto);
    }

    public double calcularTotal() {

        double total = 0;

        for (Produto produto : produtos) {
            total += produto.getPreco();
        }

        return total;
    }

    public void pagar() {

        if (status == StatusPedido.PAGO) {
            throw new IllegalStateException("Pedido já pago");
        }

        status = StatusPedido.PAGO;
    }

    public void enviarParaCozinha() {

        if (status != StatusPedido.PAGO) {
            throw new IllegalStateException("Pedido precisa estar pago");
        }

        status = StatusPedido.EM_PREPARACAO;
    }

    public void finalizarPedido() {

        if (status != StatusPedido.EM_PREPARACAO) {
            throw new IllegalStateException("Pedido não está em preparação");
        }

        status = StatusPedido.FINALIZADO;
    }

    public StatusPedido getStatus() {
        return status;
    }
}

