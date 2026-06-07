package br.edu.ifsp.ads.dataArchitecture.bin2.revisao.utils;

import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.model.Node;

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




    public static void exibeArvore(Node root) {
        if (isNull(root)) {
            System.out.println("(árvore vazia)");
            return;
        }

        if (!isNull(root.right)) {
            exibeArvoreVisual(root.right, "", false);
        }

        soutValue(root);

        if (!isNull(root.left)) {
            exibeArvoreVisual(root.left, "", true);
        }
    }

    public static void exibeArvoreVisual(Node node, String prefix, boolean isLeft) {
        if (isNull(node)) {
            return;
        }

        if (!isNull(node.right)) {
            exibeArvoreVisual(
                    node.right,
                    prefix + (isLeft ? "│   " : "    "),
                    false
            );
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + showIfItIsLeaf(node));

        if (!isNull(node.left)) {
            exibeArvoreVisual(
                    node.left,
                    prefix + (isLeft ? "    " : "│   "),
                    true
            );
        }
    }

    public static String retValue(Node node){
        return ""+node.value;
    }
    public static void soutValue(Node node){
        System.out.println(node.value);
    }
    public static String showLeaf(Node node ){
        return "["+node.value+"]";
    }

    public static void soutLeaf(Node node){
        System.out.println("["+ node.value +"]");
    }

    public static String showIfItIsLeaf(Node node){
        if(isLeaf(node)){
            return showLeaf(node);
        } else{
            return retValue(node);
        }
    }
    public static boolean isEqual(int value, Node node){
        return value == node.value;
    }

}
