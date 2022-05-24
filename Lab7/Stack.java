package Lab7;

import java.util.ArrayList;
import java.util.Scanner;

class Stack {
    int[] elements;
    int head;
    int size;
    
    public Stack(int size) {
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
        
        String tamanhoPilha = sc.nextLine();
        String[] numerosStr = sc.nextLine().split(" ");
        String index = sc.nextLine();

        Stack pilha = new Stack(Integer.parseInt(tamanhoPilha));
        for(int i = 0; i < numerosStr.length; i++) {
           pilha.push(Integer.parseInt(numerosStr[i]));
        }
        
        System.out.println('-');
        ArrayList<Integer> aux = new ArrayList<>();

        for(int i = 0; i <= Integer.parseInt(index); i++){
            aux.add(pilha.pop());
        }

        for(int i = 0; i < aux.size(); i++){
            pilha.push(aux.get(i));
        }
  
        for(int i =  Integer.parseInt(tamanhoPilha); i >= 1; i--){
            System.out.println(pilha.pop());
        }
    }
}