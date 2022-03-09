
public class ListaEstatica {
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

	public void inserir(int valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}

	public String exibir() {
		String resultado = "[";
		for (int i = 0; i < tamanho; i++) {
			resultado += info[i] + ", ";
		}
		return resultado + "]";
	}

	public int buscar(int valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}

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

	public boolean estaVazia() {
		if (tamanho > 0) {
			return false;
		} else {
			return true;
		}
	}

	public void concatenar(ListaEstatica outra) {
		// Extra
	}

	public ListaEstatica dividir() {
		// Extra
		return null;
	}

	public ListaEstatica copiar() {
		// Extra
		return null;
	}
}
