package lista_circular;

import java.util.Iterator;

public class Iterador<T> implements Iterator<Object> {
	
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
		if(atual!=null){
            return true;
        } else {
            return false;
        }
	}

	@Override
	public Object next() {
		@SuppressWarnings("unchecked")
		T elemento = (T) this.atual.getElemento();
		this.atual = this.atual.getProxima();
		return elemento;
	}
}
