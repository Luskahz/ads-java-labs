package br.edu.ifsp.ads.dataArchitecture.bin1.Lab1;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Labs gamificador = new Labs(new Facts(), scanner);

        gamificador.Ex3();

        

    }
}
