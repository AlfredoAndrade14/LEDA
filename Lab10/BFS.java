package Lab10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] numerosStr = sc.nextLine().split(" ");
        BFS bst = new BFS(); 
        for(int i = 0; i < numerosStr.length; i++) {
            bst.add(Integer.parseInt(numerosStr[i]));
        }

        String saida = "";
        for (Integer i : bst.bfsDirieta()){
            saida += i + " ";
        }
        System.out.println(saida.trim());
    }

    private Node root;
    private int size;

    public BFS(){
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

    public ArrayList<Integer> bfsDirieta() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        
        if (this.root != null) {
            queue.add(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.remove();
                
                list.add(current.value);
                
                if(current.right != null){ 
                    queue.add(current.right);
                }
                   
                if(current.left != null){
                    queue.add(current.left);
                }
            }
        }
        return list;
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