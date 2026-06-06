package br.edu.ifsp.ads.dataArchitecture.bin2.revisao.metodosBasicos.utils;

import br.edu.ifsp.ads.dataArchitecture.bin2.arvoreBinaria.No;
import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.metodosBasicos.model.Node;

public class Utils {
    public static boolean isNull(Node branch){
        return branch == null;
    }

    public static Node createNodeLeaf(int value){
        Node node = new Node(value);
        node.left = null;
        node.right = null;
        return node;
    }

    public static boolean isLeaf(Node node){
        return !isNull(node) && isNull(node.left) && isNull(node.right);
    }

    /**
     * @param dad nó pai, que vai ganhar o filho
     * @param sonValue valor do filho, que virará uma folha e sera atribuido ao pai
     * @return retorna o filho já atribuido.
     */
    public static Node decideWhereInsert(Node dad, int sonValue){
        if( dad.value >= sonValue){
            return dad.right;
        }else{
            return dad.left;
        }
    }




    public static void exibeArvore(Node raiz) {
        if (isNull(raiz)) {
            System.out.println("(árvore vazia)");
            return;
        }

        if (!isNull(raiz.right)) {
            exibeArvoreVisual(raiz.right, "", false);
        }

        System.out.println(raiz.value);

        if (!isNull(raiz.left)) {
            exibeArvoreVisual(raiz.left, "", true);
        }
    }

    public static void exibeArvoreVisual(Node no, String prefixo, boolean ehEsquerdo) {
        if (isNull(no)) {
            return;
        }

        if (!isNull(no.right)) {
            exibeArvoreVisual(
                    no.right,
                    prefixo + (ehEsquerdo ? "│   " : "    "),
                    false
            );
        }

        System.out.println(prefixo + (ehEsquerdo ? "└── " : "┌── ") + no.value);

        if (!isNull(no.left)) {
            exibeArvoreVisual(
                    no.left,
                    prefixo + (ehEsquerdo ? "    " : "│   "),
                    true
            );
        }
    }

}
