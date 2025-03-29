package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao ) {
        livroList.add(new Livro(titulo, autor, anoPublicacao));

    }

    public  List<Livro> pesquisarPorAutor(String autor) {
        //  lista temporária para armazenar os livros encontrados
        List<Livro> livrosPorAutor = new ArrayList<>();

        // Verifica se a lista de livros (livroList) não está vazia antes de pesquisar
        if(!livroList.isEmpty()){
            for(Livro livro : livroList){
                // Verifica se o autor do livro é igual ao autor informado (ignorando maiúsculas e minúsculas)
                if(livro.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(livro);
                }
            }
        }
        // Retorna a lista de livros que correspondem ao autor informado
        return livrosPorAutor;
    }

   public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPorAnos = new ArrayList<>();
        if(!livroList.isEmpty()){
            for(Livro livro : livroList){
                if(livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal){
                    livrosPorAnos.add(livro);
                }
            }
        }
        return livrosPorAnos;
   }

    public Livro pesquisarPorTitulo(String titulo){
        // Inicializa a variável livroPorTitulo como null (caso o livro não seja encontrado)
        Livro livroPorTitulo = null;
        if(!livroList.isEmpty()){
            for(Livro livro : livroList){
                if(livro.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = livro;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros c = new CatalogoLivros();

        c.adicionarLivro("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
        c.adicionarLivro("Java Guia do Programador", "Peter Jandl Junior", 2021);
        c.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        c.adicionarLivro("O Codificador Limpo", "Robert C. Martin", 2012);

        System.out.println(c.pesquisarPorAutor("Susan J. Fowler"));
        System.out.println(c.pesquisarPorAutor("Autor Inexistente"));
        System.out.println(c.pesquisarPorIntervaloAnos(2010, 2022));

        // Exibindo livros dentro de um intervalo de anos (caso em que não há livros no intervalo)
        System.out.println(c.pesquisarPorIntervaloAnos(2025, 2030));

        // Exibindo livros por título
        System.out.println(c.pesquisarPorTitulo("Java Guia do Programador"));

        // Exibindo livros por título (caso em que não há livros com o título especificado)
        System.out.println(c.pesquisarPorTitulo("Título Inexistente"));
    }

    }
