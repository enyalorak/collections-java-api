package main.java.set.Pesquisa;

import java.util.Objects;

public class Contato {
    private String nome;
    private int numero;

    //constructor
    public Contato(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "{nome=" + nome + ", numero=" + numero + "}";

    }

    //comparar se os nomes são iguais
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(getNome(), contato.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNome());
    }
}
