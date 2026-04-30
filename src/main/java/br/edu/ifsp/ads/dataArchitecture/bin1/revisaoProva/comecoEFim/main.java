package br.edu.ifsp.ads.dataArchitecture.bin1.revisaoProva.comecoEFim;


public class main {
    static No inicio = null;
    public static void main(String[] args) {
        for (int i = 1; i <= 99; i++) {
            System.out.println("Inserindo: " + i);
            No no = new No(i);
            inserirfinal(no);
        }
        comecoEFim(inicio, inicio.ant);
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
    public static void comecoEFim(No inicio, No fim){
        if(inicio == fim){
            System.out.println(inicio.valor);

        } else if( inicio.prox == fim && fim.ant == inicio){
            System.out.println(fim.valor +" - "+ inicio.valor);
        } else{
            System.out.println(inicio.valor+" - "+fim.valor);
            comecoEFim(inicio.prox, fim.ant);

        }

    }
    static void comecoeFimEderson(No up, No down){
        if((up.prox!=down) && (up != down)){
            System.out.println(up.valor + "\t" + down.valor);
            comecoeFimEderson(up.prox, down.ant);
        }else
        if(up!=down)
            System.out.println(up.valor + "\t" + down.valor);
        else
            System.out.println(up.valor);
    }
}
