package pilha;

public class Main {
	
	public static void main(String[] args) {
		Pilha<Pessoa> pilha = new Pilha<>();
		System.out.println("Pilha.\n"+pilha);
        System.out.println("Tamanho: "+pilha.tamanho());
        System.out.println("Vazia: "+pilha.isEmpty());
		
		Pessoa p1 = new Pessoa("Aa");
	    Pessoa p2 = new Pessoa("Bb");
	    Pessoa p3 = new Pessoa("Cc");
	    Pessoa p4 = new Pessoa("DD");
	    Pessoa p5 = new Pessoa("Ee");
	    Pessoa p6 = new Pessoa("Ff");
	    Pessoa p7 = new Pessoa("Gg");
	    
	    System.out.println();
        System.out.println("Adiciona topo.");
        pilha.Push(p5);
        System.out.println(pilha);
        System.out.println("Tamanho: "+pilha.tamanho());
        System.out.println("Adiciona topo.");
        pilha.Push(p4);
        System.out.println(pilha);
        System.out.println("Tamanho: "+pilha.tamanho());
        System.out.println("Adiciona topo.");
        pilha.Push(p3);
        System.out.println(pilha);
        System.out.println("Tamanho: "+pilha.tamanho());
        System.out.println("Adiciona topo.");
        pilha.Push(p2);
        System.out.println(pilha);
        System.out.println("Tamanho: "+pilha.tamanho());
        System.out.println("Adiciona topo.");
        pilha.Push(p6);
        System.out.println(pilha);
        System.out.println("Tamanho: "+pilha.tamanho());
        System.out.println("Vazia: "+pilha.isEmpty());
        
        System.out.println();
        System.out.println(pilha);
        System.out.println("Existe \"Ff\" no topo? "+pilha.existeDado(p6));
        System.out.println("Existe \"Ee\" no topo? "+pilha.existeDado(p5));
        System.out.println("Existe \"Aa\" no topo? "+pilha.existeDado(p1));
        
        System.out.println();
        System.out.println(pilha);
        System.out.println("Recupera topo. "+pilha.Top());
        
        System.out.println();
        System.out.println("Alterar topo");
        pilha.Pull(p7);
        System.out.println(pilha);
        System.out.println("Alterar topo");
        pilha.Pull(p1);
        System.out.println(pilha);
        
        System.out.println();
        System.out.println("Remove topo.");
        pilha.Pop();
        System.out.println(pilha);
        
        System.out.println();
        System.out.println("Método Limpa.");
        pilha.limparPilha();
        System.out.println(pilha);
        System.out.println("Tamanho: "+pilha.tamanho());
        System.out.println("Vazia: "+pilha.isEmpty());
	}
}
