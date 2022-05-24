package Lab2;

import java.util.Arrays;
import java.util.Scanner;

class FuraFila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] sequenciaIdades = sc.nextLine().split(" ");
        int indicie = sc.nextInt();
        
        int i = indicie;
        int limite = 0;
        while(i < sequenciaIdades.length){
            for (int e = i; e > limite; e--){
                String temporario = sequenciaIdades[e];
                sequenciaIdades[e] = sequenciaIdades[e-1];
                sequenciaIdades[e-1] = temporario; 
            }
            System.out.println(Arrays.toString(sequenciaIdades));
            limite++;
            i++;
        }
    }
}