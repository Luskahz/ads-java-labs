package br.edu.ifsp.ads.dataArchitecture.bin2.revisao;

import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.model.Node;
import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.utils.Utils;

public class BasicMethods {
    public static Node insert(Node root, int value){
        if(Utils.isNull(root)) {
            return Utils.createNodeLeaf(value);
        }
        if(value >= root.value ){
            root.right = insert(root.right, value);
        } else{
            root.left = insert(root.left, value);
        }
        return root;
    }
    public static int biggest(Node node){
        if(!Utils.isNull(node.right)){
            return biggest(node.right);
        }
        return node.value;
    }

    public static int smallest(Node node){
        if(!Utils.isNull(node.left)){
            return smallest(node.left);
        }
        return node.value;
    }
    public static void showLeafsAsc(Node node){
        if(!Utils.isNull(node)){
            showLeafsAsc(node.left);
            showLeafsAsc(node.right);
            if(Utils.isLeaf(node)) Utils.soutValue(node);
        }
    }
    public static void showLeafsDesc(Node node){
        if(!Utils.isNull(node)){
            if(Utils.isLeaf(node)) Utils.soutValue(node);
            showLeafsDesc(node.right);
            showLeafsDesc(node.left);
        }
    }
    public static int maxDepth(Node node){
        if(Utils.isNull(node)){
            return -1;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        return Math.max(leftDepth, rightDepth)+1;
    }
    public static void show(Node node){
        if(!Utils.isNull(node)){
            Utils.soutValue(node);
            show(node.right);
            show(node.left);
        }
    }
    public static int maxSize(Node node){
        if(Utils.isNull(node)){
            return 0;
        }
        int leftSize = maxSize(node.left);
        int rightSize = maxSize(node.right);

        return 1 + leftSize + rightSize;

    }
}
