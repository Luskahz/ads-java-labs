package br.edu.ifsp.ads.dataArchitecture.bin1.atividadesPreProva.deuALoucaNoJosephus;

public class No {
    int valor;
    No prox;
    No ant;

    public No(int valor) {
        this.valor = valor;
        this.prox = null;
        this.ant = null;
    }
}
