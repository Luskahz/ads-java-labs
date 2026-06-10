package br.edu.ifsp.ads.dataArchitecture.bin2.revisao;


import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.model.Node;
import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.utils.Utils;

public class RotateMethods {
    public static void printBalanceFactorPerNodeInTree(Node node){
        if(!Utils.isNull(node)){
            printBalanceFactorPerNodeInTree(node.left);
            System.out.println("o fator de balanceamento do nó "+ node.value + ": "+balanceFactor(node));
            printBalanceFactorPerNodeInTree(node.right);
        }

    }

    public static boolean treeIsAVL(Node root){
        if(Utils.isNull(root)){
            return true;
        }
        return nodeIsAVL(root)
                && treeIsAVL(root.left)
                && treeIsAVL(root.right);
    }

    public static Node rotate(Node node, int direction) {
        return switch (direction) {
            case -1 -> rotateLeft(node);
            case 1 -> rotateRight(node);
            default -> throw new IllegalArgumentException(
                    "Direction must be -1 (left) or 1 (right)"
            );
        };
    }


    public static Node TurnNodeAVL(Node node){
        if(!Utils.isNull(node)){
            node.left = TurnNodeAVL(node.left);
            if(!nodeIsAVL(node)){ // se tiver balanciado, sigo;
                if (Utils.isPositive(balanceFactor(node))) {

                    if (Utils.isPositive(balanceFactor(node.left))){
                        node = rotate(node, 1);
                    } else {
                        node.left = rotate(node.left, -1);
                        node = rotate(node, 1);
                    }
                } else{
                    if (!Utils.isPositive(balanceFactor(node.right))){
                        node = rotate(node, 1);
                    } else {
                        node.right = rotate(node.right, -1);
                        node = rotate(node, 1);
                    }
                }

            }
            node.right = TurnNodeAVL(node.right);
        }
        return node;
    }



    /**
     * @param node nó cujo quero descobrir o fator de balanceamento
     * @return retorna o fator de balanceamento do ramo;
     */
    public static int balanceFactor(Node node){
        int left = BasicMethods.maxDepth(node.left);
        int right = BasicMethods.maxDepth(node.right);

        return Math.subtractExact(left, right);
    }

    public static boolean nodeIsAVL(Node node){
        return Utils.balanceFactorIsAVL(balanceFactor(node));
    }

    public static Node rotateRight(Node node){
        Node y = node.left; //Seja Y o filho à esquerda de X
        node.left = y.right; // Torne o filho à direita de Y o filho à esquerda de X.
        y.right = node; // Torne X o filho à direita de Y
        return y;
    }

    public static Node rotateLeft(Node node){
        Node y = node.right; //Seja Y o filho à direita de X
        node.right = y.left; // Torne o filho à esquerda de Y o filho à direita de X.
        y.left = node; // Torne X o filho à esquerda de Y
        return y;
    }




//    public static Node turnAVL(Node node) {
//        if (Utils.isNull(node)) {
//            return null;
//        }
//
//        node.left = turnAVL(node.left);
//        node.right = turnAVL(node.right);
//
//        int fb = balanceFactor(node);
//
//        if (fb > 1) {
//            int fbFilhoEsquerdo = balanceFactor(node.left);
//
//            if (fbFilhoEsquerdo >= 0) {
//                node = rotateRight(node); // caso LL
//            } else {
//                node.left = rotateLeft(node.left); // caso LR
//                node = rotateRight(node);
//            }
//        } else if (fb < -1) {
//            int fbFilhoDireito = balanceFactor(node.right);
//
//            if (fbFilhoDireito <= 0) {
//                node = rotateLeft(node); // caso RR
//            } else {
//                node.right = rotateRight(node.right); // caso RL
//                node = rotateLeft(node);
//            }
//        }
//
//        return node;
//    }
}
