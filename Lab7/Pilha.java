package Lab7;

import java.util.ArrayList;
import java.util.Scanner;

class Pilha {
    int[] elements;
    int head;
    int size;
    
    public Pilha(int size) {
        this.elements = new int[size];
        this.head = -1;
        this.size = size;
    }
        
    public int pop() {
        if(this.isEmpty()) {
            throw new RuntimeException("EmptyStackException");
        }
        int valHead = this.elements[head];
        this.head -= 1;
        return valHead;
    }
    
    public void push(int i) {
        if(this.isFull()){
            throw new RuntimeException("FullStackException");
        }
        head += 1;
        this.elements[head] = i;
    }

    public int peek(){
        if (this.isEmpty()){
            throw new RuntimeException("EmptyStackException");
        }
        return this.elements[head];
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

     public int size() {
        return this.head + 1;
    }

    public boolean isFull() {
        return this.head == (size - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maior = 0;
        String[] numerosStr = sc.nextLine().split(" ");
        String index = sc.nextLine();
        
        Pilha pilha = new Pilha(numerosStr.length);
        for(int i = 0; i < numerosStr.length; i++) {
           pilha.push(Integer.parseInt(numerosStr[i]));
        }

        ArrayList<Integer> aux = new ArrayList<>();
        for(int i = 0; i <= Integer.parseInt(index); i++){
            aux.add(pilha.pop());
        }

        for(int i = aux.size()-1; i >= 0; i--){
            if(aux.get(i) > maior) maior = aux.get(i);
            pilha.push(aux.get(i));
        }
        System.out.println(maior);
    }
}