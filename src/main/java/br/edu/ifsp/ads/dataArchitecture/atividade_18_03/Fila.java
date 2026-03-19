package br.edu.ifsp.ads.dataArchitecture.atividade_18_03;

public class Fila {
    private No cabeca; // cabeca é o nó de controle da lista o "início" da implementação anterior
    
    public Fila(){
        this.cabeca = null;
    }
    
    public void enfileirar(int x){
        No novo = new No(x);
        if(cabeca == null) {
            cabeca = novo;
            return;
        }

        No tmp = cabeca;
        while(tmp.prox != null){
            tmp = tmp.prox;
        }
        tmp.prox = novo;

    }
    
    public void desenfileirar(){
        if(cabeca==null){
            System.out.println("fila vazia");
            return;
        }
        System.out.println("Valor retirado: " + cabeca.valor);
        cabeca = cabeca.prox;
        
    }
    public int cabeca(){
        if (vazia()) {
            System.out.println("fila vazia");
            throw new RuntimeException("fila vazia");
        }
        return cabeca.valor;
    }
    
    public int cauda(){

        if(vazia()){
            throw new RuntimeException("Fila vazia");
        }

        No tmp = cabeca;
        while(tmp.prox != null){
            tmp = tmp.prox;
        }
        return tmp.valor;
    }
    public boolean vazia(){
        return cabeca==null;
    }
    public int tamanho(){
        int tamanho = 0;
        No tmp = cabeca;

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
        if(vazia()){
            System.out.println("fila vazia");
            return;
        }
        No tmp = cabeca;
        while(tmp != null){
            System.out.println(String.valueOf(tmp.valor));
            tmp = tmp.prox;
        }
        
    }
    
}
