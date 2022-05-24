package Lab4;

import java.util.Arrays;
import java.util.Scanner;

class MoveTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] sequenciaNumeros = sc.nextLine().split(" ");

        insertionSort(sequenciaNumeros);
    }
    private static void insertionSort(String[] sequenciaNumeros) {
        for (int i = 1; i < sequenciaNumeros.length; i++) { 
            
            int a = i;
        
            while (a > 0 && Integer.parseInt(sequenciaNumeros[a]) < Integer.parseInt(sequenciaNumeros[a-1])) {
                String auxiliar = sequenciaNumeros[a];
                sequenciaNumeros[a] = sequenciaNumeros[a-1];
                sequenciaNumeros[a-1] = auxiliar;
                a--;
                System.out.println(Arrays.toString(sequenciaNumeros));
            }
        
        }
    }
}

