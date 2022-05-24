package Lab3;

import java.util.Scanner;

import javax.naming.directory.InitialDirContext;

class BuscaBinariaRecursiva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] sequenciaNumeros = sc.nextLine().split(" ");
        int numBuscado = sc.nextInt();

        System.out.println(buscaBinaria(sequenciaNumeros, numBuscado, 0, sequenciaNumeros.length-1));
    }

    public static int buscaBinaria(String[] sequencia, int numBuscado, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            if (Integer.parseInt(sequencia[meio]) == numBuscado) {
                return meio;
            }

            System.out.println(meio);
            if (numBuscado < Integer.parseInt(sequencia[meio])){
                return buscaBinaria(sequencia, numBuscado, inicio, meio - 1);
            } 
            else { 
                return buscaBinaria(sequencia, numBuscado, meio + 1, fim);
            }
        }
        else {
            if(Integer.parseInt(sequencia[inicio]) == numBuscado) {return inicio;}
            System.out.println(inicio);
            return -1;
        }
    }
}
