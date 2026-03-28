package application.usecases;

import domain.entities.Produto;
import application.ports.output.IProdutoRepositorio;


public class ExcluirProdutoUseCase {

    private IProdutoRepositorio produtoRepositorio;

    public ExcluirProdutoUseCase(IProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public void executar(String id) {
        Produto produto = produtoRepositorio.buscarPorId(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto com ID '" + id + "' não encontrado.");
        }
        produtoRepositorio.excluirPorId(id);
    }
}
