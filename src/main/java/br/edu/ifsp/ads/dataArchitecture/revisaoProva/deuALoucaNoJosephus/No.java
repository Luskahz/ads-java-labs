package br.edu.ifsp.ads.dataArchitecture.revisaoProva.deuALoucaNoJosephus;

public class No {
    No ant;
    int valor;
    No prox;

    public No(int valor) {
        this.ant = null;
        this.valor = valor;
        this.prox = null;
    }
}
