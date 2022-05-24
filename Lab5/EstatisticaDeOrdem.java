package Lab5;

import java.util.Scanner;

class EstatisticaDeOrdem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] sequenciaNumeros = sc.nextLine().split(" ");

        String pivot = sequenciaNumeros[0];
        int j = 0;
        boolean trocou = false;

        for (int i = 1; i < sequenciaNumeros.length; i++){
            if (Integer.parseInt(sequenciaNumeros[i]) <= Integer.parseInt(pivot)) {
                j++;
                troca(sequenciaNumeros, i, j);
                trocou= true;
            }
        }

        if(trocou) {
            troca(sequenciaNumeros, 0, j);
        }
        System.out.println(j+1);
    }
    private static void troca(String[] sequenciaNumeros, int i, int j) {
        String temp = sequenciaNumeros[i];
        sequenciaNumeros[i] = sequenciaNumeros[j];
        sequenciaNumeros[j] = temp;
    }
}