package br.edu.ifsp.ads.dataArchitecture.bin2.revisao;

import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.model.Node;
import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.utils.Utils;


public class Main {
    public static Node root;

    public static void main(String[] args) {
        test("remover folha esquerda", new int[]{50, 30, 70, 20, 40}, 20, "30 40 50 70");

        test("remover folha direita", new int[]{50, 30, 70, 20, 40}, 40, "20 30 50 70");

        test("remover nó com 1 filho à esquerda", new int[]{50, 30, 70, 20}, 30, "20 50 70");

        test("remover nó com 1 filho à direita", new int[]{50, 30, 70, 40}, 30, "40 50 70");

        test("remover nó com 2 filhos - sucessor direto",
                new int[]{50, 30, 70, 20, 40},
                30,
                "20 40 50 70");

        test("remover nó com 2 filhos - sucessor profundo com filho direito",
                new int[]{50, 70, 30, 40, 20, 31, 32},
                30,
                "20 31 32 40 50 70");

        test("remover nó inexistente",
                new int[]{50, 30, 70},
                99,
                "30 50 70");

        test("remover raiz folha",
                new int[]{50},
                50,
                "");

        test("remover raiz com 1 filho à esquerda",
                new int[]{50, 30},
                50,
                "30");

        test("remover raiz com 1 filho à direita",
                new int[]{50, 70},
                50,
                "70");

        test("remover raiz com 2 filhos",
                new int[]{50, 30, 70, 20, 40, 60, 80},
                50,
                "20 30 40 60 70 80");
    }

    private static void test(String nome, int[] numeros, int remover, String esperadoInOrder) {
        Node root = null;

        for (int numero : numeros) {
            root = RemovalMethods.insertUnique(root, numero);
        }

        System.out.println("\n==============================");
        System.out.println("TESTE: " + nome);
        System.out.println("REMOVER: " + remover);

        System.out.println("\nANTES:");
        Utils.exibeArvore(root);

        root = RemovalMethods.remove(root, remover);

        System.out.println("\nDEPOIS:");
        Utils.exibeArvore(root);

        System.out.println("\nESPERADO IN-ORDER:");
        System.out.println(esperadoInOrder);
    }

}
