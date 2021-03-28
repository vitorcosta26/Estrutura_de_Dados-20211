package lista_circular;

public class ListaDuplamenteEncadeada<T> {
	private Celula inicio;
	private Celula fim;
	private int quantidadeElementos;
	
	public ListaDuplamenteEncadeada() {
		super();
		this.inicio = null;
		this.fim = null;
		this.quantidadeElementos = 0;
	}
	
	public void adicionaInicio(T elemento) {
		Celula nova = new Celula(elemento);
		if (this.quantidadeElementos == 0) {
			this.inicio = nova;
			this.fim = nova;
		} else {
			nova.setProxima(this.inicio);
			nova.setAnterior(this.fim);
			this.inicio = nova;
			Celula proxima = this.inicio.getProxima();
			proxima.setAnterior(this.inicio);
		}
		this.quantidadeElementos ++;
	}
	
	public void removeFim() {
		if (this.quantidadeElementos == 0) {
			throw new ArrayIndexOutOfBoundsException("Lista vazia!");
		} else if (this.quantidadeElementos == 1){
			this.inicio = null;
			this.fim = null;
			this.quantidadeElementos = 0;
		} else {
			Celula atual = this.fim.getAnterior();
			Celula anterior = this.fim.getAnterior().getAnterior();
			Celula proxima = this.fim.getProxima();
			atual.setAnterior(anterior);
			atual.setProxima(proxima);
			this.inicio.setAnterior(atual);
			this.fim = atual;
			this.quantidadeElementos --;
		}
	}
	
	public void removeDuplicados() {
		if (this.quantidadeElementos == 0) {
			throw new ArrayIndexOutOfBoundsException("Lista vazia!");
		} else {
			Iterador<T> iterador1 = new Iterador<>(this.inicio);
            int posicao1 = 0;
            while (iterador1.hasNext() && posicao1 <= this.quantidadeElementos) {
            	Iterador<T> iterador2 = new Iterador<>(this.inicio);
            	int posicao2 = 0;
            	boolean duplicado = false;
            	while (iterador2.hasNext() && posicao2 < this.quantidadeElementos) {
            		if(iterador2.getAtual().getElemento().equals(iterador1.getAtual().getElemento()) && posicao1 != posicao2) {
            			removePosicao(posicao2);
            			duplicado = true;
            			break;
            		}
            		iterador2.next();
            		posicao2 ++;
            	}
            	if (duplicado == false) {
            		iterador1.next();
            		posicao1 ++;
            	}
            }
		}
	}
	
	//Métodos adicionais.
	
	private void removePosicao(int posicao) {
		Iterador<T> iterador = new Iterador<>(this.inicio);
		int indice = 0;
		while (iterador.hasNext()) {
			if (indice < posicao - 1) {
				iterador.next();
				indice ++;
			} else {
				Celula atual = iterador.getAtual().getProxima();
				Celula anterior = atual.getAnterior();
				Celula proxima = atual.getProxima();
				iterador.getAtual().getProxima().setAnterior(anterior);
				iterador.getAtual().setProxima(proxima);
				atual.setAnterior(null);
				atual.setProxima(null);
				this.quantidadeElementos --;
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		if (this.quantidadeElementos == 0) return "[]";
		Iterador<T> iterador = new Iterador<>(this.inicio);
		String listaToString = "[" + iterador.next();
		while (iterador.hasNext()) {
			listaToString += ", " + iterador.next();
		}
		listaToString += "]";
		return listaToString;
	}
}
