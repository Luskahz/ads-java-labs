package br.edu.ifsp.ads.dataArchitecture.bin2.arvBinMetodosAuxiliares;

public class main {
    static No raiz = null;

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {

            int x = (int) (Math.random()*30);
            inserirExclusivo(x);
        }

        exibirRecursivo(raiz);
        System.out.println(contaFilhos(10));
    }

    public static boolean exists(int x){
        No tmp = raiz;
        while(!isNull(tmp)){
            if(x == tmp.value){
                return true;
            }else if(x < tmp.value){
                tmp = tmp.left;
            } else{
                tmp = tmp.right;
            }
        }
        return false;
    }


    public static int contaFilhos(int x){
        No tmp = raiz;
        int qtd = 0;
        while(!isNull(tmp)){
            if(x == tmp.value){
                if(!isNull(tmp.right)){
                    qtd++;
                }
                if(!isNull(tmp.left)){
                    qtd++;
                }
                return qtd;
            }else if(x < tmp.value){
                tmp = tmp.left;
            } else{
                tmp = tmp.right;
            }
        }
        return -1;
    }


    public static void inserirExclusivo(int x){
        if(exists(x)){
            System.out.println("Não inserindo: " + x );
            return;
        }
        System.out.println("inserindo: "+ x);

        No novo = new No(x);
        if(isNull(raiz)){
            raiz = novo;
        }else{
            No tmp = raiz;
            boolean inserted = false;
            while(!inserted){
                if(x <= tmp.value){
                    if(isNull(tmp.left)){
                        tmp.left = novo;
                        inserted = true;
                    }else{
                        tmp = tmp.left;
                    }
                }else{
                    if(isNull(tmp.right)){
                        tmp.right = novo;
                        inserted = true;
                    }else{
                        tmp = tmp.right;
                    }
                }

            }

        }
    }


    public static void exibirRecursivo(No ramo){
        if(!isNull(ramo)){
            exibirRecursivo(ramo.left);
            System.out.println(ramo.value);
            exibirRecursivo(ramo.right);
        }
    }
    static void exibeArvore(No n, int x){

        if(n.right != null)
            exibeArvore(n.right, x+1);
        else
            System.out.println();

        for(int i=1; i<=x; i++)
            System.out.print("|  ");

        if((n.left == null)&&(n.right == null))
            System.out.print("["+n.value+"]");
        else
            System.out.print(n.value);

        if(n.left != null)
            exibeArvore(n.left, x+1);
        else
            System.out.println();

    }

    public static void contarFilhosRec(No ramo){
        if(!isNull(ramo)){
            contarFilhosRec(ramo.left);
            System.out.println(ramo.value);
            contarFilhosRec(ramo.right);
        }
    }


    public static boolean isNull(No no){
        return no == null;
    }








    static void remover(int x){
        No tmp = raiz;
        if(tmp.value == x){//neste caso o valor de x n é o valor do temp, sabendo disso prossigo
            if(eFolha(tmp)){// se for folha eu retiro, pois sei que é o valor do X
                tmp = null;
            }else{ // se n for folha, ele tem algo embaixo
                if(eNoDuplo(tmp))//se ambos os lados tiverem ocupados, vou precisar verificar como tratar os filhos;
                    removeDoisFilhos(tmp,x);//metodo para realocar os filhos mediante a inexistencia da raiz;
                else{// se ele n for um nó, ou tem algo na direita ou tem algo na esquerda
                    if(isNull(tmp.left)){// se tiver algo na esquerda(lembrando q ele n é um noDuplo logo se aqui true a direita n tem nada).
                        tmp = tmp.right;// agora a raiz vai passar a ser o right;
                    }
                    else{
                        tmp = tmp.left; // o mesmo aqui porem a esquerda passa a ser a raiz;
                    }
                }

            }
        }else{// aqui eu saio do case 1, o case 1 era caso eu quisesse apagar o primeiro nó apenas, exclusivamente
            removeNo(tmp, x);//esse metodo tem de tratar da remoção caso o nó não seja a raiz da arvore

        }

    }

    static void removeNo(No n, int x){// esse metodo remove qualquer nó que n é a raiz

        int f = contaFilhos(x);// aqui ele vai buscar na raiz o nó referente ao valor e verificar se ele tem filhos ou não, abaixo tomamos uma decisão mediante a quantidade de filhos

        switch(f){
            case -1: System.out.println("O nó não existe na árvore"); break;
            case  0: removeFolha(n,x); break;
            case  1: removeUmFilho(n,x); break;
            case  2: removeDoisFilhos(n,x); break;
        }
    }

    public static void removeFolha(No no, int x){

    }

    public static void removeUmFilho(No no, int x){
    }

    public static void removeDoisFilhos(No no, int x){
    }


    static boolean eFolha(No no){
        return((isNull(no.left)) && (isNull(no.right)));
    }
    static boolean eNoDuplo(No no){
        return ((!isNull(no.left)) && (!isNull(no.right)));
    }

    static void navegar(No no, int x){

    }

}
