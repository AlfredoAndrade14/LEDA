package Warmup;
import java.util.Scanner;

class VetorCircular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] sequenciaInteiros = sc.nextLine().split(" ");

        int quantidade = Integer.parseInt(sc.nextLine());

        String saida = "";

        for (int i = 0; i < quantidade; i++) {
            saida += sequenciaInteiros[i % sequenciaInteiros.length] + " ";
        }

        System.out.println(saida.trim());
    }    
}
