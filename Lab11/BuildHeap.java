package Lab11;

import java.util.Arrays;
import java.util.Scanner;

class BuildHeap{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            
        String[] numerosStr = sc.nextLine().split(" ");
        int [] sequenciaNumeros = new int[numerosStr.length];
        
        for(int i = 0; i < numerosStr.length; i++) {
            sequenciaNumeros[i] = Integer.parseInt(numerosStr[i]);
        }

        BuildHeap heap = new BuildHeap(sequenciaNumeros);
        System.out.println(heap);
    }

    int[] array;
    int fim;

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public int parent(int i) {
        return (i-1)/2;
    }

    BuildHeap(int[] heap) {
        this.array = heap;
        this.fim = this.array.length - 1;
        for (int i = parent(this.fim); i >= 0; i--)
            heapify(i); 
    }

    private void heapify(int i) {
        if ((i > parent(fim) && i <= fim) || !(i >= 0 && i <= fim)){
            return;
        }
        int index_max = max_index(i, 2*i+1, (i+1)*2);

        if (index_max != i) {
            int aux = this.array[i];
            this.array[i] = this.array[index_max];
            this.array[index_max] = aux;
            heapify(index_max);
        }
    } 

    private int max_index(int index, int left, int right) {
        if (this.array[index] > this.array[left]) {
            if (right >= 0 && right <= fim) {
                if (this.array[index] < this.array[right])
                    return right;
            }
            return index;
        
        } else {
            if (right >= 0 && right <= fim) {
                if (this.array[left] < this.array[right])
                    return right;
            } 
            
            return left;
        }
    }
}