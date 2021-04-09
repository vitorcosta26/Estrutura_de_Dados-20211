package prova;

public class ListaMusicas<T> extends ListaDuplamenteEncadeada<T> {
	private String nomePlayList;
	private int tempoTotal_;

	public String getNomePlayList() {
		return nomePlayList;
	}

	public void setNomePlayList(String nomePlayList) {
		this.nomePlayList = nomePlayList;
	}
	
	public String tempoTotal() {
		this.tempoTotal_ = 0;
		for (int i = 0; i < this.tamanho(); i++) {
			String musica_ = this.recupera(i).toString();
			String[] musica = musica_.toString().split(",");
			tempoTotal_ += Integer.parseInt(musica[2]);
		}
		return String.format("%d:%02d:%02d", tempoTotal_ / 3600, (tempoTotal_ % 3600) / 60, (tempoTotal_ % 60));
	}
	
	//Incompleto.
	public void ordenarFaixas(int valor) {
		if (valor == 1) {
			for (int i = 0; i < this.tamanho(); i++) {
				String musica_ = this.recupera(i).toString();
				String[] musica = musica_.toString().split(",");
				System.out.println(musica[2]);
			}
		} else if (valor == 2) {
			for (int i = 0; i < this.tamanho(); i++) {
				String musica_ = this.recupera(i).toString();
				String[] musica = musica_.toString().split(",");
				System.out.println(musica[0]);
			}
		}
	}
	
	public void mergeListas(ListaMusicas<T> lista) {
		for (int i = 0; i < lista.tamanho(); i++) {
			this.adicionaFim(lista.recupera(i));
		}
	}
}
