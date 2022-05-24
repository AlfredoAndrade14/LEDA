package Lab9;
import java.util.Arrays;
import java.util.Scanner;

class hashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tamanho = Integer.parseInt(sc.nextLine());
        String[] comando;
        hashSet coleção = new hashSet(tamanho);

        while (true) {
            comando = sc.nextLine().split(" ");
            switch (comando[0]) {
                case "put":
                 System.out.println(coleção.put(comando[1]));
                 break;
                case "remove":
                 System.out.println(coleção.remove(comando[1]));
                 break;
                case "contains":
                 System.out.println(coleção.contains(comando[1]));
                 break;
                case "end":
                 System.exit(0);
            }
        }
    }

    String[] tabela;
    int tamanho;

    public hashSet(int tamanho){
        this.tabela = new String[tamanho];
        this.tamanho = 0;
    }

    private int hash(Integer chave) {
        return chave % this.tabela.length;
    }

    public String put(String numero) {
        if(!this.contains(numero)) {
            int sondagem = 0;
            int hash;

            while (sondagem < this.tabela.length) {

                hash = (hash(Integer.parseInt(numero)) + sondagem) % tabela.length;
                String tmpNumero = tabela[hash];
                if (tmpNumero == null) {
                    tabela[hash] = numero;
                    this.tamanho += 1;
                    break;
                }
                sondagem += 1;
            }
        }   
        return Arrays.toString(tabela);
    }

    private boolean contains(String numero) {
        for(int i = 0; i < this.tabela.length; i++){
            if(this.tabela[i] != null){    
                if(this.tabela[i].equals(numero)){
                    return true;
                }
            }
        }
        return false;
    }

    private String remove(String numero) {
        for(int i = 0; i < this.tabela.length; i++){
            if(this.tabela[i] != null){    
                if(this.tabela[i].equals(numero)){
                    this.tabela[i] = null;
                }
            }
        }
        return Arrays.toString(tabela);
    }
}