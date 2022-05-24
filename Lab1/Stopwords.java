package Lab1;

import java.util.Scanner;

class Stopwords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] textoAnalisado = sc.nextLine().split(" ");
        String[] stopwords = sc.nextLine().split(" ");
        String saida = "";

        for (int i = 0; i < textoAnalisado.length; i++) {
            boolean status = true;
            for (int j = 0; j < stopwords.length; j++) {
                if (textoAnalisado[i].equals(stopwords[j])) {
                    status = false;
                    break;
                }
            }
            if (status) {
                saida += textoAnalisado[i] + " ";
            }
        }

        System.out.println(saida.trim());
    }
}
