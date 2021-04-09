package lista_duplamente_encadeada_no_cabeca;

public class ListaDuplamenteEncadeadaNoCabeca<T> {
	private CelulaDupla noCabeca;
	private CelulaDupla inicio;
	private CelulaDupla fim;
	private int quantidadeElementos;
	
	public ListaDuplamenteEncadeadaNoCabeca() {
		super();
		this.noCabeca = new CelulaDupla(null);
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
				System.out.println("A posicao indicada n�o existe!\nA lista vai de 0 at� "+this.quantidadeElementos+".");
			}
		}
	}
	
	public void adicionaInicio(T elemento) {
		CelulaDupla nova = new CelulaDupla(elemento);
		if (this.quantidadeElementos == 0) {
			this.inicio = nova;
			this.fim = nova;
			this.inicio.setAnterior(this.noCabeca);
			this.fim.setProxima(this.noCabeca);
			this.noCabeca.setAnterior(this.fim);
			this.noCabeca.setProxima(this.inicio);
		} else {
			this.noCabeca.setAnterior(this.fim);
			this.noCabeca.setProxima(nova);
			nova.setAnterior(this.noCabeca);
			nova.setProxima(this.inicio);
			this.inicio.setAnterior(nova);
			this.inicio = nova;
			CelulaDupla proxima = this.inicio.getProxima();
			proxima.setAnterior(this.inicio);
		}
		this.quantidadeElementos ++;
	}
	
	public void adicionaFim(T elemento) {
		CelulaDupla nova = new CelulaDupla(elemento);
		if (this.quantidadeElementos == 0) {
			this.inicio = nova;
			this.fim = nova;
			this.inicio.setAnterior(this.noCabeca);
			this.fim.setProxima(this.noCabeca);
			this.noCabeca.setAnterior(this.fim);
			this.noCabeca.setProxima(this.inicio);
		} else {
			this.noCabeca.setAnterior(nova);
			this.noCabeca.setProxima(this.inicio);
			nova.setAnterior(this.fim);
			nova.setProxima(this.noCabeca);
			this.fim.setProxima(nova);
			this.fim = nova;
		}
		this.quantidadeElementos ++;
	}
	
	public boolean existeDado(T elemento) {
		if (this.quantidadeElementos != 0) {
			Iterador<CelulaDupla> iterador = new Iterador<>(this.inicio);
			int contador = 0;
			while (iterador.hasNext()) {
				if (contador != this.quantidadeElementos - 1) {
					contador ++;
					if (iterador.next().equals(elemento)) {
						return true;
					}
				} else {
					break;
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
			System.out.println("A lista est� vazia!");
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posicao indicada n�o existe!\nA lista vai de 0 at� "+this.quantidadeElementos+".");
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
				System.out.println("A lista est� vazia!");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("A posicao indicada n�o existe!\nA lista vai de 0 at� "+this.quantidadeElementos+".");
			}
		}
	}
	
	public void removeInicio() {
		try {
			this.verificaPosicao(0);
			this.inicio = this.inicio.getProxima();
			this.inicio.setAnterior(this.noCabeca);
			this.noCabeca.setProxima(this.inicio);
			this.quantidadeElementos --;
		} catch (NullPointerException e) {
			System.out.println("A lista est� vazia!");
		}
	}
	
	public void removeFim() {
		try {
			this.verificaPosicao(this.quantidadeElementos - 1);
			this.fim = this.recuperaCelulaDupla(this.quantidadeElementos - 2);
			this.fim.setProxima(this.noCabeca);
			this.noCabeca.setAnterior(this.fim);
			this.quantidadeElementos --;
		} catch (NullPointerException e) {
			System.out.println("A lista est� vazia!");
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
	
	//M�dtodos adicionais.
	
	@Override
	public String toString() {
		if (this.quantidadeElementos == 0) return "[]";
		Iterador<CelulaDupla> iterador = new Iterador<>(inicio);
		int contador = 0;
		String listaToString = "[" + iterador.next();
		while (iterador.hasNext()) {
			if (contador != this.quantidadeElementos - 1) {
				listaToString += ", " + iterador.next();
				contador ++;
			} else {
				break;
			}
		}
		listaToString += "]";
		return listaToString;
	}
	
	private CelulaDupla recuperaCelulaDupla(int posicao) {
		try {
			this.verificaPosicao(posicao);
			Iterador<Object> iterador = new Iterador<Object>(this.inicio);
			int contador = 0;
			int indice = 0;
			while (iterador.hasNext()) {
				if (contador != this.quantidadeElementos - 1) {
					contador ++;
					if (indice != posicao) {
						iterador.next();
						indice ++;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			return iterador.getAtual();
		} catch (NullPointerException e) {
			System.out.println("A lista est� vazia!");
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posicao indicada n�o existe!\nA lista vai de 0 at� "+this.quantidadeElementos+".");
			return null;
		}
	}
	
	private void verificaPosicao(int posicao){
		if (this.quantidadeElementos == 0){
			throw new NullPointerException("Lista vazia!");
		}
		if ((posicao < 0 || posicao > this.quantidadeElementos)){
			throw new ArrayIndexOutOfBoundsException("Posi��o Inv�lida!");
		}
	}

	private void verificaPosicaoAdicao(int posicao){
		if ((posicao < 0 || posicao > this.quantidadeElementos)){
			throw new ArrayIndexOutOfBoundsException("Posi��o Inv�lida!");
		}
	}
	
	public String imprimeNo() {
		if (this.quantidadeElementos == 0) return "Lista v�zia!";
		String anterior = this.noCabeca.getAnterior().getElemento().toString();
		String proxima = this.noCabeca.getProxima().getElemento().toString();
		return "Anterior: "+anterior+"\nProxima: "+proxima;
	}
}
