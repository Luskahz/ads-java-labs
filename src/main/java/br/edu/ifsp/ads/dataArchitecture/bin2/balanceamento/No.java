package br.edu.ifsp.ads.dataArchitecture.bin2.balanceamento;

public class No {
    public int value;
    public No left;
    public No right;

    public No(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
