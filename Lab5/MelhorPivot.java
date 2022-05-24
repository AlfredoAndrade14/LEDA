package Lab5;

import java.util.Scanner;

class MelhorPivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] sequenciaNumeros = sc.nextLine().split(" ");
        String[] indexPivot = sc.nextLine().split(" ");
        int maioresQuePrimeiro = 0;
        int menoresQuePrimeiro = 0;
        int maioresQueSegundo = 0;
        int menoresQueSegundo = 0;

        for(int i = 0; i < sequenciaNumeros.length; i++){
            if(i!=Integer.parseInt(indexPivot[0])){
                if(Integer.parseInt(sequenciaNumeros[i]) <= Integer.parseInt(sequenciaNumeros[Integer.parseInt(indexPivot[0])])){
                    menoresQuePrimeiro++;
                } else maioresQuePrimeiro++;
            }
            if(i!=Integer.parseInt(indexPivot[1])){
                if(Integer.parseInt(sequenciaNumeros[i]) <= Integer.parseInt(sequenciaNumeros[Integer.parseInt(indexPivot[1])])){
                    menoresQueSegundo++;
                } else maioresQueSegundo++;
            }
        }

        int diferencaPrimeiro = Math.abs(maioresQuePrimeiro - menoresQuePrimeiro);
        int diferencaSegundo = Math.abs(maioresQueSegundo - menoresQueSegundo);
        int pivot = diferencaPrimeiro <= diferencaSegundo ? Integer.parseInt(indexPivot[0]) : Integer.parseInt(indexPivot[1]);

        System.out.println(pivot);
    }    
}
