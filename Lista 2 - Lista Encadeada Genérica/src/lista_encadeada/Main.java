package lista_encadeada;

public class Main {

	public static void main(String[] args) {
		ListaEncadeada<Aluno> alunos = new ListaEncadeada<>();
		
		Aluno a1 = new Aluno("Aa", 01);
	    Aluno a2 = new Aluno("BB", 02);
	    Aluno a3 = new Aluno("Cc", 03);
	    Aluno a4 = new Aluno("Dd", 04);
	    Aluno a5 = new Aluno("Ee", 05);
	    Aluno a6 = new Aluno("Ff", 06);
	    Aluno a7 = new Aluno("Gg", 07);
	    
	    System.out.println("Vetor vazio.");
	    System.out.println(alunos);
	    System.out.println("Adiciona Fim.");
	    alunos.adicionaFim(a3);
	    System.out.println(alunos);
	    System.out.println("Adiciona Fim.");
	    alunos.adicionaFim(a5);
	    System.out.println(alunos);
	    System.out.println("Adiciona Fim.");
	    alunos.adicionaFim(a6);
	    System.out.println(alunos);
	    System.out.println("Adiciona Início.");
	    alunos.adicionaInicio(a2);
	    System.out.println(alunos);
	    System.out.println("Adiciona Início.");
	    alunos.adicionaInicio(a1);
	    System.out.println(alunos);
	    System.out.println("Adiciona Índice [3]");
	    alunos.adiciona(a4, 3);
	    System.out.println(alunos);
	    System.out.println();

	    System.out.println("Índice [3] possui dados: "+alunos.existeDado(a3));
	    System.out.println("Índice [7] possui dados: "+alunos.existeDado(a7));
	    System.out.println();

	    System.out.println("Dado no índice [3]: "+alunos.recupera(3));
	    System.out.println("Dado no índice [7]: "+alunos.recupera(7));
	    System.out.println();

	    System.out.println(alunos);
	    System.out.println("Remove Fim.");
	    alunos.removeFim();
	    System.out.println(alunos);
	    System.out.println("Remove Início.");
	    alunos.removeInicio();
	    System.out.println(alunos);
	    System.out.println("Remove Índice [2].");
	    alunos.remove(2);
	    System.out.println(alunos);
	    System.out.println("Remove Índice [6].");
	    alunos.remove(6);
	    System.out.println();

	    System.out.println("Tamanho: "+alunos.tamanho());

	    System.out.println(alunos);
	    System.out.println("Método Limpa.");
	    alunos.limpa();
	    System.out.println(alunos);
	}
}
