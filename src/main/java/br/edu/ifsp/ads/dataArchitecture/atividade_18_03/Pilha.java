package br.edu.ifsp.ads.dataArchitecture.atividade_18_03;

import org.w3c.dom.ls.LSOutput;

public class Pilha {
    private No topo; // topo é o nó de controle da lista o "início" da implementação anterior
    
    public Pilha(){
        this.topo = null;
    }

    public void empilhar(int x){
        No novo = new No(x);// crio o no
        novo.prox = topo;// atribuo a lista já existente após o nó
        topo = novo;// defino o topo como o nó recem colocado
    }
    public void desempilhar(){
        if(topo==null){
            System.out.println("pilha vazia");
            return;
        }
        System.out.println("Valor retirado: " + topo.valor);
        topo = topo.prox;

    }
    public int topo() {
        if (vazia()) {
            System.out.println("pilha vazia");
            throw new RuntimeException("Pilha vazia");
        }
        return topo.valor;
    }
    public boolean vazia(){
        return topo==null;
    }
    public int tamanho(){
        int tamanho = 0;
        No tmp = topo;

        if(tmp==null){
            return tamanho;
        }

        while(tmp != null){
            tamanho++;
            tmp = tmp.prox;
        }

        return tamanho;
    }
    public void exibir(){
        No tmp = topo; // pego o nó mais recente
        if(tmp==null){ // se ele for null, tá vazio
            System.out.println("fim da lista");
            return;
        }
        while(tmp != null){
            System.out.println(String.valueOf(tmp.valor));
            tmp = tmp.prox;
        }

        
    }
    
}
