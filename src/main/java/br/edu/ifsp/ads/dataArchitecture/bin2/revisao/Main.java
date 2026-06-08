package br.edu.ifsp.ads.dataArchitecture.bin2.revisao;

import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.model.Node;
import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.utils.Utils;


public class Main {
    public static Node root;

    public static void main(String[] args) {
        int[] numeros = {
                50, 70, 30, 40, 20, 31, 32
        };
        for(int numero : numeros){
            root = RemovalMethods.insertUnique(root, numero);
        }

        Utils.exibeArvore(root);
        RemovalMethods.remove(root, 30);
        Utils.exibeArvore(root);

    }

}
