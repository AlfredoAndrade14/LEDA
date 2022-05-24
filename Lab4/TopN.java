package Lab4;

import java.util.Scanner;

class TopN {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        
    String[] sequenciaNumeros = sc.nextLine().split(" ");
    int quantidadeDeNumeros = sc.nextInt();

    insertionSort(sequenciaNumeros);
    String saida = "";
    for (int i = 0; i < quantidadeDeNumeros; i++) {
        saida += sequenciaNumeros[i] + " ";
    }
    System.out.println(saida.trim());
  }

  private static void insertionSort(String[] sequenciaNumeros) {
    for (int i = 1; i < sequenciaNumeros.length; i++) { 
		
		int a = i;
	
		while (a > 0 && Integer.parseInt(sequenciaNumeros[a]) > Integer.parseInt(sequenciaNumeros[a-1])) {
			String auxiliar = sequenciaNumeros[a];
			sequenciaNumeros[a] = sequenciaNumeros[a-1];
			sequenciaNumeros[a-1] = auxiliar;
			a--;
		}
	
	}
  }     
}