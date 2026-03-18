public class PilhaSimples {
    Integer [] pilha;

    public PilhaSimples(int tamanho) {
        this.pilha = new Integer[tamanho];
    }

    public void empilhar(int numero) {
        if(!estaCheia()) {
            for (int i = 0; i < this.pilha.length; i++) {
                if(this.pilha[i] == null) {
                    this.pilha[i] = numero;
                    System.out.println("O número " + numero + " foi inserido com sucesso.");
                    return;
                }
            }
        }
    }
    public void desempilhar() {
        if(!estaVazio()){
            for (int i = 0; i < this.pilha.length; i++) {
                if(i==this.pilha.length-1) {
                    this.pilha[i] = null;
                    return;
                } else if (this.pilha[i+1] != null) {
                    this.pilha[i] = null;
                    return;
                }
            }
        }
    }
    private boolean estaCheia() {
        if(this.pilha[this.pilha.length-1] != null) {
            System.out.println("A pilha está cheia!");
            return true;
        } else {
            return false;
        }
    }

    private boolean estaVazio() {
        if(this.pilha[0] == null) {
            System.out.println("A fila está vazia!");
            return true;
        } else {
            return false;
        }
    }
    public void exibirPilha() {
        if(!estaVazio()) {
            for (int i = 0; i < this.pilha.length; i++) {
                System.out.println(this.pilha[i]);
            }
        }
    }
}
