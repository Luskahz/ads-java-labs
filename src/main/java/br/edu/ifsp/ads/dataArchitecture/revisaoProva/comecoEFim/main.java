package br.edu.ifsp.ads.dataArchitecture.revisaoProva.comecoEFim;


public class main {
    static No inicio = null;
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Inserindo: " + i);
            No no = new No(i);
            inserirfinal(no);
        }
    }

    public static void inserirfinal(No no){
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

}
