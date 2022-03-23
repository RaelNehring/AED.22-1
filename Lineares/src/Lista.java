
public interface Lista {

	void inserir(int valor);

	String exibir();

	int buscar(int valor);

	void retirar(int valor);

	boolean estaVazia();

	int getTamanho();

	void concatenar(Lista outra);

	Lista dividir();

	Lista copiar();

	int pegar(int posicao);

}