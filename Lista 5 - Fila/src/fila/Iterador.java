package fila;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class Iterador<T> implements Iterator {
	private Celula atual;
	
	public Iterador(Celula atual) {
		super();
		this.atual = atual;
	}
	
	public Celula getAtual() {
		return atual;
	}
	
	@Override
	public boolean hasNext() {
		return this.atual != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object next() {
		T elemento = (T) atual.getElemento();
		this.atual = atual.getProximo();
		return elemento;
	}
}
