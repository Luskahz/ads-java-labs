package br.edu.ifsp.ads.dataArchitecture.bin1.sortFunctions;

public class Initializer {
    private int[] aleatorio;
    private int[] melhor;
    private int[] pior;

    public Initializer(int tamanhoMil) {

        int N = tamanhoMil * 1000;

        aleatorio = new int[N];
        melhor = new int[N];
        pior = new int[N];

        Facts.inicializarVetor(aleatorio, N, 0);
        Facts.inicializarVetor(melhor, N, 1);
        Facts.inicializarVetor(pior, N, 2);
    }

    public int[] getAleatorio() {
        return aleatorio.clone();
    }

    public int[] getMelhor() {
        return melhor.clone();
    }

    public int[] getPior() {
        return pior.clone();
    }

}
