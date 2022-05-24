package Lab12;

import java.util.Scanner;

class Rotacoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rotacoes rotacoes = new Rotacoes();
        String[] numerosStr = sc.nextLine().split(" ");
        if(Integer.parseInt(numerosStr[1]) > Integer.parseInt(numerosStr[0]) && Integer.parseInt(numerosStr[1]) > Integer.parseInt(numerosStr[2]) && Integer.parseInt(numerosStr[0]) > Integer.parseInt(numerosStr[2])) {
            System.out.println("balanceada");
        }
        if(Integer.parseInt(numerosStr[2]) > Integer.parseInt(numerosStr[0]) && Integer.parseInt(numerosStr[2]) > Integer.parseInt(numerosStr[1]) && Integer.parseInt(numerosStr[0]) > Integer.parseInt(numerosStr[1])) {
            System.out.println("balanceada");
        }
        for(int i = 0; i < numerosStr.length; i++) {
            rotacoes.add(Integer.parseInt(numerosStr[i]));
        }
    }
    
    private Node root;
    
    Rotacoes(){
        this.root = null;
    }

    public int height(Node node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left) , height(node.right));
    }
    
    public void add(int no) {
        if(this.root == null){
            this.root = new Node(no);
        }

        else {
            Node aux = this.root;
            while (aux != null) {
                Node newNode = new Node(no);
                if (no < aux.value) {
                    if (aux.left == null) { 
                        aux.left = newNode;
                        newNode.parent = aux;
                        verificarBalanceamento(newNode.parent);
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        aux.right = newNode;
                        newNode.parent = aux;
                        verificarBalanceamento(newNode.parent);
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
    }

    public void verificarBalanceamento(Node pai) {
		pai.balance = height(pai.right) - height(pai.left);
		int balanceamento = pai.balance;

		if (balanceamento == -2) {
			if (height(pai.left.left) >= height(pai.left.right)) {
				System.out.println("rot_dir("+pai.value+")");
                pai = rotacaoDireita(pai);
			} else {
                pai = duplaRotacaoEsquerdaDireita(pai);
			}
            if (pai.parent == null) this.root = pai;
            preOrder();

		} else if (balanceamento == 2) {
			if (height(pai.right.right) >= height(pai.right.left)) {
                System.out.println("rot_esq("+pai.value+")");
				pai = rotacaoEsquerda(pai);
                if (pai.parent == null) this.root = pai;
			} else {
				pai = duplaRotacaoDireitaEsquerda(pai);
			}
            if (pai.parent == null) this.root = pai;
            preOrder();
		}

		if (pai.parent != null) {
			verificarBalanceamento(pai.parent);
		}
	}


    public Node rotacaoEsquerda(Node no) {
		Node direita = no.right;
		direita.parent = no.parent;

		no.right = direita.left;

		if (no.right != null) {
			no.right.parent = no;
		}

		direita.left = no;
		no.parent = direita;

		if (direita.parent != null) {

			if (direita.parent.right == no) {
				direita.parent.right = direita;
			
			} else if (direita.parent.left == no) {
				direita.parent.left = direita;
			}
		}

		no.balance = height(no.right) - height(no.left);
		direita.balance = height(direita.right) - height(direita.left);

		return direita;
	}

	public Node rotacaoDireita(Node no) {

		Node esquerda = no.left;
		esquerda.parent = no.parent;

		no.left = esquerda.right;

		if (no.left != null) {
			no.left.parent = no;
		}

		esquerda.right = no;
		no.parent = esquerda;

		if (esquerda.parent != null) {

			if (esquerda.parent.right == no) {
				esquerda.parent.right = esquerda;
			
			} else if (esquerda.parent.left == no) {
				esquerda.parent.left = esquerda;
			}
		}

		no.balance = height(no.right) - height(no.left);
		esquerda.balance = height(esquerda.right) - height(esquerda.left);
 
		return esquerda;
	}

	public Node duplaRotacaoEsquerdaDireita(Node no) {
        System.out.println("rot_esq("+no.left.value+")");
		no.left = rotacaoEsquerda(no.left);
        System.out.print("[");
        System.out.print(no.value+", ");
        System.out.print(no.left.value+", ");
        System.out.print(no.left.left.value);
        System.out.println("]");

        System.out.println("rot_dir("+no.value+")");
		return rotacaoDireita(no);
	}

	public Node duplaRotacaoDireitaEsquerda(Node no) {
        System.out.println("rot_dir("+no.right.value+")");
		no.right = rotacaoDireita(no.right);
        System.out.print("[");
        System.out.print(no.value+", ");
        System.out.print(no.right.value+", ");
        System.out.print(no.right.right.value);
        System.out.println("]");

        System.out.println("rot_esq("+no.value+")");
		return rotacaoEsquerda(no);
	}

    public void preOrder() {
        System.out.print("[");
        System.out.print(this.root.value+", ");
        System.out.print(this.root.left.value+", ");
        System.out.print(this.root.right.value);
        System.out.println("]");
    }

    class Node {
        int value;
        Node left;
        Node right;
        Node parent;
        int balance;
        
        Node(int v) {
            this.value = v;
            this.balance = 0;
        }
    }
}