public class ListaEncadeada<T> implements Lista<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElem;

	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElem++;
	}

	@Override
	public String exibir() {
		String resultado = "[";
		NoLista<T> p = primeiro;
		while (p != null) {
			resultado += p.getInfo() + ", ";
			p = p.getProximo();
		}
		return resultado + "]";
	}

	@Override
	public int buscar(T valor) {
		int posicao = 0;
		NoLista<T> p = primeiro;
		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return posicao;
			}
			p = p.getProximo();
			posicao++;
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;

		while (!p.equals(null) && !p.getInfo().equals(valor)) {
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) { // significa que encontrou
			if (anterior.equals(null)) {
				primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
		}
		if (ultimo.equals(p)) {
			ultimo = anterior;
		}
	}

	@Override
	public boolean estaVazia() {
		return (primeiro.equals(null));
	}

	@Override
	public Lista<T> copiar() {
		Lista<T> copia = new ListaEncadeada<>();
		NoLista<T> p = primeiro;
		while (p != null) {
			copia.inserir(p.getInfo());
			p = p.getProximo();
		}
		return copia;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for (int indice = 0; indice < outra.getTamanho(); indice++) {
			this.inserir(outra.pegar(indice));
		}

	}

	@Override
	public int getTamanho() {
		return this.qtdElem;
	}

	@Override
	public Lista<T> dividir() {
		ListaEncadeada<T> outraLista = new ListaEncadeada<>();
		int meiaLista = this.getTamanho() / 2;
		int contador = 1;
		NoLista<T> p = primeiro;
		
		while (p != null) {
			if (contador > meiaLista) {
				outraLista.inserir(p.getInfo());
			} else if (contador == meiaLista) {
				this.ultimo = p;
			}
			contador++;
			p = p.getProximo();
		}
		ultimo.setProximo(null);
		this.qtdElem = meiaLista;
		return outraLista;
	}

	@Override
	public T pegar(int posicao) {
		if (posicao < 0 || posicao >= this.getTamanho()) {
			throw new IndexOutOfBoundsException("Posição = :" + posicao + " Tamanho = " + qtdElem);
		}
		int contador = 0;
		NoLista<T> noLista = primeiro;
		while (noLista != null) {
			if (contador == posicao) {
				return noLista.getInfo();
			}
			contador++;
			noLista = noLista.getProximo();
		}
		return null;//Nunca deveria chegar aqui
	}

}