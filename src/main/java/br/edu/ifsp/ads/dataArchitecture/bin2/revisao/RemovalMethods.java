package br.edu.ifsp.ads.dataArchitecture.bin2.revisao;

import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.model.Node;
import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.utils.Utils;

public class RemovalMethods {
    public static Node insertUnique(Node root, int value){

        if(!exists(value, root)){
            root = BasicMethods.insert(root, value);
        }else{
            System.out.println("Valor existe na árvore: "+ value);
        }
        return root;
    }

    public static boolean exists(int value, Node root){
        if(Utils.isNull(root)){
            return false;
        } else{
            if(Utils.isEqual(value, root)){
                return true;
            }
            boolean existsInRight = exists(value, root.right);
            boolean existsInLeft = exists(value, root.left);

            return existsInLeft || existsInRight;
        }

    }

    public static int ContKids( int value , Node root ){
        if(!exists(value, root)){
            return -1;
        }
        Node found = Utils.findNodeByValueInTree(value, root); // trago o nó que vou contar os filhos.

        if(!Utils.isNull(found)){
            return Utils.CountChildren(found);
        } else{
            System.out.println("Não há um nó com este valor na árvore");
            return -1;
        }
    }


    public static void removeLeaf(Node root, int value){
        Node dadFound = Utils.findDadNodeInTree(value, root);
        if(Utils.isNull(dadFound)){
            System.out.println("Pai não encontrado");
        } else{
            if(!Utils.isNull(dadFound.left) && dadFound.left.value == value){
                dadFound.left = null;
            } else{
                dadFound.right = null;
            }
        }

    }

    public static void removeLeaf(Node root, Node node){
        Node dadFound = Utils.findDadNodeInTree(node.value, root);
        if(Utils.isNull(dadFound)){
            System.out.println("Pai não encontrado");
        } else{
            if(!Utils.isNull(dadFound.left) && dadFound.left.value == node.value){
                dadFound.left = null;
            } else{
                dadFound.right = null;
            }
        }

    }
    public static void RemoveOneChild(Node node, int value ){
        if(Utils.isNull(node)) {
            System.out.println("nó vazio");
            return;
        }

        Node dad = Utils.findDadNodeInTree(value, node);

        if(!Utils.isNull(dad.left)){
            if(dad.left.value == value){
                dad.left = Utils.retChildNotNull(dad.left);
            }
        }
        if(!Utils.isNull(dad.right)){
            if(dad.right.value == value){
                dad.right = Utils.retChildNotNull(dad.right);
            }
        }
    }
    public static Node RemoveTwoChildren(Node node, int value) {
        if (Utils.isNull(node)) {
            System.out.println("nó vazio");
            return null;
        }

        Node dad = Utils.findDadNodeInTree(value, node);

        Node removed;

        if (Utils.isNull(dad)) {
            if (node.value != value) {
                System.out.println("Não pode achar o nó pai");
                return node;
            }

            removed = node;
        } else {
            removed = Utils.findChildByValue(dad, value);
        }

        Node successor = Utils.smallestNode(removed.right);
        Node successorDad = Utils.findDadNodeInTree(successor.value, node);

        if (successorDad != removed) {
            if (successorDad.left == successor) {
                successorDad.left = successor.right;
            } else {
                successorDad.right = successor.right;
            }

            successor.right = removed.right;
        }

        successor.left = removed.left;

        if (Utils.isNull(dad)) {
            return successor;
        }

        if (dad.left == removed) {
            dad.left = successor;
        } else {
            dad.right = successor;
        }

        return node;
    }


    public static Node remove(Node root, int value) {
        System.out.println("vamos remover o: " + value);

        if (Utils.isNull(root)) {
            return null;
        }

        if (root.value == value) {
            if (Utils.isNull(root.left) && Utils.isNull(root.right)) {
                root = null;
            } else if (!Utils.isNull(root.left) && !Utils.isNull(root.right)) {
                root = RemoveTwoChildren(root, value);
            } else if (Utils.isNull(root.left)) {
                root = root.right;
            } else {
                root = root.left;
            }
        } else {
            removeNode(root, value);
        }

        return root;
    }

    static void removeNode(Node root, int value){

        int kids = ContKids(value, root);

        switch(kids){
            case -1: System.out.println("O nó não existe na árvore"); break;
            case  0: removeLeaf(root, value); break;
            case  1: RemoveOneChild(root, value); break;
            case  2: RemoveTwoChildren(root, value); break;
        }
    }


}
