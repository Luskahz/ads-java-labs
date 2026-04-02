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

    static void josephus(int s) {

        //1, 2, 3, 4, 5, 6, 7 (s=3)
        if (inicio == null || s <= 0) return;// aqui eu saio se o inicio for null ou se n vir o s

        No tmp = inicio; // inicio a contagem da lista

        while (tmp.prox != inicio) {
            tmp = tmp.prox;
        }//levei o temp pro fim da lista (tmp = 7)

        while (tmp != tmp.prox) {//agora isso vai rodar até eu finalizar o josephus
            for (int i = 1; i < s; i++) {
                tmp = tmp.prox;// eu to no ultimo nó, e vou andar até o i ser s-1, quando o i for s-1 eu apago o proximo
                //i=1 = tmp = 1
                //i=2 = tmp = 2
                //parou, tmp = 2
            }
            tmp.prox = tmp.prox.prox;
            // 3 = 4
        }

        inicio = tmp;
    }


}

