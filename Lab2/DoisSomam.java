package Lab2;

import java.util.Scanner;

class DoisSomam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] sequenciaNumeros = sc.nextLine().split(" ");
        int soma = sc.nextInt();
        

        System.out.println(VerificaSoma(sequenciaNumeros,soma));
    }
    
    public static String VerificaSoma(String[] sequenciaNumeros, int soma ){
        for (int i = 0; i < sequenciaNumeros.length; i++) {
            for (int e = i+1; e < sequenciaNumeros.length; e++) {
                if(Integer.parseInt(sequenciaNumeros[i]) + Integer.parseInt(sequenciaNumeros[e]) == soma){
                    return (sequenciaNumeros[i] + " " + sequenciaNumeros[e]);
                }
            }
        }
        return "-1";
    }
}