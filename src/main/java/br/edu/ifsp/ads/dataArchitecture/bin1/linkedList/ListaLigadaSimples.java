package br.edu.ifsp.ads.dataArchitecture.bin1.linkedList;

public class ListaLigadaSimples {

    static No inicio = null;

    public static void main(String[] args) {

//        for (int i = 0; i < 30; i++) {
//
//            int x = (int) (Math.random()*30);
//            System.out.println("Inserindo: "+x);
//
//            insereOrdenado(x);
//        }
        insereOrdenado(0);
        insereOrdenado(1);
        insereOrdenado(3);
        insereOrdenado(2);



        exibir();

    }

    public static void inserir(int x){
        No novo = new No(x);

        if(inicio == null)
            inicio = novo;
        else{
            No temp = inicio;
            while(temp.prox != null) //navegação até o final da lista
                temp = temp.prox;
            //aqui temp está no último nó da lista
            temp.prox = novo;
        }
    }


    public static void exibir(){
        if(inicio == null)
            System.out.println("Lista Vazia, nada a exibir.");
        else{
            System.out.println("--- Lista ----");
            No temp = inicio;
            while(temp != null){
                System.out.println(temp.valor);
                temp = temp.prox;
            }
        }
    }

    public static void insereOrdenado(int valor){
        No novo = new No(valor);

        if(inicio == null){
            inicio = novo;
            return;
        }
        if(novo.valor < inicio.valor){
            novo.prox = inicio;
            inicio = novo;
            return;
        }

        No temp = inicio;

            while(temp.prox != null){
                if(temp.prox.valor > novo.valor) {
                        novo.prox = temp.prox;
                        temp.prox = novo;
                        return;
                }
                  temp = temp.prox;
            }
            temp.prox = novo;
        }





    public static void removeUltimo(){
        if(inicio == null)
            System.out.println("lista vazia");
        if(inicio.prox ==null){
            inicio = null;
        }
        else {
            No temp = inicio;
            if (inicio.prox == null) {
                inicio = null;
                return;
            }

            No ant = null;

            while (temp.prox != null){
                ant = temp;
            temp = temp.prox;
            }
            ant.prox = null;
        }

    }

}