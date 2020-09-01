
public class Pilha<T> {

	private ListaDuplamenteEncadeada<T> lista;

	public Pilha() {

		lista = new ListaDuplamenteEncadeada<T>();
	}

	public void push(Node<T> no) {
		lista.addFinal(no);

	}

	public void pop() {
		lista.removerFim();

	}

}
