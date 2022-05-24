package Lab10;

import java.util.Scanner;

class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] numerosStr = sc.nextLine().split(" ");
        BST bst = new BST(); 
        for(int i = 0; i < numerosStr.length; i++) {
            bst.add(Integer.parseInt(numerosStr[i]));
        }
        System.out.println(bst.soma());
    }


    public int soma() {
        return soma(this.root);
    }

    private int soma(Node no) {
        int soma = 0;
        if (!no.isLeaf()) {
            if(no.left != null){
                soma += soma(no.left);
            }
            if(no.right != null){
                soma += soma(no.right);
            }
        }
        else{
            return no.value;
        }
        return soma;
    }


    private Node root;
    private int size;

    BST(){
        this.root = null;
        this.size = 0;
    }
    
    public void add(int element) {
        this.size += 1;
        if (this.root == null)
            this.root = new Node(element);
        else {
            Node node = this.root;
            
            while (node != null) {
                
                if (element < node.value) {
                    if (node.left == null) { 
                        Node newNode = new Node(element);
                        node.left = newNode;
                        newNode.parent = node;
                        return;
                    }
                    
                    node = node.left;
                } else {
                    if (node.right == null) { 
                        Node newNode = new Node(element);
                        node.right = newNode;
                        newNode.parent = node;
                        return;
                    }
                    
                    node = node.right;
                }
            }
        }
        
    }

    class Node {
    
        int value;
        Node left;
        Node right;
        Node parent;
        
        Node(int v) {
            this.value = v;
        }
    
        public boolean hasOnlyLeftChild() {
            return (this.left != null && this.right == null);
        }
        
        public boolean hasOnlyRightChild() {
            return (this.left == null && this.right != null);
        }
    
        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }
        
    }
}