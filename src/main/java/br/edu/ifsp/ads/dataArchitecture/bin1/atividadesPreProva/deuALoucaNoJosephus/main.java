package br.edu.ifsp.ads.dataArchitecture.bin1.atividadesPreProva.deuALoucaNoJosephus;

public class main {
    static No inicio = null;

    /**
     * <p>Usando seus conhecimentos sobre o problema de Josephus, crie um método que:</p>
     *
     * <p>Dados N, S e J, onde N é o número de elementos da LDLC,
     * S é o número de saltos para frente e J é o número de saltos para trás:</p>
     *
     * <p>Crie uma Lista Duplamente Ligada Circular e atribua a ela elementos de 1 a N.</p>
     *
     * <p>Implemente o Josephus de forma que seja eliminado o nó S passos para frente e,
     * em seguida, seja eliminado o nó que está J passos para trás, até que reste somente
     * um nó na lista.</p>
     *
     * <p>No final, exiba o valor desse nó.</p>
     *
     * <p>Observação: você não pode usar o método remover para fazer as remoções.
     * A remoção deve estar implementada no próprio método Josephus.</p>
     */
    public static void main(String[] args) {

        int N = 5;
        int S = 2;
        int J = 2;

        for (int i = 1; i <= N; i++) {
            insereFinal(i);
        }

        exibir();
        System.out.println("josephus");
        josephus2(S, J);
        System.out.println("pós : josephus");
        exibir();

    }

    static void josephus(int s, int j){
        while(inicio!=inicio.prox){



            for(int i=1;i<s-1;i++){
                inicio = inicio.prox;
            }
            inicio.prox.prox.ant = inicio;
            inicio.prox = inicio.prox.prox;
            inicio = inicio.prox;


            for(int i=1;i<j-1;i++) {
                inicio = inicio.ant;
            }
            inicio.ant.ant.prox = inicio;
            inicio.ant = inicio.ant.ant;
            inicio = inicio.ant;



        }
    }
    static void josephus2(int a, int b){
        No temp = inicio;
        while(temp != temp.prox){
            for(int i=0; i<(a-1); i++)
                temp = temp.prox;
            temp.ant.prox = temp.prox;
            temp.prox.ant = temp.ant;
            temp = temp.ant;

            for(int i=0; i<(b-1); i++)
                temp = temp.ant;
            temp.ant.prox = temp.prox;
            temp.prox.ant = temp.ant;
            temp = temp.prox;
        }
    }


    static void insereFinal(int x) {
        No novo = new No(x);

        if (inicio == null) {
            inicio = novo;
            inicio.prox = inicio;
            inicio.ant = inicio;
        } else {
            No temp = inicio;

            while (temp.prox != inicio) {
                temp = temp.prox;
            }

            temp.prox = novo;
            novo.ant = temp;

            novo.prox = inicio;
            inicio.ant = novo;
        }
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
}
