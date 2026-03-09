public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);
        listaSimples.exibirElementos();
        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Batata");
        listaSimples.adicionarElemento("Arroz");
        listaSimples.quantidadeElementos();
        listaSimples.exibirElementos();
        System.out.println(listaSimples.substituir("arroz", "Pizza"));
        listaSimples.exibirElementos();
    }
}
