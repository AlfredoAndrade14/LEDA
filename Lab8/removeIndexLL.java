package Lab8;
import java.util.Scanner;

class removeIndexLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] numerosStr = sc.nextLine().split(" ");
        String index = sc.nextLine();

        linkedList lista = new linkedList();
        for(int i = 0; i < numerosStr.length; i++) {
           lista.addLast(Integer.parseInt(numerosStr[i]));;
        }

        lista.removeIndex(Integer.parseInt(index));
        System.out.println(lista);
    }
}

class linkedList{
    private Node head;
    private Node tail;

    public linkedList() {
        this.head = null;
        this.tail = null;
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
    
    public void removeIndex(int index) {
        if(!isEmpty()) {
            int atual = 0;
            removeIndex(this.head, atual, index);   
        }
    }
    
    private void removeIndex(Node no, int atual, int index) {
        if(!(no == null)) {
            if(atual == index) {
                if(atual == 0) {
                    this.head = no.next;
                    no.next.previous = null;
                }else {
                    no.previous.next = no.next;
                    if(!(no.next == null)){
                        no.next.previous = no.previous;
                    }
                }
            }
            else{
                atual ++;
                removeIndex(no.next, atual, index);
            }
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
}

class Node {
    int value;
    Node next;
    Node previous;
    
    Node(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}