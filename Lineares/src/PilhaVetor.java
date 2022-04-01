public class PilhaVetor<T> implements Pilha<T> {
	private T[] info;
	private int limite;
	private int tamanhoAtual;

	@SuppressWarnings("unchecked")
	public PilhaVetor(int limite) {
		this.info = (T[]) new Object[limite];
		this.limite = limite;
		this.tamanhoAtual = 0;
	}

	public void push(T info) {
		if (this.limite == this.tamanhoAtual) {
			throw new RuntimeException("Capacidade esgotada da pilha");
		}

		this.info[this.tamanhoAtual] = info;
		this.tamanhoAtual++;
	}

	public T peek() {
		if (this.estaVazia()) {
			throw new RuntimeException("Pilha está vazia");
		}

		return info[this.tamanhoAtual - 1];
	}

	public T pop() {
		T valor = this.peek();
		info[this.tamanhoAtual - 1] = null;
		this.tamanhoAtual--;
		return valor;
	}

	public boolean estaVazia() {
		return (this.tamanhoAtual == 0);
	}

	@SuppressWarnings("unchecked")
	public void liberar() {
		/*while (!this.estaVazia()) {
			this.pop();
		}*/
		this.info = (T[]) new Object[limite];
		this.tamanhoAtual = 0;
	}
	
	public String toString() {
		if (this.estaVazia()) {
			throw new RuntimeException("Pilha está vazia");
		}
		
		String pilha = "[";
		for (int i = this.tamanhoAtual -1; i >= 0; i--) {
			pilha += this.info[i].toString() + ", ";
		}
		pilha = pilha.substring(0, this.tamanhoAtual -2);
		return pilha + "]";
	}
}
