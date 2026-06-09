package br.edu.ifsp.ads.dataArchitecture.bin2.revisao;

import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.model.Node;
import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.utils.Utils;


public class Main {
    public static Node root;

    public static void main(String[] args) {
        int[] numeros = {
                50, 30, 70, 20, 40, 60, 80
        };
        for(int numero : numeros){
            root = BasicMethods.insert(root, numero);

        }
        Utils.exibeArvore(root);
        RotateMethods.printBalanceFactorPerNodeInTree(root);
    }
}
