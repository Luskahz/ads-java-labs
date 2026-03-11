package br.edu.ifsp.ads.dataArchitecture.recursiveFunctions;

import java.util.Scanner;

public class Labs {
    private Scanner entrada;
    private Facts facts;

    public Labs(Scanner entrada, Facts facts) {
        this.entrada = entrada;
        this.facts = facts;
    }




    public void Ex1(){

        System.out.printf("Insira o valor de N: ");
        int n = entrada.nextInt();
        facts.exibeRec(n);

    }

    public void Ex2(){
        System.out.printf("Insira o valor de X: ");
        int x = entrada.nextInt();
        int fatorial = facts.fatorial(x);
        System.out.println("O Fatorial de "+ x + " é: "+ fatorial);
    }

    public void Ex3(){
        System.out.println("Calculo potenciação");
        System.out.println("insira o valor da base: ");
        int x = entrada.nextInt();
        System.out.println("insira o valor da potência");
        int n = entrada.nextInt();
        int result = facts.pot(x, n);
        System.out.println("O resultado da potencia de "+ x + "elevado a "+ n + " é: " + result);
    }
    public void Ex4(){
        int[] vet = {1, 1, 1, 1, 10};
        int result = facts.sumValuesFromVet(vet,0);
        System.out.println("A soma dos valores: " + result);

    }

    public void Ex5(){
        int[] vet = {1, 1, 5, 1, 1};
        int result = facts.findSmallerValueFromVet(vet, 0);
        System.out.println("o menor valor do vetor é: " + result);
    }

    public void Ex6(){
        int n = 123456;
        int result = facts.contDigitsFromNumber(n);
        System.out.println("o numero possuí: " + result+ " digitos");
    }
    public void Ex7(){
        String txt = "Lucas";
        String result = facts.revertCharFromString(txt);
        System.out.println("Texto invertido: " + result);
    }
    public void Ex8(){
        int n = 23;
        System.out.println("numero edcimal convertido a binario: ");
        facts.convertDecToBin(n);

    }

}
