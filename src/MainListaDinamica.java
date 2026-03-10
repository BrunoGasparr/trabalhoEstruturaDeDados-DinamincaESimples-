public class MainListaDinamica {
    public static void main(String[] args) {
        ListaDinamica listaDinamica = new ListaDinamica();
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.exibirElementos();
        listaDinamica.exibirElementos();
        System.out.println(listaDinamica.contar());
        System.out.println(listaDinamica.obter(3));
    }
}
