package grafos;

public class Aresta<K extends Comparable<K>, V> {
	
	private Vertice<K, V>[] vertices;
	private V valor;

	@SafeVarargs
	public Aresta(V valor, Vertice<K, V>... vertices) {
		this.valor = valor;
		this.vertices = vertices;
	}
	
	public V getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return valor+"";
	}
	
	public Vertice<K, V>[] getVertices() {
		return vertices;
	}
	
}
