package domain.entities;

import java.util.List;


public class Estoque {

    public double calcularPrecoMedio(List<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            return 0.0;
        }

        double soma = 0.0;
        for (Produto produto : produtos) {
            soma += produto.getPreco();
        }

        return soma / produtos.size();
    }
}
