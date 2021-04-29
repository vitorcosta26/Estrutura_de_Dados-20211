package deque;

public class Deque<T> {
	private Celula primeira;
	private Celula ultima;
	private int quantidadeElementos;
	
	public Deque() {
		super();
		this.primeira = null;
		this.ultima = null;
		this.quantidadeElementos = 0;
	}
	
	public void InserirNoInicio(T elemento) {
		Celula nova = new Celula(elemento);
		if (this.quantidadeElementos == 0) {
			this.primeira = nova;
			this.ultima = nova;
		} else {
			nova.setProximo(this.primeira);
			this.primeira = nova;
		}
		this.quantidadeElementos ++;
	}
	
	public void InserirNoFim(T elemento) {
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
			throw new ArrayIndexOutOfBoundsException("A fila está vazia!");
		} else {
			Iterador<Object> iterador = new Iterador<Object>(this.primeira);
			while (iterador.hasNext()) {
				if (iterador.next().equals(elemento)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		return this.quantidadeElementos == 0;
	}
	
	@SuppressWarnings("unchecked")
	public T RecuperarInicio() {
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A fila está vazia!");
		} else {
			return (T) this.primeira.getElemento();
		}
	}
	
	@SuppressWarnings("unchecked")
	public T RecuperarFim() {
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A fila está vazia!");
		} else {
			return (T) this.ultima.getElemento();
		}
	}
	
	public void AlterarInicio(T elemento) {
		Celula nova = new Celula(elemento);
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A fila está vazia!");
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
	
	public void AlterarFim(T elemento) {
		Celula nova = new Celula(elemento);
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A fila está vazia!");
		} else if (this.tamanho() == 1) {
			this.primeira.setProximo(null);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula anterior = this.recuperaCelula(quantidadeElementos - 2);
			this.ultima = nova;
			anterior.setProximo(this.ultima);
			this.ultima.setProximo(null);
		}
	}
	
	public void RemoverInicio() {
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A fila está vazia!");
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
	
	public void RemoverFim() {
		if (this.tamanho() == 0) {
			throw new ArrayIndexOutOfBoundsException("A fila está vazia!");
		} else if (this.tamanho() == 1) {
			this.primeira = null;
			this.ultima = null;
			this.quantidadeElementos = 0;
		} else {
			this.ultima = this.recuperaCelula(this.quantidadeElementos - 2);
			this.ultima.setProximo(null); ;
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
	
	// Métodos adicionais.
	
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
	
	private Celula recuperaCelula(int posicao) {
		Iterador<Object> iterador = new Iterador<Object>(this.primeira);
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
	}
}
