package br.edu.ifsp.ads.dataArchitecture.bin2.balanceamento;

import br.edu.ifsp.ads.dataArchitecture.bin2.arvoreBinaria.No;

public class main {
    static No raiz = null;

    public static void main(String[] args) {
        int[] valores = {
           10, 20, 30
        };

        for (int x : valores) {
            inserirBinario(x);
        }
        exibeArvore(raiz);
        //System.out.println("Profundidade: " + profundidade(raiz));
        //exibirFatBalRamos(raiz);




    }



    public static No balancear(No ramo){
        if(!isVazio(ramo)){
            balancear(ramo.left);
            if(!isBalanced(ramo)){// a partir do momento que sei que não está balanceado, eu preciso fazer duas verificações pra saber como girar. se vai ser XX ou XY

                int fb = fatBalRamo(ramo);// eu ainda preciso verificar o fatB, pois o indicador vai definir pra que lado vai ser o giro
                if (isPositive(fb)) {
                    // aqui eu sei que o giro sempre vai ser pra direita. e vou verificar os ramos da esquerda
                    // após saber que é pra direita, eu preciso ver se é simples ou rot dupla.
                    // pra isso eu preciso saber o fb do filho da esquerda
                    int fatBFilho = fatBalRamo(ramo.left);
                    if (fatBFilho >= 0) {
                        ramo = girarDireita(ramo);
                    } else {
                        ramo.left = girarEsquerda(ramo.left);
                        ramo = girarDireita(ramo);
                    }
                } else{
                    girarEsquerda(ramo);
                }

            }
            balancear(ramo.right);
        }
        return null;
    }



    /**
     * Identifica a direção do filho existente de um nó.
     *
     * <p>Retorna:
     * <ul>
     *     <li>{@code 0} se o nó for folha;</li>
     *     <li>{@code 1} se o nó possuir apenas filho à direita;</li>
     *     <li>{@code 2} se o nó possuir filho à esquerda.</li>
     * </ul>
     *
     * <p>Observação: caso o nó possua dois filhos, o retorno será {@code 2},
     * pois a verificação prioriza a existência do filho à esquerda.
     *
     * @param ramo nó da árvore a ser analisado
     * @return código indicando a direção do filho existente
     */
    public static int childDirection(No ramo) {
        if (!ehFolha(ramo)) {
            if (isVazio(ramo.left)) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }


//    public static No balancear(No ramo) {
//        if (!isVazio(ramo)) {
//            balancear(ramo.left);// aqui ela foi pra esquerda o maximo que deu, agora ela precisa balancear e ir volrando
//            balancear(ramo.right);
//            // preciso verificar o fator de balanceamento do nó
//            if(!ehAVL(fatBalRamo(ramo))){// se não cair nesse if, o nó está balanceado, ai ele avança. se cair..
//                // se estiver desbalanceado preciso identificar qual o lado está desbalanceado pra fazer a rotação
//                if(ehAVL(fatBalRamo(ramo.right))&& !ehAVL(fatBalRamo(ramo.left))){ // se a esquerda estiver desbalanceada eu sei que eu tenho que rodar o ramo pra esquerda
//                    girarEsquerda(ramo);
//                } else if(!ehAVL(fatBalRamo(ramo.right))&& ehAVL(fatBalRamo(ramo.left))){
//                    girarDireita(ramo);
//                }
//            }
//
//        }
//    }





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




    public static boolean isBalanced(No ramo){
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

        if (!isBalanced(ramo)) {
            return false;
        }

        return threeEhAVL(ramo.left) && threeEhAVL(ramo.right);
    }





    public static void exibirRecursivo(No ramo){
        if(!isVazio(ramo)){
            exibirRecursivo(ramo.left);
            // processamento, baseado no...
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
        No tmp = ramo.left;
        ramo.left = tmp.right;
        tmp.right = ramo;
        return tmp;
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
    public static boolean ehFolha(No ramo){ return isVazio(ramo.left) && isVazio(ramo.right);}
    public static boolean isPositive(int x){ return x>0;}
    public static boolean isZero(int x){return x == 0;}
}
