// ENCADEADA
public class PilhaLista<T> implements Pilha<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int tamanhoAtual;
	private int limite;
	
	/*public PilhaLista(int limite) {
		NoLista<T> novo = new NoLista<>();
		this.limite = limite;
		this.tamanhoAtual = 0;
	}*/
	
	@Override
	public void push(T info) {
		if (this.limite == this.tamanhoAtual) {
			throw new RuntimeException("Capacidade esgotada da pilha");
		}
		
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(info);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		tamanhoAtual++;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		if (this.estaVazia()) {
			throw new RuntimeException("A pilha está vazia");
		}
		return this.ultimo.getInfo();
	}

	@Override
	public boolean estaVazia() {
		return (this.tamanhoAtual == 0);
	}

	@Override
	public void liberar() {
		// TODO Auto-generated method stub
		
	}

}
