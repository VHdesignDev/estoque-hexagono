package application.ports.input;

import domain.entities.Produto;

public interface IGerenciadorEstoque {

    void cadastrarProduto(String id, String nome, double preco);

    Produto consultarProduto(String id);

    void excluirProduto(String id);

    double calcularPrecoMedio();
}
