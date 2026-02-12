package br.edu.ifsp.ads.dataArchitecture.recursiveFunctions;


//Modifique o exibeRec de forma que ele opere somente com um parâmetro



import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Facts facts = new Facts();
        Labs labs = new Labs(scanner, facts);


        labs.Ex8();



    }
}
