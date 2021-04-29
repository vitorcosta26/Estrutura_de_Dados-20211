package fila;

public class Main {
	public static void main(String[] args) {
		Fila<Pessoa> fila = new Fila<>();
		System.out.println("Fila.\n"+fila);
        	System.out.println("Tamnho: "+fila.tamanho());
        	System.out.println("Vazia: "+fila.isEmpty());
        	
        	Pessoa p1 = new Pessoa("Aa");
        	Pessoa p2 = new Pessoa("Bb");
        	Pessoa p3 = new Pessoa("Cc");
        	Pessoa p4 = new Pessoa("DD");
        	Pessoa p5 = new Pessoa("Ee");
        	Pessoa p6 = new Pessoa("Ff");
        	
        	System.out.println();
        	System.out.println("Adiciona.");
        	fila.Inserir(p1);
        	System.out.println(fila);
        	System.out.println("Adiciona.");
        	fila.Inserir(p2);
        	System.out.println(fila);
        	System.out.println("Adiciona.");
        	fila.Inserir(p3);
        	System.out.println(fila);
        	System.out.println("Adiciona.");
        	fila.Inserir(p4);
        	System.out.println(fila);
        	System.out.println("Adiciona.");
        	fila.Inserir(p5);
        	System.out.println(fila);
        	
        	System.out.println();
        	System.out.println("Existe \"Bb\" no início da fila: "+fila.existeDado(p2));
        	
        	System.out.println();
        	System.out.println("Recupera dado no início. "+fila.Recuperar());
        	System.out.println("Tamnho: "+fila.tamanho());
        	
	        System.out.println();
        	System.out.println("Alterar dado no início.");
        	fila.Alterar(p6);
        	System.out.println(fila);
        	
        	System.out.println();
        	System.out.println("Remove dado no início.");
        	fila.Remover();
        	System.out.println(fila);
        	
        	System.out.println();
        	System.out.println("Existe \"Bb\" no início da fila: "+fila.existeDado(p2));
        	
        	System.out.println();
        	System.out.println("Método Limpa.");
        	fila.limpa();
        	System.out.println(fila);
        	System.out.println("Tamnho: "+fila.tamanho());
        	System.out.println("Vazia: "+fila.isEmpty());
	}
}
