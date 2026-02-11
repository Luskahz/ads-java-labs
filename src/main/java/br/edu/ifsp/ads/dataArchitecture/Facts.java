package br.edu.ifsp.ads.dataArchitecture;

// requisitos
//Crie um programa em que solicita ao usuário o valor de N e, posteriormente os N números que devem ser armazenados
// em um vetor. Em um segundo momento, exiba o vetor na ordem em que os elementos foram digitados e em ordem inversa. (feito)

//Crie um programa em JAVA que solicita ao usuário o valor de N e, posteriormente, alimente o vetor com valores
//aleatórios entre 0 e M (M também é informado pelo usuário). Exiba o vetor gerado.(feito)

//Crie um método chamado Insere_Exclusivo(int vet[], int N) que alimenta um vetor de N elementos com valores aleatórios
//entre 1 e N sem que ocorram números repetidos. Exiba o vetor gerado.

//Crie um programa em JAVA que faça a leitura de um arquivo de texto contendo um número inteiro em cada linha onde:
// O número da primeira linha é o valor de N e os números subsequentes são a sequência numérica de interesse. Armazene
// os valores lidos em um vetor e exiba-o. Aproveite sua implementação do Exercício 1. e escreva em outro arquivo a sequência
// numérica em ordem inversa.


import java.util.Random;

public class Facts {
    private int[] vetor;
    private int tamanho = 0;

    public void create(int n) {
        this.vetor = new int[n];
    }
    public int[] getVetor(){
        return vetor;
    }


    public String toString(){
        String vetor = "";
        for(int i = 0; i<this.vetor.length; i++){
            vetor += this.vetor[i];
        }
        return vetor;
    }
    public String vetorToString(int[] vetor){
        String newVetor = "";
        for(int i = 0; i < vetor.length; i++){
            newVetor += vetor[i];
        }
        return newVetor;
    }

    public void adicionar(int n) {
        if (tamanho >= vetor.length) {
            throw new IllegalStateException("Vetor cheio");
        }
        vetor[tamanho] = n;
        tamanho++;
    }

    public int validVectorLotation(int[] vec){
        int tamanho = 0;
        for(int i = 0; i < vec.length; i++){
            if(vec[i] == 0){
                tamanho++;
            }
        }
        return tamanho;
    }
    public void adicionarInVector(int[] vec, int n) {
        tamanho = validVectorLotation(vec);
        if (tamanho >= vetor.length) {
            throw new IllegalStateException("Vetor cheio");
        }
        vetor[tamanho] = n;
    }

    public int[] reverter(int[] vetor){
        int i = 0;
        int j = vetor.length - 1;

        while(i<j){
            int temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
            i++;
            j--;
        }

        return vetor;
    }

    public int[] invertido(int [] vetor) {
        if (vetor == null) throw new IllegalArgumentException("vetor nulo");

        int[] novo = vetor.clone();
        reverter(novo);
        return novo;
    }


    private int[] redefinir(int n){
        this.vetor = new int[n];
        return this.vetor;
    }

    public int generateRandomNumber(int m){
        Random r = new Random();
        return r.nextInt(m);
    }


    public int[] popularVetorComNumerosAleatorios(int n, int m){
        int[] novo = redefinir(n);

        for(int i = 0; i< novo.length; i++){
            int number = generateRandomNumber(m);
            novo[i] = number;
        }
        return novo;


    }

    private boolean isNumberInVector(int[] vet, int n){
        for(int i = 0; i< vet.length; i++){
            if(vet[i] == n){
                return true;
            }
        }
        return false;
    }

    public void insere_exclusivo(int vet[], int n){
        for(int i = 0; i< vet.length; i++){
            int number = 0;
            while(number == 0){
                number = generateRandomNumber(n);
            }
            if(!isNumberInVector(vet, number)){
                adicionarInVector(vet, number);
            }
        }
    }


}
