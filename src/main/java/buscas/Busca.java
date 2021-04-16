package buscas;

import java.util.List;

import arvorenaoordenada.ArvoreNaoOrdenada;
import grafos.Grafo;
import grafos.Vertice;

public abstract class Busca<K extends Comparable<K>, V> {
	
	public abstract List<Vertice<K, V>> visitarTodosVertices(Grafo<K, V> grafo);
	
	// questao da prova 2
	public abstract List<ArvoreNaoOrdenada<K>> gerarFloresta(Grafo<K, V> grafo);

}
