package prova;

public class Main {

	public static void main(String[] args) {		
		ListaMusicas<Musica> musicas = new ListaMusicas<>();
		ListaMusicas<Musica> musicas1 = new ListaMusicas<>();
		
		Musica m1 = new Musica("A", "a", 120);
		Musica m2 = new Musica("B", "b", 60);
		Musica m3 = new Musica("C", "c", 90);
		
		musicas.setNomePlayList("PlayList1");
		
		musicas.adicionaFim(m1);
		musicas.adicionaFim(m2);
		musicas.adicionaFim(m3);
		
		Musica m4 = new Musica("D", "d", 120);
		Musica m5 = new Musica("E", "e", 60);
		Musica m6 = new Musica("F", "f", 90);
		
		musicas1.adicionaFim(m4);
		musicas1.adicionaFim(m5);
		musicas1.adicionaFim(m6);
		
		System.out.println(musicas);
		System.out.println(musicas1);
		
		musicas.mergeListas(musicas1);
		System.out.println(musicas);
		
		System.out.println(musicas.tempoTotal());
	}
}
