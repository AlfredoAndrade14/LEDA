package Lab5;

import java.util.Arrays;
import java.util.Scanner;

class ParticionamentoLomuto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] sequenciaNumeros = sc.nextLine().split(" ");
        
        int j = sequenciaNumeros.length - 1;
        String pivot = sequenciaNumeros[sequenciaNumeros.length-1];

        for(int i = sequenciaNumeros.length - 2; i >= 0; i--) {
            if(Integer.parseInt(sequenciaNumeros[i]) >= Integer.parseInt(pivot)) {
                j--;
                troca(sequenciaNumeros, i, j);
                System.out.println(Arrays.toString(sequenciaNumeros));
            }
        }

        troca(sequenciaNumeros, j, sequenciaNumeros.length-1);
        System.out.println(Arrays.toString(sequenciaNumeros));
        System.out.println(Arrays.toString(sequenciaNumeros));
    }

    private static void troca(String[] sequenciaNumeros, int i, int j) {
        String temp = sequenciaNumeros[i];
        sequenciaNumeros[i] = sequenciaNumeros[j];
        sequenciaNumeros[j] = temp;
    }
}