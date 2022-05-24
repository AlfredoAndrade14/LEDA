package Lab3;

import java.util.Scanner;

class TeoremaMestre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); //Quantidade de chamadas da função
        int b = sc.nextInt(); // Tamanho de cada subproblema
        int ord = sc.nextInt();//Ordem da funcao
        String saida = "T(n) = theta(n**";
            
        if (Math.pow(2, ord) == Math.pow(2, (Math.log(a)/Math.log(b)))) {
            System.out.println(saida + ord + " * log n)");
        } else if (Math.pow(2, ord) > Math.pow(2, (Math.log(a)/Math.log(b)))) {
            System.out.println(saida + ord +")");
        } else {
            System.out.println(saida + " log "+ ord +")");
        }
    }
}