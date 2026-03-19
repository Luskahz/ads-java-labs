package br.edu.ifsp.ads.dataArchitecture.sortFunctions;

import java.util.function.BiConsumer;

public class main {


    public static void runner(String nomeAlgoritmo,
                              String tamanhoVetor,
                              String tipoVet,
                              BiConsumer<int[], Integer> sortFunction,
                              int[] vet) {

        long inicio = System.nanoTime();

        sortFunction.accept(vet, vet.length);

        long fim = System.nanoTime();
        long tempoNs = fim - inicio;

        double tempoMs = tempoNs / 1_000_000.0;

        System.out.printf(
                "%s;%s;%s;%.4f%n",
                nomeAlgoritmo,
                tipoVet,
                tamanhoVetor,
                tempoMs
        );
    }


    public static void main(String[] args) {
        int n = 5;
        System.out.println("nome_algoritmo, tipo_vetor, tamanho_vetor, tempo_ms");

        Initializer initializer = new Initializer(n); // aqui eu crio a base que vou testar, meu teste vai rodar 4 vezes, pra n pesar na maquina, eu só mudo o numero no parametro pra testar com o tamanho diferente
        runner("Bubble sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::bubbleSort, initializer.getAleatorio());
        runner("Bubble sort", String.valueOf(n)+ " mil", "Melhor", Facts::bubbleSort, initializer.getMelhor());
        runner("Bubble sort", String.valueOf(n)+ " mil", "Pior", Facts::bubbleSort, initializer.getPior());

        runner("Selection sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::selectionSort, initializer.getAleatorio());
        runner("Selection sort", String.valueOf(n)+ " mil", "Melhor", Facts::selectionSort, initializer.getMelhor());
        runner("Selection sort", String.valueOf(n)+ " mil", "Pior", Facts::selectionSort, initializer.getPior());

        runner("Insertion sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::insertionSort, initializer.getAleatorio());
        runner("Insertion sort", String.valueOf(n)+ " mil", "Melhor", Facts::insertionSort, initializer.getMelhor());
        runner("Insertion sort", String.valueOf(n)+ " mil", "Pior", Facts::insertionSort, initializer.getPior());

        runner("Merge sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::mergeSort, initializer.getAleatorio());
        runner("Merge sort", String.valueOf(n)+ " mil", "Melhor", Facts::mergeSort, initializer.getMelhor());
        runner("Merge sort", String.valueOf(n)+ " mil", "Pior", Facts::mergeSort, initializer.getPior());

        runner("Heap sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::heapSort, initializer.getAleatorio());
        runner("Heap sort", String.valueOf(n)+ " mil", "Melhor", Facts::heapSort, initializer.getMelhor());
        runner("Heap sort", String.valueOf(n)+ " mil", "Pior", Facts::heapSort, initializer.getPior());

        runner("Counting sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::countingSort, initializer.getAleatorio());
        runner("Counting sort", String.valueOf(n)+ " mil", "Melhor", Facts::countingSort, initializer.getMelhor());
        runner("Counting sort", String.valueOf(n)+ " mil", "Pior", Facts::countingSort, initializer.getPior());

        runner("Quick sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::quickSort, initializer.getAleatorio());
        runner("Quick sort", String.valueOf(n)+ " mil", "Melhor", Facts::quickSort, initializer.getMelhor());
        runner("Quick sort", String.valueOf(n)+ " mil", "Pior", Facts::quickSort, initializer.getPior());

        n = 10;
        initializer = new Initializer(n);
        runner("Bubble sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::bubbleSort, initializer.getAleatorio());
        runner("Bubble sort", String.valueOf(n)+ " mil", "Melhor", Facts::bubbleSort, initializer.getMelhor());
        runner("Bubble sort", String.valueOf(n)+ " mil", "Pior", Facts::bubbleSort, initializer.getPior());

        runner("Selection sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::selectionSort, initializer.getAleatorio());
        runner("Selection sort", String.valueOf(n)+ " mil", "Melhor", Facts::selectionSort, initializer.getMelhor());
        runner("Selection sort", String.valueOf(n)+ " mil", "Pior", Facts::selectionSort, initializer.getPior());

        runner("Insertion sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::insertionSort, initializer.getAleatorio());
        runner("Insertion sort", String.valueOf(n)+ " mil", "Melhor", Facts::insertionSort, initializer.getMelhor());
        runner("Insertion sort", String.valueOf(n)+ " mil", "Pior", Facts::insertionSort, initializer.getPior());

        runner("Merge sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::mergeSort, initializer.getAleatorio());
        runner("Merge sort", String.valueOf(n)+ " mil", "Melhor", Facts::mergeSort, initializer.getMelhor());
        runner("Merge sort", String.valueOf(n)+ " mil", "Pior", Facts::mergeSort, initializer.getPior());

        runner("Heap sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::heapSort, initializer.getAleatorio());
        runner("Heap sort", String.valueOf(n)+ " mil", "Melhor", Facts::heapSort, initializer.getMelhor());
        runner("Heap sort", String.valueOf(n)+ " mil", "Pior", Facts::heapSort, initializer.getPior());

        runner("Counting sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::countingSort, initializer.getAleatorio());
        runner("Counting sort", String.valueOf(n)+ " mil", "Melhor", Facts::countingSort, initializer.getMelhor());
        runner("Counting sort", String.valueOf(n)+ " mil", "Pior", Facts::countingSort, initializer.getPior());

        runner("Quick sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::quickSort, initializer.getAleatorio());
        runner("Quick sort", String.valueOf(n)+ " mil", "Melhor", Facts::quickSort, initializer.getMelhor());
        runner("Quick sort", String.valueOf(n)+ " mil", "Pior", Facts::quickSort, initializer.getPior());

        n = 30;
        initializer = new Initializer(n);
        runner("Bubble sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::bubbleSort, initializer.getAleatorio());
        runner("Bubble sort", String.valueOf(n)+ " mil", "Melhor", Facts::bubbleSort, initializer.getMelhor());
        runner("Bubble sort", String.valueOf(n)+ " mil", "Pior", Facts::bubbleSort, initializer.getPior());

        runner("Selection sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::selectionSort, initializer.getAleatorio());
        runner("Selection sort", String.valueOf(n)+ " mil", "Melhor", Facts::selectionSort, initializer.getMelhor());
        runner("Selection sort", String.valueOf(n)+ " mil", "Pior", Facts::selectionSort, initializer.getPior());

        runner("Insertion sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::insertionSort, initializer.getAleatorio());
        runner("Insertion sort", String.valueOf(n)+ " mil", "Melhor", Facts::insertionSort, initializer.getMelhor());
        runner("Insertion sort", String.valueOf(n)+ " mil", "Pior", Facts::insertionSort, initializer.getPior());

        runner("Merge sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::mergeSort, initializer.getAleatorio());
        runner("Merge sort", String.valueOf(n)+ " mil", "Melhor", Facts::mergeSort, initializer.getMelhor());
        runner("Merge sort", String.valueOf(n)+ " mil", "Pior", Facts::mergeSort, initializer.getPior());

        runner("Heap sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::heapSort, initializer.getAleatorio());
        runner("Heap sort", String.valueOf(n)+ " mil", "Melhor", Facts::heapSort, initializer.getMelhor());
        runner("Heap sort", String.valueOf(n)+ " mil", "Pior", Facts::heapSort, initializer.getPior());

        runner("Counting sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::countingSort, initializer.getAleatorio());
        runner("Counting sort", String.valueOf(n)+ " mil", "Melhor", Facts::countingSort, initializer.getMelhor());
        runner("Counting sort", String.valueOf(n)+ " mil", "Pior", Facts::countingSort, initializer.getPior());

        runner("Quick sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::quickSort, initializer.getAleatorio());
        runner("Quick sort", String.valueOf(n)+ " mil", "Melhor", Facts::quickSort, initializer.getMelhor());
        runner("Quick sort", String.valueOf(n)+ " mil", "Pior", Facts::quickSort, initializer.getPior());

        n = 50;
        initializer = new Initializer(n);
        runner("Bubble sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::bubbleSort, initializer.getAleatorio());
        runner("Bubble sort", String.valueOf(n)+ " mil", "Melhor", Facts::bubbleSort, initializer.getMelhor());
        runner("Bubble sort", String.valueOf(n)+ " mil", "Pior", Facts::bubbleSort, initializer.getPior());

        runner("Selection sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::selectionSort, initializer.getAleatorio());
        runner("Selection sort", String.valueOf(n)+ " mil", "Melhor", Facts::selectionSort, initializer.getMelhor());
        runner("Selection sort", String.valueOf(n)+ " mil", "Pior", Facts::selectionSort, initializer.getPior());

        runner("Insertion sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::insertionSort, initializer.getAleatorio());
        runner("Insertion sort", String.valueOf(n)+ " mil", "Melhor", Facts::insertionSort, initializer.getMelhor());
        runner("Insertion sort", String.valueOf(n)+ " mil", "Pior", Facts::insertionSort, initializer.getPior());

        runner("Merge sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::mergeSort, initializer.getAleatorio());
        runner("Merge sort", String.valueOf(n)+ " mil", "Melhor", Facts::mergeSort, initializer.getMelhor());
        runner("Merge sort", String.valueOf(n)+ " mil", "Pior", Facts::mergeSort, initializer.getPior());

        runner("Heap sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::heapSort, initializer.getAleatorio());
        runner("Heap sort", String.valueOf(n)+ " mil", "Melhor", Facts::heapSort, initializer.getMelhor());
        runner("Heap sort", String.valueOf(n)+ " mil", "Pior", Facts::heapSort, initializer.getPior());

        runner("Counting sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::countingSort, initializer.getAleatorio());
        runner("Counting sort", String.valueOf(n)+ " mil", "Melhor", Facts::countingSort, initializer.getMelhor());
        runner("Counting sort", String.valueOf(n)+ " mil", "Pior", Facts::countingSort, initializer.getPior());

        runner("Quick sort", String.valueOf(n)+ " mil", "Aleatorio", Facts::quickSort, initializer.getAleatorio());
        runner("Quick sort", String.valueOf(n)+ " mil", "Melhor", Facts::quickSort, initializer.getMelhor());
        runner("Quick sort", String.valueOf(n)+ " mil", "Pior", Facts::quickSort, initializer.getPior());



    }

}