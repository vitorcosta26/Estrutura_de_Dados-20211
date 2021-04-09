package prova;

public class CelulaDupla {
	private CelulaDupla anterior;
	private CelulaDupla proxima;
	private Object elemento;
	
	public CelulaDupla() {
		super();
	}

	public CelulaDupla(Object elemento) {
		super();
		this.elemento = elemento;
	}

	public CelulaDupla(CelulaDupla anterior, CelulaDupla proxima, Object elemento) {
		super();
		this.anterior = anterior;
		this.proxima = proxima;
		this.elemento = elemento;
	}

	public CelulaDupla getAnterior() {
		return anterior;
	}

	public void setAnterior(CelulaDupla anterior) {
		this.anterior = anterior;
	}

	public CelulaDupla getProxima() {
		return proxima;
	}

	public void setProxima(CelulaDupla proxima) {
		this.proxima = proxima;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
}
