package br.edu.ifsp.ads.dataArchitecture.recursiveFunctions;

/**
 * Classe de fatos, traz as funções resultantes das atividades passadas durante a aula de arquitetura de dados, especificamente sobre recursividade
 */
public class Facts {

    /**
     * 1. Função de recursividade, apresenta os numeros de i a 1 utilizando recursividade
     * @param i numero base para a contagem, o loop de recursividade sera aberto i vezes dentro desta função
     */
    public void exibeRec(int i){
        if(i == 1){
            System.out.println(i);
        }else{
            i--;
            System.out.println(i);
            exibeRec(i);
        }
    }


    /**
     * 2. Método recursivo fatorial(x) que retorna o fatorial de x
     * @param x numero qual sera aplicado o calculo de fatorialização
     * @return retorna o calculo do resultado do fatorial de x
     */
    public int fatorial(int x){
        if(x==1){
            return x;
        } else{
            return x * fatorial(x-1);
        }
    }


    /**
     * 3. Função Recursiva int pot(int x, int n) que dados dois números inteiros x e n, calcula o valor resultante da potênciação dos dois numeros
     *
     *
     * @param x base que sera calculada a potencia
     * @param n potência, numero qual multiplicara a base
     * @return retorna o resultado da potênciação usando recursividade
     */
    public int pot(int x, int n){
        if(n == 1){
            return x;
        } else{
            return x * pot(x, n-1);
        }
    }


    /**
     * 4. Função recursiva que retorne a soma dos elementos de um vetor de N inteiros
     *
     * @param vet vetor cujos valores dos indices serão somados
     * @param i indice de controle do vetor, inícia sempre em 0
     * @return valor total adquirido pela soma dos valores dos indices de vet.
     */
    public int sumValuesFromVet(int[]vet, int i){
        if(i == vet.length-1){
            return vet[i];//ultimo indice
        }else{
            return vet[i] + sumValuesFromVet(vet,i+1);
        }
    }

    /**
     * 5. Função recursiva que retorne o menor elemento de um vetor
     *
     * @param vet vetor inserido pelo usuario, o menor valor sera descoberto a partir dos valores deste vetor
     * @param i iterador dos indices do vetor, usado pra manipulação
     * @return menor valor presente no vetor vet
     */
    public int findSmallerValueFromVet(int[] vet, int i){
        if(i == vet.length-1){
            return vet[i];
        }
        int maior = findSmallerValueFromVet(vet, i+1);
        return (vet[i] < maior)? vet[i] : maior;
    }


    /**
     * 6. Função recursiva que conte quantos dígitos tem um número inteiro positivo.
     * @param n numero fornecido pelo usuário, o programa vai contar quantos digitos possuí este numero
     * @return retorna a quantidade de dígitos de n
     */
    public int contDigitsFromNumber(int n){
        if(n < 10) return 1;
        return 1 + contDigitsFromNumber(n/10);

    }


    /**
     * 7. Função recursiva que receba uma string e retorne ela invertida.
     * @param txt string cujo programa vai inverter
     * @return retorna a string invertida
     */
    public String revertCharFromString(String txt){
        if(txt.length() == 1|| txt == null){
            return txt;
        }
        return revertCharFromString(txt.substring(1))+ txt.charAt(0);
    }

    /**
     * converte um numero decimal fornecido pelo usuario em sua versão base binaria
     * @param n valor que sera convertido para binario
     * @return retorna o valor de n em binario
     */
    public void convertDecToBin(int n){
        if(n>0){
            convertDecToBin(n/2);
            System.out.println(n%2);
        } else System.out.println(0);
    }

}
