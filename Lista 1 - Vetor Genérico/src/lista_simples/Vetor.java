package lista_simples;

public class Vetor<T> {
	private T[] vetor;
	private int quantidadeElementos = 0;
	
	@SuppressWarnings("unchecked")
	public Vetor() {
		vetor = (T[]) new Object[1];
	}
	
	@SuppressWarnings("unchecked")
	public Vetor(int tamanho) {
		vetor = (T[]) new Object[tamanho];
	}
	
	public void adiciona(T elemento, int posicao) {
		try {
			this.verificaPosicaoAdicao(posicao);
			this.redimensiona();
			Iterador<T> iterador =  new Iterador<>(this.vetor);
			iterador.setPosicao(this.quantidadeElementos - 1);
			while (iterador.hasNext()) {
				this.vetor[iterador.getPosicao() + 1] = this.vetor[iterador.getPosicao()];
				if (iterador.getPosicao() < posicao) {
					break;
				}
				iterador.previous();
			}
			this.vetor[posicao] = elemento;
			this.quantidadeElementos ++;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
		}
	}
	
	public void adicionaInicio(T elemento) {
		this.redimensiona();
		Iterador<T> iterador =  new Iterador<>(this.vetor);
		iterador.setPosicao(this.quantidadeElementos - 1);
		while (iterador.hasNext()) {
			this.vetor[iterador.getPosicao() + 1] = this.vetor[iterador.getPosicao()];
			iterador.previous();
		}
		this.vetor[0] = elemento;
		this.quantidadeElementos ++;
	}
	
	public void adicionaFim(T elemento) {
		this.redimensiona();
		this.vetor[this.quantidadeElementos] = elemento;
		this.quantidadeElementos ++;
	}
	
	public boolean existeDado(int posicao) {
		try {
			this.verificaPosicao(posicao);
			return this.vetor[posicao] != null;
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
			return false;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
			return false;
		}
	}
	
	public T recupera(int posicao) {
		try {
			this.verificaPosicao(posicao);
			return this.vetor[posicao];
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
			return null;
		}
	}
	
	public boolean vazio() {
		return this.quantidadeElementos == 0;
	}
	
	public void remove(int posicao) {
		try {
			this.verificaPosicao(posicao);
			Iterador<T> iterador =  new Iterador<>(this.vetor);
			iterador.setPosicao(posicao);
			while (iterador.hasNext()) {
				this.vetor[iterador.getPosicao()] = this.vetor[iterador.getPosicao() + 1];
				iterador.next();
			}
			this.removeFim();
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
		}
	}
	
	public void removeInicio() {
		try {
			this.verificaPosicao(0);
			Iterador<T> iterador =  new Iterador<>(this.vetor);
			while (iterador.hasNext()) {
				this.vetor[iterador.getPosicao()] = this.vetor[iterador.getPosicao() + 1];
				iterador.next();
			}
			this.removeFim();
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
		}
	}
	
	public void removeFim() {
		try {
			this.verificaPosicao(this.quantidadeElementos - 1);
			this.vetor[this.quantidadeElementos - 1] = null;
			this.quantidadeElementos --;
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
		}
	}
	
	public int tamanho() {
		return this.quantidadeElementos;
	}
	
	public void limpa() {
		if (this.vazio()) {
			System.out.println("A lista está vazia!");
		} else {
			Iterador<T> iterador =  new Iterador<>(this.vetor);
			while (iterador.hasNext()) {
				this.vetor[iterador.getPosicao()] = null;
				iterador.next();
			}
			this.quantidadeElementos = 0;
		}
	}
	
	public void redimensiona() {
		if (this.quantidadeElementos == this.vetor.length) {
			@SuppressWarnings("unchecked")
			T[] vetorAuxiliar = (T[]) new Object[this.quantidadeElementos * 2];
			Iterador<T> iterador =  new Iterador<>(this.vetor);
			while (iterador.hasNext()) {
				vetorAuxiliar[iterador.getPosicao()] = this.recupera(iterador.getPosicao());
				iterador.next();
			}
			this.vetor = vetorAuxiliar;
		}
	}
	
	//Médtodos adicionais.
	
	@Override
	public String toString() {
		if (this.vazio()) return "[]";
		Iterador<T> iterador = new Iterador<>(this.vetor);
		String vetorToString = "[" + iterador.next();
		while (iterador.hasNext()) {
			vetorToString += ", " + iterador.next();
		}
		vetorToString += "]";
		return vetorToString;
	}
	
	private void verificaPosicao(int posicao){
		if (this.vazio()){
			throw new NullPointerException("Lista vazia!");
		}
		if ((posicao < 0 || posicao > this.quantidadeElementos)){
			throw new ArrayIndexOutOfBoundsException("Posição Inválida!");
		}
	}

	private void verificaPosicaoAdicao(int posicao){
		if ((posicao < 0 || posicao > this.quantidadeElementos)){
			throw new ArrayIndexOutOfBoundsException("Posição Inválida!");
		}
	}
}
