package application.usecases;

import domain.entities.Produto;
import application.ports.output.IProdutoRepositorio;


public class ConsultarProdutoUseCase {

    private IProdutoRepositorio produtoRepositorio;

    public ConsultarProdutoUseCase(IProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public Produto executar(String id) {
        Produto produto = produtoRepositorio.buscarPorId(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto com ID '" + id + "' não encontrado.");
        }
        return produto;
    }
}
