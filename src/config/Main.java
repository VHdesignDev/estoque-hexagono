package config;

import adapters.input.EstoqueController;
import adapters.output.ProdutoRepositorioMemoria;
import application.ports.input.IGerenciadorEstoque;
import application.ports.output.IProdutoRepositorio;
import domain.entities.Produto;


public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE ESTOQUE - ARQUITETURA HEXAGONAL ===\n");

  
        
        // 1. Criar adaptador de saída 
        IProdutoRepositorio produtoRepositorio = new ProdutoRepositorioMemoria();
        
        // 2. Criar adaptador de entrada (input adapter)
        //    que recebe a porta de saída
        IGerenciadorEstoque gerenciador = new EstoqueController(produtoRepositorio);

        // ========== USAR OS CASOS DE USO ==========
        
        System.out.println("--- Cadastrando produtos ---");
        gerenciador.cadastrarProduto("p1", "Teclado Mecânico", 250.00);
        gerenciador.cadastrarProduto("p2", "Mouse Gamer", 180.00);
        gerenciador.cadastrarProduto("p3", "Monitor 24\"", 920.00);
        System.out.println("✓ 3 produtos cadastrados\n");

        System.out.println("--- Consultando produto ---");
        Produto produto = gerenciador.consultarProduto("p2");
        System.out.println("✓ Produto encontrado: " + produto.getNome() + " - R$ " + produto.getPreco() + "\n");

        System.out.println("--- Calculando preço médio ---");
        double precoMedio = gerenciador.calcularPrecoMedio();
        System.out.println("✓ Preço médio do estoque: R$ " + String.format("%.2f", precoMedio) + "\n");

        System.out.println("--- Excluindo produto ---");
        gerenciador.excluirProduto("p1");
        System.out.println("✓ Produto p1 excluído com sucesso\n");

        System.out.println("--- Novo preço médio (sem p1) ---");
        double novoPrecoMedio = gerenciador.calcularPrecoMedio();
        System.out.println("✓ Novo preço médio: R$ " + String.format("%.2f", novoPrecoMedio) + "\n");

        System.out.println("=== FIM DA EXECUÇÃO ===");
    }
}
