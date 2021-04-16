package arvorenaoordenada;

/**
 * 
 * @author Adilson Vahldick
 *
 */
public class ArvoreNaoOrdenada<E> {

	private Nodo<E> raiz;
	private int grau;

	public ArvoreNaoOrdenada(E info) {
		this.raiz = new Nodo<E>(info, null);
	}

	public Nodo<E> getRaiz() {
		return raiz;
	}

	public Nodo<E> inserirFilho(Nodo<E> pai, E info) {
		return pai.inserir(info);
	}

	public void remover(Nodo<E> nodo) {
		if (nodo == raiz) {
			new RuntimeException("Fim da \u00E1rvore");
		}

		Nodo<E> ant = nodo.getAntecessor();
		ant.removerFilho(nodo);
	}

	private int profundidade;

	/*
	 * Profundidade eh a quantidade de arestas + 1 entre o nodo base ate o maior
	 * caminho a uma de suas folhas.
	 */
	public int getProfundidade(Nodo<E> nodo) {
		profundidade = recursiveProfundidade(nodo) + 1;
		return profundidade;
	}

	private int recursiveProfundidade(Nodo<E> nodo) {
		int maxCount = 0;
		if (nodo.getSucessores() != null) {
			for (Nodo<E> e : nodo.getSucessores()) {
				maxCount = 1 + recursiveProfundidade(e);
			}
		} else {
			return 1;
		}
		return maxCount;
	}

	/*
	 * Grau de um nodo eh a sua quantidade de subarvores. O grau de uma arvore eh o
	 * maior valor dentre os graus de todos os nodos.
	 */
	public int getGrauArvore() {
		this.grau = raiz.getSucessores().size();
		recursiveGrau(raiz);
		return grau;
	}

	private void recursiveGrau(Nodo<E> nodo) {
		for (Nodo<E> e : nodo.getSucessores()) {
			if (nodo.getSucessores().size() > grau) {
				grau = nodo.getSucessores().size();
			}
			recursiveGrau(e);
		}
	}

	/*
	 * Nivel de um nodo eh a quantidade de arestas do nodo base ate alcancar a 
	 * raiz + 1.
	 */
	public int getNivel(Nodo<E> nodo) {
		return recursiveNivel(nodo);
	}

	private int recursiveNivel(Nodo<E> nodo) {
		int count = 0;
		if (nodo.getAntecessor() == null) {
			return 1;
		} else {
			count = 1 + recursiveNivel(nodo.getAntecessor());
		}
		return count;
	}
	
	public Nodo<E> procurarProfundidade(E info) {
		Nodo<E> n = recursiveProcurar(raiz, info);
		
		return n;
	}

	private Nodo<E> recursiveProcurar(Nodo<E> nodo, E info) {
		if (nodo.getInfo() == info) {
			return nodo;
		}

		for (Nodo<E> e : nodo.getSucessores()) {
			Nodo<E> n = recursiveProcurar(e, info);
			if (n != null) {
				return n;
			}
		}
		return null;
	}

}
