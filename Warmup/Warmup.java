package Warmup;
import java.util.Scanner;

class Warmup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int multiplicador = Integer.parseInt(sc.nextLine());

        String[] sequenciaInteiros = sc.nextLine().split(" ");

        String saida = "";

        for(int i = 0; i < sequenciaInteiros.length; i++) {
            int novoValor = Integer.parseInt(sequenciaInteiros[i]) * (multiplicador);
            
            saida += novoValor + " ";
        }

        System.out.print(saida.trim());
    }
}
