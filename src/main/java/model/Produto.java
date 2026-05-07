package model;

public class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }

        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
