public class FilaSimples {
    Integer [] fila;

    public FilaSimples(int tamanho) {
        this.fila = new Integer[tamanho];
    }

    public void enfileirar(int numero) {
        if(!estaCheia()) {
            for (int i = 0; i < this.fila.length; i++) {
                if(this.fila[i] == null) {
                    this.fila[i] = numero;
                    System.out.println("O número " + numero + " foi inserido com sucesso.");
                    return;
                }
            }
        }
    }

    private boolean estaCheia() {
        if(this.fila[this.fila.length-1] != null) {
            System.out.println("A fila está cheia!");
            return true;
        } else {
            return false;
        }
    }

    private boolean estaVazio() {
        if(this.fila[0] == null) {
            System.out.println("A fila está vazia!");
            return true;
        } else {
            return false;
        }
    }

    public void exibirFila() {
        if(!estaVazio()) {
            for (int i = 0; i < this.fila.length; i++) {
                System.out.println(this.fila[i]);
            }
        }
    }

    public void desenfileirar() {
        if(!estaVazio()) {
//            for (int i = 0; i < this.fila.length-1; i++) {
//                if(this.fila[i+1] != null) {
//                    this.fila[i] = this.fila[i+1];
//                } else {
//                    this.fila[i] = null;
//                    return;
//                }
//                if (i == this.fila.length-2) {
//                    this.fila[this.fila.length - 1] = null;
//                }
//            }
            //this.fila[this.fila.length-1] = null;

            for (int i = 0; i < this.fila.length-1; i++) {
                if(this.fila[i] != null) {
                    this.fila[i] = this.fila[i+1];
                } else {
                    return;
                }
            }
            this.fila[this.fila.length-1] = null;
        }
    }
}
