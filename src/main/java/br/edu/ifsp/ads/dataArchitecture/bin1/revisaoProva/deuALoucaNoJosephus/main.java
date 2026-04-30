package br.edu.ifsp.ads.dataArchitecture.bin1.revisaoProva.deuALoucaNoJosephus;

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
        josephus(S, J);
        System.out.println("pós : josephus");
        exibir();

    }

    public static void insereFinal(int x){
        No no = new No(x);
        if(inicio == null){
            inicio = no;
            inicio.ant = no;
            inicio.prox = no;
        } else if(inicio.prox == inicio|| inicio.ant == inicio){
            inicio.prox = no;
            no.prox = inicio;
            no.ant = inicio;
            inicio.ant = no;
        } else{
            No tmp = inicio;;
            while(tmp.prox != inicio){
                tmp = tmp.prox;
            }
            tmp.prox = no;
            no.prox = inicio;
            no.ant = tmp;
            inicio.ant = no;
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
    static void josephusLoucoEderson(int s, int j){
        while(inicio != inicio.prox){
            for(int i=0; i<(s-1); i++)
                inicio = inicio.prox;
            System.out.println("removendo "+inicio.valor);
            inicio.ant.prox = inicio.prox;
            inicio.prox.ant = inicio.ant;
            inicio = inicio.prox;

            for(int i=0; i<(j-1); i++)
                inicio = inicio.ant;
            System.out.println("removendo "+inicio.valor);
            inicio.ant.prox = inicio.prox;
            inicio.prox.ant = inicio.ant;
            inicio = inicio.ant;
        }
        System.out.println("Sobrevivente: "+inicio.valor);
    }
    static void josephus(int s, int j){
        while(inicio!=inicio.prox){
            for(int i=1;i<s-1;i++)
                inicio = inicio.prox;
            inicio.prox.prox.ant = inicio;
            inicio.prox = inicio.prox.prox;
            inicio = inicio.prox;


            for(int i=1;i<j-1;i++) {
                inicio = inicio.ant;
            }
            inicio.ant.ant.prox = inicio;
            inicio.ant = inicio.ant.ant;
            inicio = inicio.ant;

            System.out.println("Sobrevivente: "+inicio.valor);


        }
    }

}
