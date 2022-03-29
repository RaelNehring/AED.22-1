
public interface Lista<T> {

	void inserir(T valor);

	String exibir();

	int buscar(T valor);

	void retirar(T valor);

	boolean estaVazia();

	int getTamanho();

	void concatenar(Lista<T> outra);

	Lista<T> dividir();

	Lista<T> copiar();

	T pegar(int posicao);

}