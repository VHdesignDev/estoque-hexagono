package adapters.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import domain.entities.Produto;
import application.ports.output.IProdutoRepositorio;

/*
 * ============================================================
 * ARQUITETURA HEXAGONAL - ADAPTADOR DE SAÍDA
 * ============================================================
 *
 * CAMADA: ADAPTERS (OUTPUT)
 * RESPONSABILIDADE:
 *   Implementa a porta de saída (IProdutoRepositorio).
 *   Simula persistência com HashMap em memória.
 *   Pode ser facilmente substituído por outra implementação.
 *
 * PRINCÍPIO HEXAGONAL:
 *   Adaptadores são a interface entre o domínio e tecnologias externas.
 *   A aplicação não conhece detalhes dessa implementação.
 *   Fácil adicionar novo adaptador (ex: BD, arquivo, API) sem alterar domínio.
 *
 * TECNOLOGIA: Memória (HashMap)
 */
public class ProdutoRepositorioMemoria implements IProdutoRepositorio {

    private HashMap<String, Produto> banco = new HashMap<>();

    @Override
    public void salvar(Produto produto) {
        banco.put(produto.getId(), produto);
    }

    @Override
    public Produto buscarPorId(String id) {
        return banco.get(id);
    }

    @Override
    public void excluirPorId(String id) {
        banco.remove(id);
    }

    @Override
    public List<Produto> listarTodos() {
        return new ArrayList<>(banco.values());
    }
}
