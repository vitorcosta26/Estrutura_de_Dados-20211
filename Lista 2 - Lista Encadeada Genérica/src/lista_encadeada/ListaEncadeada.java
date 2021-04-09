package lista_encadeada;

public class ListaEncadeada<T> {
	private Celula inicio;
	private Celula fim;
	private int quantidadeElementos;
	
	public ListaEncadeada() {
		super();
		this.inicio = null;
		this.fim = null;
		this.quantidadeElementos = 0;
	}
	
	public void adiciona(T elemento, int posicao) {
		if (posicao == 0) {
			this.adicionaInicio(elemento);
		} else if (posicao == this.quantidadeElementos - 1) {
			this.adicionaFim(elemento);
		} else {
			try {
				this.verificaPosicaoAdicao(posicao);
				Celula anterior = this.recuperaCelula(posicao - 1);
				Celula proxima = this.recuperaCelula(posicao);
				Celula nova = new Celula(proxima, elemento);
				anterior.setProximo(nova);
				this.quantidadeElementos ++;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
			}
		}
	}
	
	public void adicionaInicio(T elemento) {
		Celula nova = new Celula(elemento);
		if (this.quantidadeElementos == 0) {
			this.inicio = nova;
			this.fim = nova;
		} else {
			nova.setProximo(this.inicio);
			this.inicio = nova;
		}
		this.quantidadeElementos ++;
	}
	
	public void adicionaFim(T elemento) {
		Celula nova = new Celula(elemento);
		if (this.quantidadeElementos == 0) {
			this.inicio = nova;
			this.fim = nova;
		} else {
			this.fim.setProximo(nova);
			this.fim = nova;
		}
		this.quantidadeElementos ++;
	}
	
	public boolean existeDado(T elemento) {
		if (this.quantidadeElementos != 0) {
			Iterador<Object> iterador = new Iterador<Object>(this.inicio);
			while (iterador.hasNext()) {
				if (iterador.next().equals(elemento)) {
					return true;
				}
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T recupera(int posicao) {
		try {
			this.verificaPosicao(posicao);
			Celula celula = this.recuperaCelula(posicao);
			return (T) celula.getElemento();
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
			return null;
		}
	}
	
	public void remove(int posicao) {
		if (posicao == 0) {
			this.removeInicio();
		} else if (posicao == this.quantidadeElementos - 1) {
			this.removeFim();
		} else {
			try {
				this.verificaPosicao(posicao);
				Celula anterior = this.recuperaCelula(posicao - 1);
				Celula proxima = this.recuperaCelula(posicao + 1);
				anterior.setProximo(proxima);
				this.quantidadeElementos --;
			} catch (NullPointerException e) {
				System.out.println("A lista está vazia!");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
			}
		}
	}
	
	public void removeInicio() {
		try {
			this.verificaPosicao(0);
			this.inicio = this.inicio.getProximo();
			this.quantidadeElementos --;
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
		}
	}
	
	public void removeFim() {
		try {
			this.verificaPosicao(this.quantidadeElementos - 1);
			this.fim = this.recuperaCelula(this.quantidadeElementos - 2);
			this.fim.setProximo(null);
			this.quantidadeElementos --;
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
		}
	}
	
	public int tamanho() {
		return this.quantidadeElementos;
	}
	
	public void limpa() {
		this.inicio = null;
		this.fim = null;
		this.quantidadeElementos = 0;
	}
	
	//Médtodos adicionais.
	
	@Override
	public String toString() {
		if (this.quantidadeElementos == 0) return "[]";
		Iterador<Object> iterador = new Iterador<Object>(inicio);
		String listaToString = "[" + iterador.next().toString();
		while (iterador.hasNext()) {
			listaToString += ", " + iterador.next().toString();
		}
		listaToString += "]";
		return listaToString;
	}
	
	private Celula recuperaCelula(int posicao) {
		try {
			this.verificaPosicao(posicao);
			Iterador<Object> iterador = new Iterador<Object>(this.inicio);
			int indice = 0;
			while (iterador.hasNext()) {
				if (indice != posicao) {
					iterador.next();
					indice ++;
				} else {
					break;
				}
			}
			return iterador.getAtual();
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
			return null;
		}
	}
	
	private void verificaPosicao(int posicao){
		if (this.quantidadeElementos == 0){
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
