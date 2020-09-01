
public class ListaDuplamenteEncadeada<T> {

	private Node<T> cabeca;
	private Node<T> cauda;
	private Node<T> noAnt;
	private int tamanho = 0;

	public void addFinal(Node<T> no) {

		if (cabeca == null) {
			this.tamanho += 1;

			this.cabeca = no;
			this.cauda = no;
			return;
		}

		this.noAnt = cauda;
		this.cauda.setProximo(no);
		this.cauda = no;

	}

	public void length() {

		System.out.println("Tamanho da Lista: " + tamanho);
	}

	public void removeInicio() throws Exception {
		this.tamanho -= 1;
		if (this.noAnt == null) {
			throw new Exception();
		}

		this.cabeca = this.cabeca.getAnterior();
		this.noAnt = null;
		if (this.cabeca == null) {
			cauda = null;
		}
	}

	public void removerFim() {
		// A lista está vazia
		if (this.cabeca == null) {
			this.cabeca = null;
			this.cauda = null;
			return;
		}
		Node<T> penultimo = this.cabeca;
		while (penultimo.getProximo() != cauda) {
			penultimo = penultimo.getProximo();
		}
		penultimo.setProximo(null);
		cauda = penultimo;
	}

	public boolean contem(String valor) {
		for (Node<T> n = cabeca; n != null; n = n.getProximo()) {
			if (((String) n.getValor()).contentEquals(valor)) {
				return true;
			}
		}
		return false;

	}

	public void remove(T valor) throws Exception {
		if (cabeca == null) {

			throw new Exception("Lista Vazia");
		}

		if (cabeca.getValor().equals(valor)) {
			if (cabeca.getValor() == null) {
				cauda = null;
				cabeca = null;
				noAnt = null;
			} else {
				cabeca = cabeca.getProximo();
			}
			return;

		}

		Node<T> no = cabeca;

		while (no != null && !no.getValor().equals(valor)) {
			noAnt = no;
			no = no.getProximo();

		}

		if (no == null) {

			throw new Exception("Não Achou");
		}

		noAnt.setProximo(no.getProximo());

		if (no.getAnterior() == null) {

			cauda = noAnt;
		}

	}

	public boolean isEmpty() {
		return cabeca == null;

	}

	public void clear() {
		cabeca = null;
		cauda = null;
		noAnt = null;

	}

}
