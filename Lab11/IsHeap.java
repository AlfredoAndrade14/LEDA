package Lab11;

import java.util.Scanner;

class IsHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
        String[] numerosStr = sc.nextLine().split(" ");
        boolean status = true;
        for(int i = 1; i < numerosStr.length; i++) {
            if(Integer.parseInt(numerosStr[(i-1)/2]) < Integer.parseInt(numerosStr[i])){
                status = false;
                break;
            }
        }
        System.out.println(status);
    }
    
}