package fila;

public class Main {
	public static void main(String[] args) {
		Fila<Pessoa> fila = new Fila<>();
		System.out.println(fila);
        System.out.println(fila.tamanho());
        System.out.println(fila.isEmpty());
        
        Pessoa p1 = new Pessoa("Aa");
        Pessoa p2 = new Pessoa("Bb");
        Pessoa p3 = new Pessoa("Cc");
        Pessoa p4 = new Pessoa("DD");
        Pessoa p5 = new Pessoa("Ee");
        Pessoa p6 = new Pessoa("Ff");
        
        System.out.println();
        fila.Inserir(p1);
        System.out.println(fila);
        fila.Inserir(p2);
        System.out.println(fila);
        fila.Inserir(p3);
        System.out.println(fila);
        fila.Inserir(p4);
        System.out.println(fila);
        fila.Inserir(p5);
        System.out.println(fila);
        
        System.out.println(fila.existeDado(p2));
        System.out.println(fila.isEmpty());
        System.out.println(fila.Recuperar());
        System.out.println(fila.tamanho());
        
        System.out.println();
        fila.Alterar(p6);
        System.out.println(fila);
        
        fila.Remover();
        System.out.println(fila);
        System.out.println(fila.existeDado(p2));
        
        fila.limpa();
        System.out.println(fila);
	}
}
