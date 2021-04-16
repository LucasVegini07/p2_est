package arvorenaoordenada;

/**
 * 
 * @author Adilson Vahldick
 *
 */
public abstract class Busca<E extends Comparable<E>> {
	
	public abstract Nodo<E> procurar(Nodo<E> nodo, E chave);
	protected int profundidade = 1;
	protected int visitados = 0;
	
	public int getProfundidade() {
		return profundidade;
	}
	
	public int getNodosVisitados() {
		return visitados;
	}
	
}
