package pilha;

public class Pilha<T> {
	private Celula topo;
	private int quantidadeElementos;
	
	public Pilha() {
		super();
		this.topo = null;
		this.quantidadeElementos = 0;
	}
	
	public void Push(T elemento) {
		Celula nova = new Celula(elemento);
		if (this.isEmpty()) {
			this.topo = nova;
		} else {
			nova.setAnterior(this.topo);
			this.topo = nova;
		}
		this.quantidadeElementos ++;
	}
	
	public boolean existeDado(T elemento) {
		if (this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("A fila est� vazia!");
		} else {
			return this.topo.getElemento() == elemento;
		}
	}
	
	public boolean isEmpty() {
		return this.topo == null;
	}
	
	@SuppressWarnings("unchecked")
	public T Top(){
		if(this.isEmpty()){
            throw new RuntimeException("A pilha está vazia!");
        }
        return (T) this.topo.getElemento();
    }
	
	public void Pull(T elemento) {
		this.Pop();
		this.Push(elemento);
	}
	
	public void Pop() {
		if (this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("A pilha está vazia!");
		} else if (this.quantidadeElementos == 1) {
			this.topo = null;
			this.quantidadeElementos = 0;
		} else {
			Celula anterior = this.topo.getAnterior();
			this.topo.setAnterior(null);
			this.topo = anterior;
			this.quantidadeElementos --;
		}
	}
	
	public int tamanho() {
		return this.quantidadeElementos;
	}
	
	public void limparPilha() {
		if (this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("A pilha está vazia!");
		} else {
			this.topo = null;
			this.quantidadeElementos = 0;
		}
	}

	@Override
	public String toString() {
		if (this.isEmpty()) return "[]";
		Iterador<Object> iterador = new Iterador<>(this.topo);
		String pilhaToString = "[" + iterador.next().toString();
		while (iterador.hasNext()) {
			pilhaToString += ", " + iterador.next().toString();
		}
		pilhaToString += "]";
		return pilhaToString;
	}
}
