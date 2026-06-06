package br.edu.ifsp.ads.dataArchitecture.bin2.revisao.metodosBasicos;

import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.metodosBasicos.model.Node;
import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.metodosBasicos.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static Node root;

    public static void main(String[] args) {
        int[] numeros = {10, 5, 7, 15, 14};
        for(int numero : numeros){
            root = insert(root, numero);

        }
        Utils.exibeArvore(root);

        show(root);

        System.out.println(biggest(root));
    }

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

    public static void show(Node node){
        if(!Utils.isNull(node)){
            show(node.left);
            show(node.right);
            System.out.println(node.value);
        }
    }

    public static int biggest(Node node){
        if(!Utils.isNull(node.right)){
            biggest(node.right);
        }
          return node.value;
    }


}
