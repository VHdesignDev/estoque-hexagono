package adapters.output;

import java.util.ArrayList;
import java.util.List;
import domain.entities.Produto;
import application.ports.output.IProdutoRepositorio;

public class ProdutoRepositorioArquivo implements IProdutoRepositorio {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void salvar(Produto produto) {
        // Aqui poderia gravar em arquivo
        produtos.add(produto);
    }

    @Override
    public Produto buscarPorId(String id) {
        // Aqui poderia ler de arquivo
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void excluirPorId(String id) {
        // Aqui poderia deletar de arquivo
        produtos.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<Produto> listarTodos() {
        // Aqui poderia ler todos de arquivo
        return new ArrayList<>(produtos);
    }
}
