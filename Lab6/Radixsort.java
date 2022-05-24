package Lab6;

import java.util.Arrays;
import java.util.Scanner;

class Radixsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] numerosStr = sc.nextLine().split(" ");
        String quantidadeDigitos = sc.nextLine();
        int [] sequenciaNumeros = new int[numerosStr.length];
        
        for(int i = 0; i < numerosStr.length; i++) {
            sequenciaNumeros[i] = Integer.parseInt(numerosStr[i]);
        }

        for(int i = 2; i <= Integer.parseInt(quantidadeDigitos); i += 2){
            sequenciaNumeros = radixSort(sequenciaNumeros,i);
            System.out.println(Arrays.toString(sequenciaNumeros));
        }

    }
    public static int[] radixSort(int[] nums,int digitos) {
        int maior = 0;
        for(int m = 0; m < nums.length; m++) {
            int numero = (int) (nums[m] % Math.pow(10, digitos));
            numero = (int) (numero / Math.pow(10, digitos - 2));
            if(numero >= maior) maior = numero;
        }

        int[] c = new int[maior];
        int[] ordenado = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
			int numero = (int) (nums[i] % Math.pow(10, digitos));
            numero = (int) (numero / Math.pow(10, digitos - 2));
			c[numero - 1] += 1;
		}

        for (int j = 1; j < c.length; j++){
            c[j] += c[j-1];
        }

        for (int k = nums.length - 1; k >=0; k--) {
			int numero = (int) (nums[k] % Math.pow(10, digitos));
			numero = (int) (numero / Math.pow(10, digitos - 2));
			
			ordenado[c[numero - 1] - 1] = nums[k];
			c[numero - 1] -= 1;	
		}

        return ordenado;
    }
}