package application.usecases;

import domain.entities.Produto;
import application.ports.output.IProdutoRepositorio;


public class CadastrarProdutoUseCase {

    private IProdutoRepositorio produtoRepositorio;

    public CadastrarProdutoUseCase(IProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public void executar(String id, String nome, double preco) {
        // Validar e criar entidade de domínio
        Produto produto = new Produto(id, nome, preco);
        
        // Usar porta de saída para persistir
        produtoRepositorio.salvar(produto);
    }
}
