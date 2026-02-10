package br.edu.ifsp.ads.dataArchitecture;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Labs gamificador = new Labs(new Facts(), scanner);

        gamificador.Ex2();

        

    }
}
