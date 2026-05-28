package br.edu.ifsp.ads.dataArchitecture.bin2.balanceamento;

import br.edu.ifsp.ads.dataArchitecture.bin2.arvoreBinaria.No;

public class main {
    static No raiz = null;

    public static void main(String[] args) {
        int[] valores = {
           1, 2, 3, 4, 5, 6, 7
        };

        for (int x : valores) {
            System.out.println("Inserindo: " + x);
            inserirBinario(x);
        }

        exibeArvore(raiz);
        System.out.println("Profundidade: " + profundidade(raiz));
        exibirFatBalRamos(raiz);

        while(!threeEhAVL(raiz)){// isso vai rodar enquanto a arvore estiver desbalanceada

        }

    }

    public static No balancear(No ramo) {
        if (!isVazio(ramo)) {
            balancear(ramo.left);// aqui ela foi pra esquerda o maximo que deu, agora ela precisa balancear e ir volrando
            balancear(ramo.right);
            // preciso verificar o fator de balanceamento do nó
            if(!ehAVL(fatBalRamo(ramo))){// se não cair nesse if, o nó está balanceado, ai ele avança. se cair..
                // se estiver desbalanceado preciso identificar qual o lado está desbalanceado pra fazer a rotação
                if(ehAVL(fatBalRamo(ramo.right))&& !ehAVL(fatBalRamo(ramo.left))){ // se a esquerda estiver desbalanceada eu sei que eu tenho que rodar o ramo pra esquerda
                    girarEsquerda(ramo);
                } else if(!ehAVL(fatBalRamo(ramo.right))&& ehAVL(fatBalRamo(ramo.left))){
                    girarDireita(ramo);
                }
            }

        }
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


    /**
     * @param ramo nó cujo quero descobrir o fator de balanceamento
     * @return retorna o fator de balanceamento do ramo;
     */
    public static int fatBalRamo(No ramo){
        int left = profundidade(ramo.left);
        int right = profundidade(ramo.right);

        return Math.subtractExact(left, right);
    }




    public static int profundidade(No ramo) {
        if (isVazio(ramo)) {
            return -1;
        }

        int profundidadeEsquerda = profundidade(ramo.left);
        int profundidadeDireita = profundidade(ramo.right);

        return 1 + Math.max(profundidadeEsquerda, profundidadeDireita);
    }




    public static boolean ramoEhAVL(No ramo){
        return fatBalRamo(ramo) <= 1 && fatBalRamo(ramo) >= -1;
    }

    public static void exibirFatBalRamos(No ramo) {
        if (!isVazio(ramo)) {
            exibirFatBalRamos(ramo.left);
            System.out.println(ramo.value+ " -> FB = "+fatBalRamo(ramo));
            exibirFatBalRamos(ramo.right);
        }
    }

    public static boolean threeEhAVL(No ramo) {
        if (isVazio(ramo)) {
            return true;
        }

        if (!ramoEhAVL(ramo)) {
            return false;
        }

        return threeEhAVL(ramo.left) && threeEhAVL(ramo.right);
    }





    public static void exibirRecursivo(No ramo){
        if(!isVazio(ramo)){
            exibirRecursivo(ramo.left);
            System.out.println(ramo.value);
            exibirRecursivo(ramo.right);
        }
    }



    public static int maior(No ramo) {
        if (isVazio(ramo)) {
            throw new IllegalArgumentException("A árvore está vazia.");
        }

        if (!isVazio(ramo.right)) {
            return maior(ramo.right);
        }

        return ramo.value;
    }
    public static int menor(No ramo) {
        if (isVazio(ramo)) {
            throw new IllegalArgumentException("A árvore está vazia.");
        }

        if (!isVazio(ramo.left)) {
            return menor(ramo.left);
        }

        return ramo.value;
    }

    public static void exibeFolhas(No ramo) {
        if (!isVazio(ramo)) {
            if (isVazio(ramo.left) && isVazio(ramo.right)) {
                System.out.println(ramo.value);
            }

            exibeFolhas(ramo.left);
            exibeFolhas(ramo.right);
        }
    }

    public static void exibeArvore(No raiz) {
        if (isVazio(raiz)) {
            System.out.println("(árvore vazia)");
            return;
        }

        if (!isVazio(raiz.right)) {
            exibeArvoreVisual(raiz.right, "", false);
        }

        System.out.println(raiz.value);

        if (!isVazio(raiz.left)) {
            exibeArvoreVisual(raiz.left, "", true);
        }
    }

    public static void exibeArvoreVisual(No no, String prefixo, boolean ehEsquerdo) {
        if (isVazio(no)) {
            return;
        }

        if (!isVazio(no.right)) {
            exibeArvoreVisual(
                    no.right,
                    prefixo + (ehEsquerdo ? "│   " : "    "),
                    false
            );
        }

        System.out.println(prefixo + (ehEsquerdo ? "└── " : "┌── ") + no.value);

        if (!isVazio(no.left)) {
            exibeArvoreVisual(
                    no.left,
                    prefixo + (ehEsquerdo ? "    " : "│   "),
                    true
            );
        }
    }

    public static No girarDireita(No ramo){
        No tmp = ramo.left; //torna o temp o filho a esquerda do ramo
        ramo.left = tmp.right; // o filho a esquerda do ramo, passa a serer o filho a direita do temp.
        tmp.right = ramo; // e o filho a direita do temp passa a ser o ramo
        return tmp; //retorno o temp
    }

    public static No girarEsquerda(No x){
        No y = x.right; //Seja Y o filho à direita de X
        x.right = y.left; // Torne o filho à esquerda de Y o filho à direita de X.
        y.left = x; // Torne X o filho à esquerda de Y
        return y;
    }




    public static boolean isVazio(No no){
        return no == null;
    }
    public static boolean ehAVL(int x){
        return x <= 1 && x >= -1;
    }
}
