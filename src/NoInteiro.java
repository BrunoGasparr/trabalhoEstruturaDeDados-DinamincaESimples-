public class NoInteiro {
    Integer conteudo;
    NoInteiro prox;

    public NoInteiro(Integer conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
    }

    public NoInteiro getProx() {
        return prox;
    }

    public void setProx(NoInteiro prox) {
        this.prox = prox;
    }

    public Integer getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }
}
