package br.edu.ifsp.ads.dataArchitecture.bin1.sortFunctions;

public class Facts {

    static void inicializarVetor(int vet[], int N, int s) {
        switch(s){
            case 0:
                for (int i = 0; i < N; i++)
                    vet[i] = (int) (Math.random() * (N * 2));
                break;
            case 1:
                for (int i = 0; i < N; i++)
                    vet[i] = i+1;
                break;
            case 2:
                for (int i = 0; i < N; i++)
                    vet[i] = N-i;
                break;
        }
    }


    private static void exibirVetor(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            if (vet[i] < 10) {
                System.out.print("0" + vet[i] + " ");
            } else {
                System.out.print(vet[i] + " ");
            }
        }
        System.out.println("");
    }

    // util
    private static void troca(int[] vet, int a, int b) {
        int aux = vet[a];
        vet[a] = vet[b];
        vet[b] = aux;
    }

    // ---------------- BUBBLE ----------------

    public static void bubbleSort(int[] vet, int N) {

        for (int i = 0; i < N - 1; i++) {

            boolean trocou = false;

            for (int j = 0; j < N - 1 - i; j++) {

                if (vet[j] > vet[j + 1]) {
                    troca(vet, j, j + 1);
                    trocou = true;
                }

            }

            if (!trocou) return;
        }
    }

    // ---------------- SELECTION ----------------

    public static void selectionSort(int[] vet, int N) {

        for (int i = 0; i < N - 1; i++) {

            int menor = i;

            for (int j = i + 1; j < N; j++) {
                if (vet[j] < vet[menor]) {
                    menor = j;
                }
            }

            if (menor != i) {
                troca(vet, i, menor);
            }
        }
    }

    // ---------------- INSERTION ----------------

    public static void insertionSort(int[] vet, int N) {

        for (int i = 1; i < N; i++) {

            int chave = vet[i];
            int j = i - 1;

            while (j >= 0 && vet[j] > chave) {
                vet[j + 1] = vet[j];
                j--;
            }

            vet[j + 1] = chave;
        }
    }

    // ---------------- MERGE ----------------

    public static void mergeSort(int[] vet, int N) {
        mergeSortRec(vet, 0, N - 1);
    }

    private static void mergeSortRec(int[] vet, int inicio, int fim) {

        if (inicio >= fim) return;

        int meio = (inicio + fim) / 2;

        mergeSortRec(vet, inicio, meio);
        mergeSortRec(vet, meio + 1, fim);

        merge(vet, inicio, meio, fim);
    }

    private static void merge(int[] vet, int inicio, int meio, int fim) {

        int[] temp = new int[fim - inicio + 1];

        int i = inicio;
        int j = meio + 1;
        int k = 0;

        while (i <= meio && j <= fim) {

            if (vet[i] <= vet[j]) {
                temp[k++] = vet[i++];
            } else {
                temp[k++] = vet[j++];
            }

        }

        while (i <= meio) temp[k++] = vet[i++];
        while (j <= fim) temp[k++] = vet[j++];

        for (i = inicio, k = 0; i <= fim; i++, k++) {
            vet[i] = temp[k];
        }
    }

    // ---------------- HEAP ----------------

    public static void heapSort(int[] vet, int N) {

        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(vet, N, i);
        }

        for (int i = N - 1; i > 0; i--) {

            troca(vet, 0, i);

            heapify(vet, i, 0);
        }
    }

    private static void heapify(int[] vet, int N, int i) {

        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < N && vet[esq] > vet[maior]) {
            maior = esq;
        }

        if (dir < N && vet[dir] > vet[maior]) {
            maior = dir;
        }

        if (maior != i) {
            troca(vet, i, maior);
            heapify(vet, N, maior);
        }
    }

    // ---------------- COUNTING ----------------

    public static void countingSort(int[] vet, int N) {

        int max = vet[0];

        for (int i = 1; i < N; i++) {
            if (vet[i] > max) max = vet[i];
        }

        int[] cont = new int[max + 1];

        for (int i = 0; i < N; i++) {
            cont[vet[i]]++;
        }

        int index = 0;

        for (int i = 0; i < cont.length; i++) {
            while (cont[i] > 0) {
                vet[index++] = i;
                cont[i]--;
            }
        }
    }

    // ---------------- QUICK ----------------

    public static void quickSort(int[] vet, int N) {
        quickSortRec(vet, 0, N);
    }

    private static void quickSortRec(int[] vet, int ini, int fim) {

        if (ini < fim) {

            int pp = particao(vet, ini, fim);

            quickSortRec(vet, ini, pp);
            quickSortRec(vet, pp + 1, fim);
        }
    }

    private static int particao(int[] vet, int ini, int fim) {

        int pivoIndex = ini + (int)(Math.random() * (fim - ini));
        troca(vet, pivoIndex, fim - 1);

        int pivo = vet[fim - 1];

        int i = ini;

        for (int j = ini; j < fim - 1; j++) {

            if (vet[j] <= pivo) {
                troca(vet, i, j);
                i++;
            }

        }

        troca(vet, i, fim - 1);

        return i;
    }// tive que mudar a partição, se n ia estorar a jvm kkkkkkk
}