package fila;

public class Fila<T> {
	private Celula primeira;
	private Celula ultima;
	private int quantidadeElementos;
	
	public Fila() {
		super();
		this.primeira = null;
		this.ultima = null;
		this.quantidadeElementos = 0;
	}
	
	public void Inserir(T elemento) {
		Celula nova = new Celula(elemento);
		if (this.tamanho() == 0) {
			this.primeira = nova;
			this.ultima = nova;
		} else {
			this.ultima.setProximo(nova);
			this.ultima = nova;
		}
		this.quantidadeElementos ++;
	}
	
	public boolean existeDado(T elemento) {
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
		} else {
			return this.primeira == elemento;
		}
	}
	
	public boolean isEmpty() {
		return this.quantidadeElementos == 0;
	}
	
	@SuppressWarnings("unchecked")
	public T Recuperar() {
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
		} else {
			return (T) this.primeira.getElemento();
		}
	}
	
	public void Alterar(T elemento) {
		Celula nova = new Celula(elemento);
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
		} else if (this.tamanho() == 1) {
			this.primeira.setProximo(null);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula proxima = this.primeira.getProximo();
			this.primeira.setProximo(null);
			this.primeira = nova;
			this.primeira.setProximo(proxima);
		}
	}
	
	public void Remover() {
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
		} else if (this.tamanho() == 1) {
			this.primeira = null;
			this.ultima = null;
			this.quantidadeElementos = 0;
		} else {
			Celula proxima = this.primeira.getProximo();
			this.primeira.setProximo(null);
			this.primeira = proxima;
			this.quantidadeElementos --;
		}
	}
	
	public int tamanho() {
		return this.quantidadeElementos;
	}
	
	public void limpa() {
		this.primeira = null;
		this.quantidadeElementos = 0;
	}

	@Override
	public String toString() {
		if (this.isEmpty()) return "[]";
		Iterador<Object> iterador = new Iterador<>(this.primeira);
		String filaToString = "[" + iterador.next().toString();
		while (iterador.hasNext()) {
			filaToString += ", " + iterador.next().toString();
		}
		filaToString += "]";
		return filaToString;
	}
}
