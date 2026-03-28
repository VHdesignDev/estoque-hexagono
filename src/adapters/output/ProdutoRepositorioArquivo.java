package adapters.output;

import java.util.ArrayList;
import java.util.List;
import domain.entities.Produto;
import application.ports.output.IProdutoRepositorio;

/*
 * ============================================================
 * ARQUITETURA HEXAGONAL - ADAPTADOR DE SAÍDA ALTERNATIVO
 * ============================================================
 *
 * CAMADA: ADAPTERS (OUTPUT)
 * RESPONSABILIDADE:
 *   Implementação alternativa da porta de saída (IProdutoRepositorio).
 *   Simula persistência com arquivo (apenas lista em memória por simplicidade).
 *
 * PRINCÍPIO HEXAGONAL:
 *   Demonstra como fácil é adicionar adaptadores alternativos.
 *   Sem mudança no domínio ou casos de uso!
 *
 * TECNOLOGIA: Arquivo (simulado com List em memória)
 */
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
