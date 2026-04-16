package br.edu.ifsp.ads.dataArchitecture.linkedListCircular;

public class ListaLigadaCircular {
    static No inicio = null;

    public static void main(String[] args) {

        int N = 7;
        int S = 3;

        for (int i = 1; i <= N; i++) {
            insereFinal(i);
        }

        exibir();

        josephus(S);

        System.out.println("JOSEPHUS");
        System.out.println("N = " + N);
        System.out.println("S = " + S);
        System.out.println("Sobrevivente: " + inicio.valor);

    }

    static void insereFinal(int x) {
        No novo = new No(x);

        if (inicio == null) {
            inicio = novo;
        } else {
            No temp = inicio;

            while (temp.prox != inicio) {
                temp = temp.prox;
            }

            temp.prox = novo;
        }
        novo.prox = inicio;
    }

    static void exibir() {
        if (inicio == null) {
            System.out.println("Lista VAZIA, nada a exibir");
        } else {
            No temp = inicio;
            do {
                System.out.println(temp.valor);
                temp = temp.prox;
            } while (temp != inicio);
        }
    }

    static void josephus(int s){
        while(inicio!=inicio.prox){ // aqui a função vai rodar até ficar só o nó sobrevivente
            for(int i=1;i<s-1;i++) // enquanto tem mais de 1 nó na lista, eu tenho o i, i inicia em 1, i vai até o valor a ser excluido -1, o i incrementa a cada execução
                inicio = inicio.prox; // resumindo, aqui eu to indo até o nó anterior ao que vai ser excluido, para ter acesso a ele e o prox.
            inicio.prox = inicio.prox.prox; // o proximo é oque vai ser excluido, o proximo dele, vai passar a ser ele, aqui ele foi excluido
            inicio = inicio.prox;  // aqui eu sigo o avanço do atual, o while reinicia e o loop vai até restar o sobrevivente
        }
    }


}

