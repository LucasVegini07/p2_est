package grafosmatriz;

import java.util.ArrayList;
import java.util.List;

import grafos.Aresta;
import grafos.Grafo;
import grafos.Vertice;

/**
 *
 * Grafo nao-direcionado usando matriz de adjacencia. 
 * 
 * @author Adilson Vahldick
 *
 */
public class GrafoNaoDirecionadoMatrizAdjacencia<K extends Comparable<K>, V> implements Grafo<K, V>{

	protected V[][] matriz;
	private Object[] vertices;
	private int lastIndex;
	
	@SuppressWarnings("unchecked")
	public GrafoNaoDirecionadoMatrizAdjacencia(int qtosVertices) {
		
		matriz = (V[][]) new Object[qtosVertices][qtosVertices];
		vertices = new Object[qtosVertices];
		lastIndex = 0;
		
	}
	
	protected void atribuirMatriz(int posV1, int posV2, V valor) {
		
		matriz[posV1][posV2] = valor;
		matriz[posV2][posV1] = valor;
	}
	
	@Override
	public Vertice<K, V> inserirVertice(K chave) {
		if (lastIndex == vertices.length)
			throw new RuntimeException("Limite de v\u00E9rtices alcan\u00e7ado");
		VerticeMatrizAdjacencia<K, V> v = new VerticeMatrizAdjacencia<>(this, chave, lastIndex);
		vertices[lastIndex] = v;
		lastIndex++;
		return v;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vertice<K, V>> getVertices() {
		
		List<Vertice<K, V>> l = new ArrayList<>(vertices.length);
		for (Object o:vertices)
			l.add((Vertice<K, V>) o);
		
		return l;
	}

	@Override
	public Aresta<K, V> inserirAresta(Vertice<K, V> v1, Vertice<K, V> v2, V valor) {
		

		int posV1 = ((VerticeMatrizAdjacencia<K, V>)v1).getIndex();
		int posV2 = ((VerticeMatrizAdjacencia<K, V>)v2).getIndex();
		
		atribuirMatriz(posV1, posV2, valor);
		
		return new Aresta<>(valor, v1 ,v2);
	}
	
	@SuppressWarnings("unchecked")
	// só para facilitar o cast
	private Vertice<K, V> getInternalVertice(int index) {
		return (Vertice<K, V>) vertices[index];
	}
	
	@Override
	public List<Aresta<K, V>> getArestas() {
		
		List<Aresta<K, V>> arestas = new ArrayList<>(matriz.length * 2);
		
		for (int i = 0; i < lastIndex; i++) {
			for (int j = 0; j < lastIndex; j++) {
				if (matriz[i][j] != null) {
					Vertice<K, V> vert1 = getInternalVertice(i);
					Vertice<K, V> vert2 = getInternalVertice(j);
					
					arestas.add(new Aresta<>(matriz[i][j], vert1, vert2));
				}
			}
		}
		
		return arestas;
	}


	@Override
	public List<Aresta<K, V>> getArestas(Vertice<K, V> vertice) {
		List<Aresta<K, V>> arestas = new ArrayList<>(matriz.length);
		
		int pos = ((VerticeMatrizAdjacencia<K, V>)vertice).getIndex();
		
		for (int j = 0; j < lastIndex; j++) {
			if (matriz[pos][j] != null) {
				arestas.add(new Aresta<>(matriz[pos][j], getInternalVertice(j)));
			}
		}
		
		return arestas;
	}

	@Override
	public Aresta<K, V> inserirArestaPelaChave(K v1, K v2, V valor) {
		
		int posV1 = -1;
		int posV2 = -1;
		
		int i = 0;
		while (i < lastIndex && !(posV1 != -1 && posV2 != -1)) {
			
			if (posV1 == -1 && getInternalVertice(i).getChave().compareTo(v1) == 0) {
				posV1 = i;
			} else {
				// self-loops nao sao permitidos
				if (posV2 == -1 && getInternalVertice(i).getChave().compareTo(v2) == 0) {
					posV2 = i;
				}
			}
			i++;
		}
		
		atribuirMatriz(posV1, posV2, valor);
		
		return new Aresta<>(valor, getInternalVertice(posV1), getInternalVertice(posV2));
	}

	@Override
	public Vertice<K, V> getVertice(K chave) {
		
		for (int i = 0; i < lastIndex; i++) {
			Vertice<K, V> v = getInternalVertice(i);
			if (v.getChave().compareTo(chave) == 0) {
				return v;
			}
		}
		return null;
	}


	@Override
	public void removerVerticePelaChave(K chave) {
		// TODO 
	}

	@Override
	public void removerArestaPelaChave(K v1, K v2) {
		// TODO 
		
	}

}
