public class ListaDinamica implements ListaOperacoes{
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if(!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        if(this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirElementos() {
        if(existeInicio()) {
            No aux = this.inicio;
            while(aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if(existeInicio()) {
            if(buscarElemento(elemento)) {
                //removendo primeiro
                if(this.inicio.getConteudo().equals(elemento)) {
                    this.inicio = this.inicio.getProx();
                } else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        if(aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    } while (aux != null);
                } else {
                    this.inicio.setConteudo(null);
                }
            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;

        do {
            if(aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while(aux.getProx() != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    @Override
    public int removerTodas(String elemento) {
        int contadorDeRemocao = 0;
        if(!existeInicio()) {
            return 0;
        }
        while(this.inicio != null && this.inicio.getConteudo().equals(elemento)) {
            this.inicio = this.inicio.getProx();
            contadorDeRemocao++;
        }
        No aux = this.inicio;
        while(aux != null && aux.getProx() != null) {
            if(aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx());
                contadorDeRemocao++;
            } else {
                aux = aux.getProx();
            }
        }
        return contadorDeRemocao;
    }

    @Override
    public int contar() {
        if(existeInicio()){
            int contadorElementos = 0;
            No aux = this.inicio;
            do {
                contadorElementos++;
                aux = aux.getProx();
            }while (aux != null);
            return contadorElementos;
        }
        return 0;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
       int contador = 0;
        for (int i = 0; i < elementos.length ; i++) {
            adicionarElemento(elementos[i]);
            contador++;
        }
        return contador;
    }

    @Override
    public String obter(int indice) {
        if(indice>=0 ){
            No aux = this.inicio;
        if (existeInicio()) {
            for (int i = 0; i <= indice; i++) {
                if(i == indice){
                    return aux.getConteudo();
                }
                else if(aux.getProx() == null){
                    return null;
                }
                aux = aux.getProx();
            }
        }
        }
        return null;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if(indice < 0){
            return false;
        }
        No novoNo = new No(elemento);
        if(indice == 0){
            if(!existeInicio()){
                this.inicio.setConteudo(elemento);
            }else{
                novoNo.setProx(this.inicio);
                this.inicio = novoNo;
            }
            return true;
        }
        if(existeInicio()){
            No aux = this.inicio;
            for(int i = 0; i < indice - 1; i++){
                if(aux.getProx() == null){
                    return false;
                }
                aux = aux.getProx();
            }
            novoNo.setProx(aux.getProx());
            aux.setProx(novoNo);
            return true;
        }
        return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0) return null;
        if (existeInicio()) {
            String conteudoRemovido;
            if(indice == 0){
                conteudoRemovido = this.inicio.getConteudo();
                this.inicio = this.inicio.getProx();
                return conteudoRemovido;
            }
            else {
                No aux = this.inicio;
                for(int i = 0; i < indice; i++){
                     if(indice-1 == i && aux.getProx() != null){
                        conteudoRemovido = aux.getProx().getConteudo();
                        aux.setProx(aux.getProx().getProx());
                        return conteudoRemovido;
                    }
                     if(aux.getProx() == null){
                         return null;
                     }
                    aux = aux.getProx();
                    }
                }
            }
        return null;
    }

    @Override
    public void limpar() {
        if (existeInicio()){
            this.inicio = null;
        }
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if(buscarElemento(elemento)){
            int indiceUltimoElemento = 0, contador=0;
            No aux = this.inicio;
            while(aux.getProx() != null){
                contador++;
                if(aux.getProx().getConteudo().equals(elemento)){
                    indiceUltimoElemento = contador;
                }
                aux = aux.getProx();
            }
            return indiceUltimoElemento;
        }
        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        if(buscarElemento(elemento)){
            int contador=0;
            No aux = this.inicio;
            while(aux != null){
                if(aux.getConteudo().equals(elemento)){
                contador++;
                }
                aux = aux.getProx();
            }
            return contador;
        }
        return -1;
    }

    @Override
    public int substituir(String antigo, String novo) {
        if(buscarElemento(antigo)){
            No aux = this.inicio;
            int contador=0;
            while(aux != null){
                if(aux.getConteudo().equals(antigo)){
                    contador++;
                    aux.setConteudo(novo);
                }
                aux = aux.getProx();
            }
            return contador;
        }
        return 0;
    }
}
