
public class ListaEstatica implements Lista {
	private int[] info;
	private int tamanho;

	public ListaEstatica() {
		info = new int[10];
		tamanho = 0;
	}

	private void redimensionar() {
		int[] novo = new int[tamanho + 10];
		for (int i = 0; i < tamanho; i++) {
			novo[i] = this.info[i];
			tamanho++;
		}
		info = novo;
	}

	@Override
	public void inserir(int valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}

	@Override
	public String exibir() {
		String resultado = "[";
		for (int i = 0; i < tamanho; i++) {
			resultado += info[i] + ", ";
		}
		return resultado + "]";
	}

	@Override
	public int buscar(int valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void retirar(int valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i] == valor) {
				while (i < tamanho) {
					info[i] = info[i + 1];
					i++;
				}
				tamanho--;
			}
		}
	}

	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	@Override
	public int getTamanho() {
		return tamanho;
	}

	@Override
	public void concatenar(Lista outra) {
		// Extra
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public Lista dividir() {
		// Extra
		Lista novaLista = new ListaEstatica();
		int meiaLista = this.tamanho / 2;

		for (int i = meiaLista; i < this.tamanho; i++) {
			novaLista.inserir(info[i]);
		}

		this.tamanho = meiaLista;
		return novaLista;
	}

	@Override
	public Lista copiar() {
		// Extra
		Lista novaLista = new ListaEstatica();

		for (int i = 0; i < this.tamanho; i++) {
			novaLista.inserir(info[i]);
		}

		return novaLista;
	}

	@Override
	public int pegar(int posicao) {
		// TODO Auto-generated method stub
		return info[posicao];
	}
}