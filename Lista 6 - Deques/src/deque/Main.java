package deque;

public class Main {

	public static void main(String[] args) {
		Deque<Pessoa> deque = new Deque<>();
		System.out.println(deque);
        System.out.println(deque.tamanho());
        System.out.println(deque.isEmpty());
        
        Pessoa p1 = new Pessoa("Aa");
        Pessoa p2 = new Pessoa("Bb");
        Pessoa p3 = new Pessoa("Cc");
        Pessoa p4 = new Pessoa("DD");
        Pessoa p5 = new Pessoa("Ee");
        Pessoa p6 = new Pessoa("Ff");
        Pessoa p7 = new Pessoa("Gg");
        
        System.out.println();
        deque.InserirNoInicio(p3);
        deque.InserirNoFim(p4);
        System.out.println(deque);
        System.out.println(deque.tamanho());
        deque.InserirNoInicio(p2);
        deque.InserirNoFim(p5);
        System.out.println(deque);
        System.out.println(deque.tamanho());
        deque.InserirNoInicio(p1);
        System.out.println(deque);
        System.out.println(deque.tamanho());
        System.out.println(deque.isEmpty());
        
        System.out.println();
        System.out.println(deque.existeDado(p6));
        System.out.println(deque.existeDado(p1));
        System.out.println(deque.existeDado(p3));
        
        System.out.println();
        System.out.println(deque.RecuperarInicio());
        System.out.println(deque.RecuperarFim());
        
        System.out.println();
        deque.AlterarInicio(p6);
        deque.AlterarFim(p7);
        System.out.println(deque);
        
        System.out.println();
        deque.RemoverInicio();
        deque.RemoverFim();
        System.out.println(deque);
        
        System.out.println();
        deque.limpa();
        System.out.println(deque);
	}
}
