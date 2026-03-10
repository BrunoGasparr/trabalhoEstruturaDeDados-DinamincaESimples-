import java.util.Locale;

public class ListaSimples implements ListaOperacoes{
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento){
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if(buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }

    public int removerTodas(String elemento) {
        int cont = 0;
        if (!estaVazio()){
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                if (this.lista[i].toLowerCase().trim().equals(elemento.toLowerCase().trim())) {
                    this.lista[i] = null;
                   cont++;
                }
                }
            }
        }

        return cont;
    }

    public int contar() {
        int cont = 0;
        if (!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                    cont++;
                }
            }
        }
        return cont;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
            for (int i = 0; i < elementos.length; i++) {
                if (!estaCheia()){
                    adicionarElemento(elementos[i]);
                    adicionados++;
                }
                else break;
            }
        return adicionados;
    }

    public String obter(int indice) {
        if(indice < 0 || indice >= this.lista.length || this.lista[indice] == null) {
            return null;
        }
        else return this.lista[indice];
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (!estaCheia()){
            if (this.lista[indice] == null) {
                this.lista[indice] = elemento;
                return true;
            }
            for (int i = indice; i < lista.length ; i++) {
                if (this.lista[i] == null) {break;}
                else if (i == lista.length - 1) {return false;}
            }
            String auxiliarTroca=null, trocarElemento=null;
            for (int i = indice; i < lista.length; i++) {
                if (i == indice) {
                    trocarElemento = this.lista[i];
                    this.lista[i] = elemento;
                    auxiliarTroca = this.lista[i+1];
                }
                else if (lista[i] == null) {
                    lista[i] = trocarElemento;
                }
                else {
                    this.lista[i] = trocarElemento;
                    trocarElemento = auxiliarTroca;
                    auxiliarTroca = this.lista[i+1];

                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        String elementoRemovido = this.lista[indice];
        if (!estaVazio()) {
            if(indice < 0 || indice >= this.lista.length || this.lista[indice] == null) return null;
            else this.lista[indice] = null;
            for (int i = indice; i < lista.length-1 ; i++) {
                lista[i] = this.lista[i+1];
            }
        }
        this.lista[this.lista.length-1] = null;
        return elementoRemovido;
    }

    @Override
    public void limpar() {
        if(!estaVazio()){
            for (int i = 0; i < this.lista.length; i++) {
               this.lista[i] = null;
            }
        }
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if (!estaVazio()){
            int ultimoElementoSolicitado = -1;
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                if (this.lista[i].trim().toLowerCase().equals(elemento.toLowerCase().trim())) {
                    ultimoElementoSolicitado = i;
                }
                }
            }
            return ultimoElementoSolicitado;
        }
        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        if (!estaVazio()){
            int ultimoElementoSolicitado = 0;
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                    if (this.lista[i].trim().toLowerCase().equals(elemento.toLowerCase().trim())) {
                        ultimoElementoSolicitado ++;
                    }
                }
            }
            return ultimoElementoSolicitado;
        }
        return 0;
    }

    @Override
    public int substituir(String antigo, String novo) {
        if (!estaVazio()){
            int quantidadeDeTrocas = 0;
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                    if (this.lista[i].trim().toLowerCase().equals(antigo.toLowerCase().trim())) {
                        this.lista[i] = novo;
                        quantidadeDeTrocas ++;
                    }
                }
            }
            return quantidadeDeTrocas;
        }
        return 0;
    }
}
