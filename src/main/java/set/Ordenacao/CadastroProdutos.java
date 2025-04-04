package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// Classe responsável por armazenar e organizar um conjunto de produtos
public class CadastroProdutos {
    // Conjunto para armazenar os produtos (usando HashSet para evitar duplicatas)
    private Set<Produto> produtoSet;

    // Construtor inicializa o conjunto de produtos como um HashSet
    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    // Metodo para adicionar um novo produto ao conjunto
    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    // Metodo para exibir os produtos ordenados pelo nome (usando TreeSet)
    public Set<Produto> exibirProdutosPorNome() {
        // TreeSet utiliza a ordenação natural definida na classe Produto (pelo nome)
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        if (!produtoSet.isEmpty()) {
            return produtosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    // Metodo para exibir os produtos ordenados pelo preço
    public Set<Produto> exibirProdutosPorPreco() {
        // TreeSet com um Comparator personalizado para ordenar pelo preço
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        if (!produtoSet.isEmpty()) {
            produtosPorPreco.addAll(produtoSet); // Adiciona todos os produtos ao novo TreeSet
            return produtosPorPreco;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do CadastroProdutos
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        // Adicionando produtos ao cadastro
        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20); // Mesmo código do Smartphone, será ignorado
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

        // Exibindo todos os produtos no cadastro (sem ordenação)
        System.out.println("Produtos cadastrados: " + cadastroProdutos.produtoSet);

        // Exibindo produtos ordenados por nome
        System.out.println("Produtos ordenados por nome: " + cadastroProdutos.exibirProdutosPorNome());

        // Exibindo produtos ordenados por preço
        System.out.println("Produtos ordenados por preço: " + cadastroProdutos.exibirProdutosPorPreco());
    }
}
