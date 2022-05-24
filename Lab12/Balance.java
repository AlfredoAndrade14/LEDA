package Lab12;

import java.util.Scanner;

class Balance{
    private Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Balance balance = new Balance();
        String[] numerosStr = sc.nextLine().split(" ");
        for(int i = 0; i < numerosStr.length; i++) {
            balance.add(Integer.parseInt(numerosStr[i]));
        }
        balance.preOrder();
    }
    
    Balance() {
        this.root = null;
    }

    public void add(int element) {
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void preOrder() {
        System.out.println(preOrder(this.root).trim());
    }

    private String preOrder(Node node) {
        String saida = "";
        if (node != null) {
            saida = saida + (node.value + "," + (height(node.left) - height(node.right))) + " "
            + preOrder(node.left)
            + preOrder(node.right);
        }
        return saida;
    }

    public int height(Node node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left) , height(node.right));
    }

    class Node {
    
        int value;
        Node left;
        Node right;
        Node parent;
        
        Node(int v) {
            this.value = v;
        }
    }
}