package br.edu.ifsp.ads.dataArchitecture.bin2.arvoreBinaria;

public class main {
    static No raiz = null;

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {

            int x = (int) (Math.random()*30);
            System.out.println("Inserindo: "+x);

            inserirBinario(x);
        }

        exibirRecursivo(raiz);
        exibeArvore(raiz, 0);
        System.out.println(maior(raiz));
        System.out.println(menor(raiz));
        exibeFolhas(raiz);
    }



    public static void inserirBinario(int x){
        No novo = new No(x);
        if(isVazio(raiz)){
            raiz = novo;
        }else{
            No tmp = raiz;
            boolean inserted = false;
            while(!inserted){
                if(x <= tmp.value){
                    if(isVazio(tmp.left)){
                        tmp.left = novo;
                        inserted = true;
                    }else{
                        tmp = tmp.left;
                    }
                }else{
                    if(isVazio(tmp.right)){
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
        if(!isVazio(ramo)){
            exibirRecursivo(ramo.left);
            System.out.println(ramo.value);
            exibirRecursivo(ramo.right);
        }
    }

    public static int maior(No ramo){
        int maior = ramo.value;
        if(!isVazio(ramo.right)){
            maior = maior(ramo.right);
        }
        return maior;
    }

    public static int menor(No ramo){
        int menor = ramo.value;
        if(!isVazio(ramo.left)){
            menor = menor(ramo.left);
        }
        return menor;
    }

    public static void exibeFolhas(No ramo){
        if(!isVazio(ramo)){
            if(isVazio(ramo.right) && isVazio(ramo.left)){
                System.out.println(ramo.value);
            }
            exibirRecursivo(ramo.left);
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



    public static boolean isVazio(No no){
        return no == null;
    }
}
