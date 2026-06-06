package br.edu.ifsp.ads.dataArchitecture.bin2.revisao.metodosBasicos.model;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
