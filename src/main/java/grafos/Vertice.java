package grafos;

import java.util.List;

public interface Vertice<K extends Comparable<K>, V> {

	K getChave();

	List<Aresta<K, V>> getArestas();
	
}
