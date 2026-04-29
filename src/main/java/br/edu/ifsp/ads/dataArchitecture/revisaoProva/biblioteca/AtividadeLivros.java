package br.edu.ifsp.ads.dataArchitecture.revisaoProva.biblioteca;

import java.util.Scanner;

public class AtividadeLivros {

    static NoLivro inicio = null;

    public static void main(String[] args) {
        cadastrarLivro("LORENZI, F.; MATTOS, P. N.; CARVALHO, T. P.", " Estruturas de dados", "1ª edição", "São Paulo", "Thomson Learning", 2007);
        cadastrarLivro("PEREIRA, S. L.", "Estrutura de dados fundamentais: conceitos e aplicações", "12ª edição", "São Paulo", "Érica", 2008);
        cadastrarLivro("LAFORE, R.", "Estrutura de dados & algoritmos em java", "1ª edição", "Rio de Janeiro", "Ciência Moderna", 2004);
        cadastrarLivro("SZWARCFITER, J. L.; MARKENZON, L.", "Estruturas de dados e seus algoritmos", "3ª edição", "Rio de Janeiro", "LTC", 2010);
        cadastrarLivro("PREISS, B. R.", "Estruturas de dados e algoritmos: pradrões de projetos orientados a objeto com java", "1ª edição", "Rio de Janeiro", "Elsevier", 2000);
        cadastrarLivro("WIRTH, N.", "Algoritmos e estruturas de dados", "1ª edição", "Rio de Janeiro", "LTC", 2008);
        cadastrarLivro("CELES, W. ; CERQUEIRA, R.; RANGEL, J. L.", "Introdução a estruturas de dados com técnicas de programação em C", "1ª edição", "Rio de Janeiro", "Elsevier", 2004);
        cadastrarLivro("GUIMARÃES, Â. M.; LAGES, N. A. C.", "Algoritmos e estruturas de dados", "1ª edição", "Rio de Janeiro", "LTC", 2008);


        Scanner teclado = new Scanner(System.in);

        String opcao;
        NoLivro fila = inicio;

        // ATENÇÃO, EXIBA AS INFORMAÇÕES SIMPLES DO PRIMEIRO LIVRO ANTES DE ENTRAR NO MENU
        fila.exibirSimples();
        System.out.println("------------\n");

        do {
            System.out.print("\nINFORME A OPÇÃO DESEJADA\n"
                    + "\"a\" para avançar\n"
                    + "\"r\" para retroceder\n"
                    + "\"d\" para detalhar\n"
                    + "\"s\" para sair\n"
                    + "ESCOLHA:");

            opcao = teclado.nextLine();

            if (opcao.equals("a")) {
                System.out.println("\nLIVRO ATUAL");
                fila = fila.proximo;
                fila.exibirSimples();
            } else if (opcao.equals("r")) {
                System.out.println("\nLIVRO ATUAL");
                fila = fila.anterior;
                fila.exibirSimples();
            } else if (opcao.equals("d")) {
                System.out.println("\nLIVRO ATUAL DETALHADO");
                fila.exibirEspecifico();
            }


        } while (!opcao.equals("s"));

    }

    public static void cadastrarLivro(String autores, String titulo, String edicao, String cidade, String editora, int ano) {
        NoLivro no = new NoLivro(autores, titulo, edicao, cidade, editora, ano);

        if (inicio == null) {
            inicio = no;
            inicio.anterior = no;
            inicio.proximo = no;
        } else if (inicio.proximo == inicio || inicio.anterior == inicio) {
            inicio.proximo = no;
            no.proximo = inicio;
            no.anterior = inicio;
            inicio.anterior = no;
        } else {
            NoLivro tmp = inicio;
            while (tmp.proximo != inicio) {
                tmp = tmp.proximo;
            }
            tmp.proximo = no;
            no.proximo = inicio;
            no.anterior = tmp;
            inicio.anterior = no;
        }

    }
}
