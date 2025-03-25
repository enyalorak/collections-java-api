package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> tarefaList;

    //criar construtor
    //sempre que eu criar um obj do tipo listataerfa automaticamente
    //termos um atributos tarefaList com um arraylist vazio
    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    //implementar metodos
public void adicionarTarefa(String descricao) {

        tarefaList.add(new Tarefa(descricao));
}

//adicionar as tarefas para esse array tarefasParaRemover
    //se a descricao da tarefas for = a descricoa que foi passada ela sera adicionada ao array tarefasParaRemover
public void removerTarefa(String descricao) {
    List<Tarefa> tarefasParaRemover = new ArrayList<>();
    for(Tarefa tarefa: tarefaList){
        if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
            tarefasParaRemover.add(tarefa);
        }
    }
//td que tver dentro de tarefas para remover sera removido
    tarefaList.removeAll(tarefasParaRemover);

    }

    //size retorna a quantidade de elementos dentro da list
    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        System.out.println("o numero total da lista é:" + listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");

        System.out.println("O número total de elementos da lista é:" + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("Tarefa 1");
        System.out.println("O número total de elementos da lista é:" + listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.obterNumeroTotalTarefas();
    }
}
