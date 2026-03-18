public class PilhaDinamica {
    NoInteiro inicio;

    public PilhaDinamica() {
        this.inicio = new NoInteiro(null);
    }

    private boolean existeInicio() {
        if(this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }
    private boolean estaVazio() {
        if(this.inicio.getConteudo() == null) {
            System.out.println("A Fila está vazia.");
            return true;
        } else {
            return false;
        }
    }
    public void exibir(){
        if(!estaVazio()) {
            NoInteiro aux = this.inicio;
            while(aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }
    public void empilhar(int numero) {
        if(estaVazio()) {
            System.out.println("Número " + numero + " adicionado a Fila.");
            this.inicio.setConteudo(numero);
        } else {
            NoInteiro novoNo = new NoInteiro(numero);
            NoInteiro aux = this.inicio;
            while(aux != null) {
                if(aux.getProx() == null) {
                    System.out.println("Número " + numero + " adicionado a Fila.");
                    aux.setProx(novoNo);
                    return;
                }
                aux = aux.getProx();
            }
        }
    }
    public void remover() {
        if(existeInicio()) {
            if (this.inicio.getProx() == null) {
                this.inicio.setConteudo(null);
                return;
            }
            else {
                NoInteiro aux = this.inicio;
                while(aux != null) {
                    if(aux.getProx() == null) {
                        aux.setConteudo(null);
                        return;
                    }
            }
        }
    }
}
}
