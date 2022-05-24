package Lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCloud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] texto = sc.nextLine().split(" ");
        ArrayList<String> palavras = new ArrayList<String>();
        ArrayList<Integer> freq = new ArrayList<Integer>();

        for (String i : texto) {
            if(palavras.contains(i)){
                int index = palavras.indexOf(i);
                freq.set(index, (freq.get(index)+ 1));
            }
            else{
                palavras.add(i);
                freq.add(1);
            }
        }
        String[] palavra;
        while(true) {
            palavra = sc.nextLine().split(" ");
            if(palavra[0].equals("fim")) {break;}
            else{
                System.out.println(freq.get(palavras.indexOf(palavra[0])));
            }
        }
    }

}