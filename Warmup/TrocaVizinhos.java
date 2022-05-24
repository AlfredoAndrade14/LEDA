package Warmup;
import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] sequenciaInteiros = sc.nextLine().split(" ");

        for (int i = 0; i < sequenciaInteiros.length-1; i += 2) {    
            String temporario = sequenciaInteiros[i];
            sequenciaInteiros[i] = sequenciaInteiros[i + 1];
            sequenciaInteiros[i+1] = temporario;
        }
        System.out.println(Arrays.toString(sequenciaInteiros));
    }
    
}
