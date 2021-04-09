package prova;

public class ListaDuplamenteEncadeada<T> {
	private CelulaDupla inicio;
	private CelulaDupla fim;
	private int quantidadeElementos;
	
	public ListaDuplamenteEncadeada() {
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
				CelulaDupla anterior = this.recuperaCelulaDupla(posicao - 1);
				CelulaDupla proxima = this.recuperaCelulaDupla(posicao);
				CelulaDupla nova = new CelulaDupla(anterior, proxima, elemento);
				anterior.setProxima(nova);
				proxima.setAnterior(nova);
				this.quantidadeElementos ++;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("A posicao indicada não existe!\nA lista vai de 0 até "+this.quantidadeElementos+".");
			}
		}
	}
	
	public void adicionaInicio(T elemento) {
		CelulaDupla nova = new CelulaDupla(elemento);
		if (this.quantidadeElementos == 0) {
			this.inicio = nova;
			this.fim = nova;
		} else {
			nova.setProxima(this.inicio);
			this.inicio.setAnterior(nova);
			this.inicio = nova;
		}
		this.quantidadeElementos ++;
	}
	
	public void adicionaFim(T elemento) {
		CelulaDupla nova = new CelulaDupla(elemento);
		if (this.quantidadeElementos == 0) {
			this.inicio = nova;
			this.fim = nova;
		} else {
			this.fim.setProxima(this.fim);
			this.fim.setProxima(nova);
			this.fim = nova;
		}
		this.quantidadeElementos ++;
	}
	
	public boolean existeDado(T elemento) {
		if (this.quantidadeElementos != 0) {
			Iterador<CelulaDupla> iterador = new Iterador<>(this.inicio);
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
			CelulaDupla celula = this.recuperaCelulaDupla(posicao);
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
				CelulaDupla anterior = this.recuperaCelulaDupla(posicao - 1);
				CelulaDupla proxima = this.recuperaCelulaDupla(posicao + 1);
				anterior.setProxima(proxima);
				proxima.setAnterior(anterior);
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
			this.inicio = this.inicio.getProxima();
			this.quantidadeElementos --;
		} catch (NullPointerException e) {
			System.out.println("A lista está vazia!");
		}
	}
	
	public void removeFim() {
		try {
			this.verificaPosicao(this.quantidadeElementos - 1);
			this.fim = this.recuperaCelulaDupla(this.quantidadeElementos - 1);
			this.fim.setProxima(null);
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
		Iterador<CelulaDupla> iterador = new Iterador<>(inicio);
		String listaToString = "[" + iterador.next();
		while (iterador.hasNext()) {
			listaToString += ", " + iterador.next();
		}
		listaToString += "]";
		return listaToString;
	}
	
	private CelulaDupla recuperaCelulaDupla(int posicao) {
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