package grafos;

import java.util.List;

public interface Grafo<K extends Comparable<K>, V> {

	List<Vertice<K, V>> getVertices();
	Vertice<K, V> getVertice(K chave);
	Vertice<K, V> inserirVertice(K chave);
	
	List<Aresta<K, V>> getArestas();
	// Retorna as arestas somente com o vertice adjacente 
	List<Aresta<K,V>> getArestas(Vertice<K, V> vertice);
	
	Aresta<K, V> inserirAresta(Vertice<K, V> v1, Vertice<K, V> v2, V valor);
	Aresta<K, V> inserirArestaPelaChave(K v1, K v2, V valor);

	void removerVerticePelaChave(K chave);
	void removerArestaPelaChave(K v1, K v2);

}
