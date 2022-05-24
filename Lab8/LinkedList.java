package Lab8;
import java.util.Scanner;

class LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] numerosStr = sc.nextLine().split(" ");
        String index = sc.nextLine();
    
        LinkedList lista = new LinkedList();
        for(int i = 0; i < numerosStr.length; i++) {
           lista.addLast(Integer.parseInt(numerosStr[i]));;
        }
    
        lista.troca(Integer.parseInt(index));
        System.out.println(lista);
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void troca(int index) {
        if(!isEmpty()) {
            int atual = 0;
            troca(this.head, atual, index);   
        }
    }
    
    private void troca(Node no, int atual, int index) {
        if(!(no == null)) {
            if(atual == index) {
                if(!(no.next.next == null) && !(no.previous == null)){   
                    no.next = no.next.next;
                    no.next.previous.previous = no.previous;
                    no.previous = no.next.previous;
                    no.previous.next = no;
                    no.previous.previous.next = no.previous;
                } else if(((no.next.next == null) && (no.previous == null))){
                    this.head = no.next;
                    this.tail = no;

                    no.previous = no.next;
                    no.next.next = no;
                    no.next.previous = null;
                    no.next = null;
                } else if(no.previous == null){ 
                    this.head = no.next;
                    no.next = no.next.next;
                    no.next.previous.previous = null;
                    no.next.previous.next = no;
                    no.previous = no.next.previous;
                } else if(no.next.next == null) {
                    this.tail = no;
                    no.previous.next = no.next;
                    no.next.previous = no.previous;
                    no.next.next = no;
                    no.previous = no.next;
                    no.next = null;
                }

            }else {
                atual ++;
                troca(no.next, atual, index);
            }
        }
    }

    public boolean isEmpty() {
        return this.head == null;	
    }
    
    public void addLast(int n) {
        Node novoNo = new Node(n); 

        if (isEmpty()) {
            this.head = novoNo;
            this.tail = novoNo;
        } else {
            this.tail.next = novoNo;
            novoNo.previous = this.tail;
            this.tail = novoNo;
        }
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        }

        return this.elementos(this.head).trim();
    }

    private String elementos(Node node) {
        if (node == null)
            return "";
        else {
            return node.value + " " + elementos(node.next);
        }
    }
 
    public class Node {
        int value;
        Node next;
        Node previous;
        
        Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }
}