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
        while (inicio.valor <2){// aqui eu sei que o 0 e o 1 n são primos, já tiro eles na lata.
            inicio = inicio.prox;
        }

        for(No base = inicio; base.prox != null; base = base.prox){// a base aqui é 2. e ele vai avançar até o final
            No anterior = base;
            for(No indice = base.prox; indice.prox != null; indice = indice.prox){ // aqui eu crio o indice, o indice é o proximo após a base, no caso aqui é o 3, e ele vai rodar até o final tbm
                if(indice.valor % base.valor == 0){

                   anterior.prox = indice.prox;
                   indice = anterior.prox;
                }
                anterior = anterior.prox;
            }

        }


        // o 3 é divisível por 2? não,
        // logo o indice agora é o 4 e o anterior é o 3,
        // o 4 é divisivel por 2? sim, então ele tem que sair,
        // 3.prox=4 agora é o 4.prox=5 ou seja, puxei o 5 pro indice, então o indice então eu tenho que voltar o indice pois ele vai incrementar não poderia andar pois agora o indice q era o 4 e tinha q virar o 5, foi pro 6
        // ou seja, o 3.prox agora é = 5,
        // e eu vou comparar o 6 com o 2, é divisivel, então eu tiro o 6
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
