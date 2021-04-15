package questao_extra;

public class Main {

	public static void main(String[] args) {	    
	    ListaDuplamenteEncadeada<Integer> lista1 = new ListaDuplamenteEncadeada<>();
	    
	    lista1.adicionaFim(1);
	    lista1.adicionaFim(2);
	    lista1.adicionaFim(3);
	    lista1.adicionaFim(4);
	    System.out.println(lista1);
	    
	    System.out.println("Troca posição [1] = 2");
	    lista1.trocaPosicao(1);
	    System.out.println(lista1);
	}
}
