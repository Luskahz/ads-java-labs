package br.edu.ifsp.ads.dataArchitecture.bin1.revisaoProva.centro;

public class main {
    static No inicio = null;
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Inserindo: " + i);
            No no = new No(i);
            inserirfinal(no);
        }
        findCenter(inicio);



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

    public static void exibir(){
        if(inicio == null){
            System.out.println("lista vazia");
        }
        else if(inicio.prox ==inicio || inicio.ant ==inicio){
            System.out.println(inicio.valor);
        }else{
            No tmp = inicio;
            do{
                System.out.println(tmp.valor);
                tmp = tmp.prox;

            }while(tmp != inicio);
        }

    }

    public static void findCenter(No inicio){
        No slow = inicio;
        No fast = inicio;
        if (inicio == null) {
            System.out.println("lista vazia");
            return;
        }

        if(fast.prox == inicio){
            System.out.println("o valor do centro da lista é: " + slow.valor);
            return;
        }
        if(fast.prox.prox == inicio){
            System.out.println("o valor central da lista é a media entre: " + slow.valor + " e " + slow.prox.valor);
            System.out.println("o valor central é: " + ((double) slow.valor + slow.prox.valor) / 2);
            return;
        }

        while(fast.prox != inicio && fast.prox.prox != inicio){
            slow = slow.prox;
            System.out.println(slow.valor);
            fast = fast.prox.prox;
            System.out.println(fast.valor);

        }
        if(fast.prox == inicio){
            System.out.println("o valor do centro da lista é: " + slow.valor);
        } else{
            System.out.println("o valor central da lista é a media entre: " + slow.valor + " e " + slow.prox.valor);
            System.out.println("o valor central é: " + ((double) slow.valor + slow.prox.valor) / 2);
        }

    }

    static int centroEderson(){
        No tempP = inicio.prox;
        No tempA = inicio.ant;

        while((tempP!=tempA) && (tempP.prox != tempA)){
            tempP = tempP.prox;
            tempA = tempA.ant;
        }
        if(tempP == tempA)
            return tempP.valor;
        else
            return (tempP.valor + tempA.valor)/2;
    }

}

