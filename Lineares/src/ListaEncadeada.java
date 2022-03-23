public class ListaEncadeada implements Lista {
	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdElem;

	@Override
	public void inserir(int valor) {
		NoLista novo = new NoLista();
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
		NoLista p = primeiro;
		while (p != null) {
			resultado += p.getInfo() + ", ";
			p = p.getProximo();
		}
		return resultado + "]";
	}

	@Override
	public int buscar(int valor) {
		int posicao = 0;
		NoLista p = primeiro;
		while (p != null) {
			if (p.getInfo() == valor) {
				return posicao;
			}
			p = p.getProximo();
			posicao++;
		}
		return -1;
	}

	@Override
	public void retirar(int valor) {
		NoLista anterior = null;
		NoLista p = primeiro;

		while (p != null && p.getInfo() != valor) {
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) { // significa que encontrou
			if (anterior == null) {
				primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
		}
		if (ultimo == p) {
			ultimo = anterior;
		}
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public Lista copiar() {
		Lista copia = new ListaEncadeada();
		NoLista p = primeiro;
		while (p != null) {
			copia.inserir(p.getInfo());
			p = p.getProximo();
		}
		return copia;
	}

	@Override
	public void concatenar(Lista outra) {
		for (int indice = 0; indice < outra.getTamanho(); indice++) {
			this.inserir(outra.pegar(indice));
		}

	}

	@Override
	public int getTamanho() {
		return this.qtdElem;
	}

	@Override
	public Lista dividir() {
		ListaEncadeada outraLista = new ListaEncadeada();
		int meiaLista = this.getTamanho() / 2;
		int contador = 1;
		NoLista p = primeiro;
		
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
	public int pegar(int posicao) {
		if (posicao < 0 || posicao >= this.getTamanho()) {
			throw new IndexOutOfBoundsException("Posição = :" + posicao + " Tamanho = " + qtdElem);
		}
		int contador = 0;
		NoLista noLista = primeiro;
		while (noLista != null) {
			if (contador == posicao) {
				return noLista.getInfo();
			}
			contador++;
			noLista = noLista.getProximo();
		}
		return -1;//Nunca deveria chegar aqui
	}

}