package lista_simples;

import java.util.Iterator;

public class Iterador<T> implements Iterator<Object> {
	
	private T[] itens;
	private int posicao = 0;
	
	public Iterador(T[] itens) {
		super();
		this.itens = itens;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	@Override
	public boolean hasNext() {
		return posicao >= 0 && posicao < itens.length && itens[posicao] != null;
	}

	@Override
	public Object next() {
		Object item = itens[posicao];
		posicao ++;
		return item;
	}
	
	public Object previous() {
		Object item = itens[posicao];
		posicao --;
		return item;
	}
}
