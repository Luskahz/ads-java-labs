package br.edu.ifsp.ads.dataArchitecture.listaLigadaCircular;

import java.util.Scanner;

public class Primos {

    static No inicio = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o valor de N: ");
        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            inserir(i);

        }
        System.out.println("---");
        exibir(inicio);
        System.out.println("---");
        primos(N);
        System.out.println("---");
        exibir(inicio);
        System.out.println("---");
        System.out.println("Existem "+tamanho(inicio)+" numeros primos entre 0 e "+ N);
    }

    private static void primos(int n){
        while (inicio != null && inicio.valor <2){// aqui eu sei que o 0 e o 1 n são primos, já tiro eles na lata.
            inicio = inicio.prox;
        }

        for(No base = inicio; base != null; base = base.prox){
            No anterior = base;
            for(No indice = base.prox; indice != null;){
                if(indice.valor % base.valor == 0){
                   anterior.prox = indice.prox;
                   indice = indice.prox;
                }else{
                    anterior = indice;
                    indice = indice.prox;

                }

            }

        }

    }

    private static int tamanho(No temp){
        int tamanho = 0;
        No tmp = temp;

        if(tmp==null){
            return tamanho;
        }

        while(tmp != null){
            tamanho++;
            tmp = tmp.prox;
        }

        return tamanho;
    }
    private static void inserir(int x) {
        No novo = new No(x);
        if(inicio == null){
            inicio=novo;
            return;
        }
        No tmp = inicio;
        while(tmp.prox != null){
            tmp = tmp.prox;
        }
        tmp.prox = novo;
    }
    private static void exibir(No temp) {
        if(inicio==null){
            System.out.println("fila vazia");
            return;
        }
        No tmp = inicio;
        while(tmp != null){
            System.out.println(String.valueOf(tmp.valor));
            tmp = tmp.prox;
        }
    }

}
