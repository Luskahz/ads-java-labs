package br.edu.ifsp.ads.dataArchitecture.linkedListCircular;

import java.util.Scanner;

public class Main {

    static No inicio = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- iniciou a inserção --");

        System.out.print("Informe o valor de N: ");
        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            System.out.println("-----");
            System.out.println("tamanho da lista antes de inserir o "+i+": "+String.valueOf(tamanho(inicio)));
            System.out.println("inserindo "+i+": "+String.valueOf(i));
            inserirFinal(i);
            System.out.println("Lista:");
            exibir(inicio);
            System.out.println("tamanho da lista após inserir: "+String.valueOf(tamanho(inicio)));
        }
        System.out.println("-- finalizou a inserção --");
        System.out.println("Lista:");
        exibir(inicio);
        System.out.println("-----");
        System.out.println("-- iniciando testes: --");
        removerInicio();
        removerUltimo();
        removerUltimo();
        System.out.println("--- após remover 1 inicio e remover 2 ultimos: ---");
        System.out.println("Lista:");
        exibir(inicio);
        System.out.println("---");
        System.out.println("tamanho da lista: " + String.valueOf(tamanho(inicio)));
    }

    private static int tamanho(No inicio){
        if(inicio == null) return 0;
        if(inicio.prox==inicio) return 1;

        int tamanho = 1;
        No atual = inicio;
        while(atual.prox != inicio){
            tamanho++;
            atual = atual.prox;
        }
        return tamanho;
    }

    private static void inserirFinal(int x) {
        No novo = new No(x);
        if(inicio == null){
            inicio=novo;
            inicio.prox = inicio;
            return;
        }
        No tmp = inicio;
        while(tmp.prox != inicio){
            tmp = tmp.prox;
        }
        tmp.prox = novo;
        novo.prox = inicio;
    }

    private static void exibir(No inicio) {
        if(inicio==null){
            System.out.println("lista vazia");
            return;
        }
        No atual = inicio;

        do{
            System.out.println(String.valueOf(atual.valor));
            atual = atual.prox;
        } while(atual != inicio);

    }

    public static void removerUltimo(){
        if(inicio==null){
            System.out.println("fila vazia");
            return;
        }
        if(inicio.prox == inicio){
            System.out.println("Ultimo valor retirado: " + inicio.valor);
            inicio = null;
            return;
        }


        No tmp = inicio;
        while(tmp.prox.prox != inicio){
            tmp = tmp.prox;
        }


        System.out.println("Ultimo valor retirado: " + tmp.prox.valor);
        tmp.prox = inicio;

    }
    public static void removerInicio(){
        if(inicio==null){
            System.out.println("fila vazia");
            return;
        }
        if(inicio.prox == inicio){
            System.out.println("primeiro valor retirado: " + inicio.valor);
            inicio = null;
            return;
        }

        No tmp = inicio;
        while(tmp.prox.prox != inicio){
            tmp = tmp.prox;
        }


        System.out.println("primeiro valor retirado: " + tmp.prox.prox.valor);
        tmp.prox.prox = inicio.prox;
        inicio = inicio.prox;

    }



}
