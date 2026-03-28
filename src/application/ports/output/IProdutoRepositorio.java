package application.ports.output;

import java.util.List;
import domain.entities.Produto;


public interface IProdutoRepositorio {

    void salvar(Produto produto);

    Produto buscarPorId(String id);

    void excluirPorId(String id);

    List<Produto> listarTodos();
}
