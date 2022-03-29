
public class ListaEstatica<T> implements Lista<T> {
	private T[] info;
	private int tamanho;

	@SuppressWarnings("unchecked")
	public ListaEstatica() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}

	@SuppressWarnings("unchecked")
	private void redimensionar() {
		T[] novo = (T[]) new Object[tamanho + 10];
		for (int i = 0; i < tamanho; i++) {
			novo[i] = this.info[i];
			tamanho++;
		}
		info = novo;
	}

	@Override
	public void inserir(T valor) {
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
	public int buscar(T valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i].equals(valor)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i].equals(valor)) {
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
	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public Lista<T> dividir() {
		Lista<T> novaLista = new ListaEstatica<>();
		int meiaLista = this.tamanho / 2;

		for (int i = meiaLista; i < this.tamanho; i++) {
			novaLista.inserir(info[i]);
		}

		this.tamanho = meiaLista;
		return novaLista;
	}

	@Override
	public Lista<T> copiar() {
		Lista<T> novaLista = new ListaEstatica<>();

		for (int i = 0; i < this.tamanho; i++) {
			novaLista.inserir(info[i]);
		}

		return novaLista;
	}

	@Override
	public T pegar(int posicao) {
		return info[posicao];
	}
}