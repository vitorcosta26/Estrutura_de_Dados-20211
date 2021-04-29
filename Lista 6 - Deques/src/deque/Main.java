package deque;

public class Main {

	public static void main(String[] args) {
		Deque<Pessoa> deque = new Deque<>();
		System.out.println("Fila.\n"+deque);
		System.out.println("Tamnho: "+deque.tamanho());
		System.out.println("Vazia: "+deque.isEmpty());
		
		Pessoa p1 = new Pessoa("Aa");
		Pessoa p2 = new Pessoa("Bb");
		Pessoa p3 = new Pessoa("Cc");
		Pessoa p4 = new Pessoa("DD");
		Pessoa p5 = new Pessoa("Ee");
		Pessoa p6 = new Pessoa("Ff");
		Pessoa p7 = new Pessoa("Gg");
		
		System.out.println();
		System.out.println("Adiciona Início.");
        	deque.InserirNoInicio(p3);
        	System.out.println(deque);
        	System.out.println("Adiciona Fim.");
        	deque.InserirNoFim(p4);
        	System.out.println(deque);
        	System.out.println("Tamnho: "+deque.tamanho());
        	System.out.println("Adiciona Início.");
        	deque.InserirNoInicio(p2);
        	System.out.println(deque);
        	System.out.println("Adiciona Fim.");
        	deque.InserirNoFim(p5);
        	System.out.println(deque);
        	System.out.println("Tamnho: "+deque.tamanho());
        	System.out.println("Adiciona Início.");
        	deque.InserirNoInicio(p1);
        	System.out.println(deque);
        	System.out.println("Tamnho: "+deque.tamanho());
        	System.out.println("Vazia: "+deque.isEmpty());
		
		System.out.println();
        	System.out.println("Existe \"Ff\": "+deque.existeDado(p6));
        	System.out.println("Existe \"Aa\": "+deque.existeDado(p1));
        	System.out.println("Existe \"Cc\": "+deque.existeDado(p3));
		
		System.out.println();
        	System.out.println("Recupera Início. "+deque.RecuperarInicio());
        	System.out.println("Recupera Fim. "+deque.RecuperarFim());
		
		System.out.println();
        	System.out.println("Alterar Início.");
        	deque.AlterarInicio(p6);
        	System.out.println(deque);
        	System.out.println("Alterar Fim.");
        	deque.AlterarFim(p7);
        	System.out.println(deque);
		
		System.out.println();
        	System.out.println("Remove Início.");
        	deque.RemoverInicio();
        	System.out.println(deque);
        	System.out.println("Remove Fim.");
        	deque.RemoverFim();
        	System.out.println(deque);
		
		System.out.println();
        	System.out.println("Método Limpa.");
        	deque.limpa();
        	System.out.println(deque);
        	System.out.println("Tamnho: "+deque.tamanho());
        	System.out.println("Vazia: "+deque.isEmpty());
	}
}
