package adapters.input;

import domain.entities.Produto;
import application.ports.input.IGerenciadorEstoque;
import application.ports.output.IProdutoRepositorio;
import application.usecases.CadastrarProdutoUseCase;
import application.usecases.ConsultarProdutoUseCase;
import application.usecases.ExcluirProdutoUseCase;
import application.usecases.CalcularPrecoMedioUseCase;


public class EstoqueController implements IGerenciadorEstoque {

    private CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private ConsultarProdutoUseCase consultarProdutoUseCase;
    private ExcluirProdutoUseCase excluirProdutoUseCase;
    private CalcularPrecoMedioUseCase calcularPrecoMedioUseCase;

    // Dependency Injection: recebe a porta de saída
    public EstoqueController(IProdutoRepositorio produtoRepositorio) {
        // Instancia os casos de uso com a porta
        this.cadastrarProdutoUseCase = new CadastrarProdutoUseCase(produtoRepositorio);
        this.consultarProdutoUseCase = new ConsultarProdutoUseCase(produtoRepositorio);
        this.excluirProdutoUseCase = new ExcluirProdutoUseCase(produtoRepositorio);
        this.calcularPrecoMedioUseCase = new CalcularPrecoMedioUseCase(produtoRepositorio);
    }

    @Override
    public void cadastrarProduto(String id, String nome, double preco) {
        cadastrarProdutoUseCase.executar(id, nome, preco);
    }

    @Override
    public Produto consultarProduto(String id) {
        return consultarProdutoUseCase.executar(id);
    }

    @Override
    public void excluirProduto(String id) {
        excluirProdutoUseCase.executar(id);
    }

    @Override
    public double calcularPrecoMedio() {
        return calcularPrecoMedioUseCase.executar();
    }
}
