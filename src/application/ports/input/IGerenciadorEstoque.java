package application.ports.input;

import domain.entities.Produto;

/*
 * ============================================================
 * ARQUITETURA HEXAGONAL - PORTA DE ENTRADA
 * ============================================================
 *
 * CAMADA: APPLICATION (PORTS - INPUT)
 * RESPONSABILIDADE:
 *   Define o contrato que adaptadores de entrada devem respeitar.
 *   Expõe os casos de uso do sistema.
 *   Abstrai implementação dos casos de uso.
 *
 * PRINCÍPIO HEXAGONAL:
 *   Portas de entrada (input ports) definem como atores externos
 *   (usuários, sistemas) se comunicam com a aplicação.
 *   A implementação fica nos adaptadores (controllers, APIs, etc).
 *
 * ADAPTADOR ASSOCIADO:
 *   EstoqueController (implementação com console)
 */
public interface IGerenciadorEstoque {

    void cadastrarProduto(String id, String nome, double preco);

    Produto consultarProduto(String id);

    void excluirProduto(String id);

    double calcularPrecoMedio();
}
