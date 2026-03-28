package application.usecases;

import java.util.List;
import domain.entities.Estoque;
import domain.entities.Produto;
import application.ports.output.IProdutoRepositorio;


public class CalcularPrecoMedioUseCase {

    private IProdutoRepositorio produtoRepositorio;
    private Estoque estoque;

    public CalcularPrecoMedioUseCase(IProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.estoque = new Estoque();
    }

    public double executar() {
        List<Produto> produtos = produtoRepositorio.listarTodos();
        return estoque.calcularPrecoMedio(produtos);
    }
}
