package questao_extra;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class Iterador<T> implements Iterator {
	private CelulaDupla atual;

	public Iterador(CelulaDupla atual) {
		super();
		this.atual = atual;
	}

	public CelulaDupla getAtual() {
		return atual;
	}

	@Override
	public boolean hasNext() {
		return this.atual != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object next() {
		T elemento = (T)  atual.getElemento();
		this.atual = this.atual.getProxima();
		return elemento;
	}
	
	@SuppressWarnings("unchecked")
	public Object previous() {
		T elemento = (T)  atual.getElemento();
		this.atual = this.atual.getAnterior();
		return elemento;
	}
}
