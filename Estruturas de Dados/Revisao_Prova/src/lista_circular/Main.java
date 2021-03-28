package lista_circular;

public class Main {
	
	public static void main(String[] args) {
		ListaDuplamenteEncadeada<Dia> lista = new ListaDuplamenteEncadeada<Dia>();
		System.out.println(lista);
		
		Dia d1 = new Dia("Domingo");
		Dia d2 = new Dia("Segunda");
		Dia d3 = new Dia("Terça");
		Dia d4 = new Dia("Quarta");
		Dia d5 = new Dia("Quinta");
		Dia d6 = new Dia("Sexta");
		Dia d7 = new Dia("Sábado");
		
		lista.adicionaInicio(d7);
		lista.adicionaInicio(d6);
		lista.adicionaInicio(d5);
		lista.adicionaInicio(d4);
		lista.adicionaInicio(d3);
		lista.adicionaInicio(d2);
		lista.adicionaInicio(d1);
		System.out.println(lista);
		
		lista.removeFim();
		System.out.println(lista);
		lista.removeFim();
		System.out.println(lista);
		lista.removeFim();
		System.out.println(lista);
		lista.removeFim();
		System.out.println(lista);
		lista.removeFim();
		System.out.println(lista);
		lista.removeFim();
		System.out.println(lista);
		lista.removeFim();
		System.out.println(lista);
		
		Dia d8 = new Dia("Domingo");
		Dia d9 = new Dia("Segunda");
		
		lista.adicionaInicio(d9);
		lista.adicionaInicio(d9);
		lista.adicionaInicio(d8);
		lista.adicionaInicio(d8);
		System.out.println(lista);
		
		lista.removeDuplicados();
		System.out.println(lista);
	}
}
