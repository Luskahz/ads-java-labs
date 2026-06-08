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


    public static Node smallestNode(Node node){
        if(!Utils.isNull(node.left)){
            return smallestNode(node.left);
        }
        return node;
    }

    public static Node findChildByValue( Node dad, int value){
        if( !isNull(dad.left) && dad.left.value == value){
            return dad.left;
        } else if( !isNull(dad.right) && dad.right.value == value){
            return dad.right;
        } else{
            return null;
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
        if(isNull(node)){
            System.out.println("Nó está vazio");
            return;
        }
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

    public static Node findNodeByValueInTree(int value, Node root){
        if(Utils.isNull(root)){// se o nó for nulo, retorna nulo.
            return null;
        } else{
            if(Utils.isEqual(value, root)){// se n é null, ele verifica se encontrou, se encontrou retorna a referência do nó encontrado.
                return root;
            }

            return value >= root.value ? findNodeByValueInTree(value, root.right) : findNodeByValueInTree(value, root.left);
        }
    }

    public static Node findDadNodeInTree(int value, Node root){
        if(Utils.isNull(root)){// se o nó for nulo, retorna nulo.
            return null;
        } else{
            if(!Utils.isNull(root.left)&&Utils.isEqual(value, root.left)){// se o valor buscado for igual ao filho da esquerda do nó atual, eu sei que ele é o pai dele.
                return root;
            } else if(!Utils.isNull(root.right)&& Utils.isEqual(value, root.right)){
                return root;
            }

            return value >= root.value ? findDadNodeInTree(value, root.right) : findDadNodeInTree(value, root.left);
        }
    }

    public static int CountChildren(Node node){
        if(isNull(node)){
            return -1;
        } else if(isLeaf(node)){
            return 0;
        } else if(isNull(node.left) || isNull(node.right)){
            return 1;
        } else{
            return 2;
        }

    }


    /**
     * @param node nó recebido que vamos avaliar para retorno do filho não vazio
     * @return retorna a referência do nó que não está vazio, contanto que o outro esteja vazio, retorna null se for uma folha ou um ramo completo
     */
    public static Node retChildNotNull(Node node){
        if(isLeaf(node)){
            return null;
        } else if( isNull(node.left)){
            return node.right;
        } else if ( isNull(node.right)){
            return node.left;
        } else{
            return null;

        }
    }



}
