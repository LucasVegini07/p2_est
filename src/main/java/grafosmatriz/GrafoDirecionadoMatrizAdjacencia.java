package grafosmatriz;

/**
*
* Grafo direcionado usando matriz de adjacencia. 
* 
* @author Adilson Vahldick
*
*/
public class GrafoDirecionadoMatrizAdjacencia<K extends Comparable<K>, V> extends
		GrafoNaoDirecionadoMatrizAdjacencia<K, V> {

	public GrafoDirecionadoMatrizAdjacencia(int qtosVertices) {
		super(qtosVertices);
	}
	
	@Override
	protected void atribuirMatriz(int posV1, int posV2, V valor) {
		matriz[posV1][posV2] = valor;
	}	


}
