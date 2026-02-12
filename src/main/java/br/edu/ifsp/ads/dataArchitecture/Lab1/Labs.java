package br.edu.ifsp.ads.dataArchitecture.Lab1;

import java.util.Scanner;

public class Labs {
    private Facts facts;
    private final Scanner entrada;

    public Labs(Facts ex1, Scanner scanner) {
        this.facts = ex1;
        this.entrada = scanner;
    }

    public void Ex1(){
        System.out.printf("insira um numero para criar um novo vetor: ");
        int n = entrada.nextInt();
        facts.create(n);
        for(int i = 0; i< facts.getVetor().length; i++ ){
            System.out.println("insira o valor do indice: " + i + " do vetor");
            int valor = entrada.nextInt();
            facts.adicionar(valor);
        }
        System.out.printf("Array ordenado: ");
        System.out.println(facts.toString());;
        System.out.printf("Array ao contrario: ");
        System.out.println(facts.vetorToString(facts.invertido(facts.getVetor())));
    }

    public void Ex2(){
        System.out.println("insira o valor de N para o tamanho do novo vetor");
        int n = entrada.nextInt();
        System.out.println("insira o valor de M, numeros aleatorios serão adcionados ao vetor de 0 a M");
        int m = entrada.nextInt();
        int[] novoVetorAleatorio = facts.popularVetorComNumerosAleatorios(n, m);
        System.out.println("Vetor aleatorio");
        System.out.printf(facts.toString());
    }

    public void Ex3(){
        System.out.printf("insira o tamanho do vetor: ");
        int n = entrada.nextInt();
        facts.create(n);
        System.out.println("Segue o vetor com os numeros aleatorios: ");
        facts.insere_exclusivo(facts.getVetor(), n);
        System.out.println(facts.toString());

    }


}
