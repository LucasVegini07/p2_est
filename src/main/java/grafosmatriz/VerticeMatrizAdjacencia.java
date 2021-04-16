package grafosmatriz;

import java.util.List;

import grafos.Aresta;
import grafos.Grafo;
import grafos.Vertice;

public class VerticeMatrizAdjacencia<K extends Comparable<K>, V> implements Vertice<K, V> {

	private K chave;
	private Grafo<K, V> grafo;
	private int index;

	public VerticeMatrizAdjacencia(Grafo<K, V> grafo, K chave, int index) {
		this.grafo = grafo;
		this.chave = chave;
		this.index = index;
	}

	@Override
	public K getChave() {
		return chave;
	}

	@Override
	public String toString() {
		return getChave() + "";
	}

	public int getIndex() {
		return index;
	}

	@Override
	public List<Aresta<K, V>> getArestas() {
		return grafo.getArestas(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		VerticeMatrizAdjacencia<K, V> v = (VerticeMatrizAdjacencia<K, V>) obj;

		return v.getChave().compareTo(getChave()) == 0;
	}
}
