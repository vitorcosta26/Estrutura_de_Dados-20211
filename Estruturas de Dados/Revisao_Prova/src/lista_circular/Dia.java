package lista_circular;

public class Dia {
	
	private String dia;

	public Dia(String dia) {
		super();
		this.dia = dia;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return this.dia;
	}
}
