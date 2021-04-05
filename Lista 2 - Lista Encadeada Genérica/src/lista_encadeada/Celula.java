package lista_encadeada;

public class Celula {
	private Celula proximo;
	private Object elemento;
	
	public Celula() {
		super();
	}

	public Celula(Object elemento) {
		super();
		this.elemento = elemento;
	}

	public Celula(Celula proxima, Object elemento) {
		super();
		this.proximo = proxima;
		this.elemento = elemento;
	}

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula nova) {
		this.proximo = nova;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
}
