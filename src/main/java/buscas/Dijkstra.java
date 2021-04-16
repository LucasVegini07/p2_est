package buscas;

import java.util.ArrayList;
import java.util.List;

import grafos.Aresta;
import grafos.Grafo;
import grafos.Vertice;

public class Dijkstra<K extends Comparable<K>> {
	
	private Object[][] solucao;
	private List<Vertice<K, Integer>> vertices;
	private Vertice<K, Integer> vertOrigem;

	// a definicao do tipo valor eh Integer
	public Dijkstra(Grafo<K, Integer> grafo, Vertice<K, Integer> vertOrigem) {
		
		this.vertices = grafo.getVertices();
		this.vertOrigem = vertOrigem;
		
		int total = vertices.size();
		boolean visitado[] = new boolean[total];
		this.solucao = new Object[total][2]; // [0] = distancia [1] = vertice adjacente
		
		for (int i = 0; i < total; i++) {
			solucao[i][0] = Integer.MAX_VALUE;
		}
		
		int vIndex = vertices.indexOf(vertOrigem);
		solucao[vIndex][0] = 0;
		solucao[vIndex][1] = vertOrigem;
		
		while (true) {
			
			int min = Integer.MAX_VALUE;
			Vertice<K, Integer> y = null;
			
			for (int z = 0; z < total; z++) {
				if (visitado[z]) continue;
				if ((Integer)solucao[z][0] < min) {
					min = (Integer)solucao[z][0];
					y = vertices.get(z);
				}
			}
			
			if (min == Integer.MAX_VALUE) break;
			
			int yIndex = vertices.indexOf(y);
			
			List<Aresta<K, Integer>> arestas = y.getArestas();
			for (Aresta<K, Integer> a:arestas) {
				
				Vertice<K, Integer> w = a.getVertices()[0];
				int wIndex = vertices.indexOf(w);
				if (visitado[wIndex]) continue;
				
				if ((Integer)solucao[yIndex][0] + a.getValor() < (Integer)solucao[wIndex][0]) {
					solucao[wIndex][0] = (Integer)solucao[yIndex][0] + a.getValor();
					solucao[wIndex][1] = y;
		         }
			}
			
			visitado[yIndex] = true;
			
		}
		
	}
	
	public int custoCaminhoMinimo(K vertDestino) {
		
		
		for (int i = 0; i < vertices.size(); i++) {
			Vertice<K, Integer> v = vertices.get(i);
			if (v.getChave().compareTo(vertDestino) == 0) {
				return (Integer)solucao[i][0];
			}
		}
		
		return -1;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Vertice<K, Integer>> verticesCaminhoMinimo(K vertDestino) {
		
		List<Vertice<K, Integer>> res = new ArrayList<>();
		
		for (int i = 0; i < vertices.size(); i++) {
			Vertice<K, Integer> v = vertices.get(i);
			if (v.getChave().compareTo(vertDestino) == 0) {
				
				res.add(v);
				v = (Vertice<K, Integer>) solucao[i][1];
				while (v != vertOrigem) {
					res.add(0, v);
					v = (Vertice<K, Integer>) solucao[vertices.indexOf(v)][1];
				}
				res.add(0, vertOrigem);
				
			}
		}
		
		return res;
		
	}

}
