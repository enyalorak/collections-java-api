package main.java.list.Ordenacao;

import java.util.Comparator;

// A classe Pessoa implementa a interface Comparable para permitir ordenação
public class Pessoa implements Comparable<Pessoa> {
    @Override
    public int compareTo(Pessoa p) {
        return Integer.compare(idade, p.getIdade());
    }

    private String pessoa;
    private int idade;
    private double altura;

    @Override
    public String toString() {
        return "Pessoa{" +
                "pessoa='" + pessoa + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }

    public Pessoa(String pessoa, int idade, double altura) {
        this.pessoa = pessoa;
        this.idade = idade;
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public String getPessoa() {
        return pessoa;
    }

    public double getAltura() {
        return altura;
    }


}

// Classe que implementa a interface Comparator para comparar objetos Pessoa por altura
class ComparatorPorAltura implements Comparator<Pessoa> {

    // Implementação do metodo compare para comparar duas pessoas pela altura
    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
}
