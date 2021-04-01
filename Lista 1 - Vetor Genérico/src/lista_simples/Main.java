package lista_simples;

public class Main {

	public static <T> void main(String[] args) {
		Vetor<Aluno> alunos = new Vetor<>();

	    Aluno a1 = new Aluno("Aa", 01);
	    Aluno a2 = new Aluno("BB", 02);
	    Aluno a3 = new Aluno("Cc", 03);
	    Aluno a4 = new Aluno("Dd", 04);
	    Aluno a5 = new Aluno("Ee", 05);
	    Aluno a6 = new Aluno("Ff", 06);
	    
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
	    System.out.println("Adiciona In�cio.");
	    alunos.adicionaInicio(a2);
	    System.out.println(alunos);
	    System.out.println("Adiciona In�cio.");
	    alunos.adicionaInicio(a1);
	    System.out.println(alunos);
	    System.out.println("Adiciona �ndice [3]");
	    alunos.adiciona(a4, 3);
	    System.out.println(alunos);
	    System.out.println();

	    System.out.println("�ndice [3] possui dados: "+alunos.existeDado(3));
	    System.out.println("�ndice [6] possui dados: "+alunos.existeDado(6));
	    System.out.println();

	    System.out.println("Dado no �ndice [3]: "+alunos.recupera(3));
	    System.out.println("Dado no �ndice [6]: "+alunos.recupera(6));
	    System.out.println();

	    System.out.println(alunos);
	    System.out.println("Remove Fim.");
	    alunos.removeFim();
	    System.out.println(alunos);
	    System.out.println("Remove In�cio.");
	    alunos.removeInicio();
	    System.out.println(alunos);
	    System.out.println("Remove �ndice [2].");
	    alunos.remove(2);
	    System.out.println(alunos);
	    System.out.println("Remove �ndice [6].");
	    alunos.remove(6);
	    System.out.println();

	    System.out.println("Tamanho: "+alunos.tamanho());

	    System.out.println(alunos);
	    System.out.println("Vazio: "+alunos.vazio());
	    System.out.println("M�todo Limpa.");
	    alunos.limpa();
	    System.out.println(alunos);
	    System.out.println("Vazio: "+alunos.vazio());
	}
}
