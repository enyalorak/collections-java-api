package main.java.set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

// A classe Produto representa um produto que pode ser ordenado por nome
public class Produto implements Comparable<Produto> {
    // Atributos do produto
    private long codigo;    // Código único do produto
    private String nome;    // Nome do produto
    private double preco;   // Preço do produto
    private int quantidade; // Quantidade disponível do produto

    // Construtor que inicializa os atributos do produto
    public Produto(long codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Implementação do metodo compareTo da interface Comparable
    // Define a ordenação natural dos produtos pelo nome, ignorando maiúsculas e minúsculas
    @Override
    public int compareTo(Produto p) {
        return nome.compareToIgnoreCase(p.getNome());
    }

    // Métodos getters para acessar os atributos da classe
    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Metodo equals para comparar produtos com base no código (dois produtos são iguais se tiverem o mesmo código)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Se for a mesma referência, são iguais
        if (!(o instanceof Produto produto)) return false; // Se não for um Produto, retorna falso
        return getCodigo() == produto.getCodigo(); // Compara os códigos dos produtos
    }

    // Metodo hashCode para gerar um código hash baseado no código do produto
    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    // Metodo toString para exibir os dados do produto de forma legível
    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

// Classe ComparatorPorPreco implementa Comparator para permitir ordenação personalizada pelo preço
class ComparatorPorPreco implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco()); // Compara os preços de forma crescente
    }
}
