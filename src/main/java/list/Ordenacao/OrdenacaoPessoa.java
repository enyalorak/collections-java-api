package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Classe responsável por armazenar e ordenar uma lista de pessoas
public class OrdenacaoPessoa {
    // Lista que armazena objetos do tipo Pessoa
    private List<Pessoa> pessoaList;

    // Construtor que inicializa a lista de pessoas
    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    //Metodo para adicionar uma nova pessoa à lista
    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    // Metodo para ordenar a lista de pessoas por idade
    public List<Pessoa> ordernarPorIdade() {
        // Cria uma cópia da lista original para evitar modificar a lista principal
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);

        // Ordena a cópia da lista usando o metodo compareTo da classe Pessoa
        Collections.sort(pessoasPorIdade);

        // Retorna a lista ordenada
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        pessoasPorAltura.sort(new ComparatorPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        // Criando uma instância da classe OrdenacaoPessoa
        OrdenacaoPessoa OrdenacaoPessoa = new OrdenacaoPessoa();
// Adicionando pessoas à lista
        OrdenacaoPessoa.adicionarPessoa("Alice", 20, 1.56);
        OrdenacaoPessoa.adicionarPessoa("Bob", 30, 1.80);
        OrdenacaoPessoa.adicionarPessoa("Charlie", 25, 1.70);
        OrdenacaoPessoa.adicionarPessoa("David", 17, 1.56);

        System.out.println(OrdenacaoPessoa.ordernarPorIdade());

        System.out.println(OrdenacaoPessoa.ordenarPorAltura());


    }

    }
