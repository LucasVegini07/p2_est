package arvorenaoordenada;

import java.util.List;

/**
 * 
 * @author Adilson Vahldick
 *
 */
public class BuscaProfundidade<E extends Comparable<E>> extends Busca<E> {

	public Nodo<E> procurar(Nodo<E> nodo, E chave) {
		
		visitados++;
		if (nodo.getInfo().compareTo(chave) == 0) {
			return nodo;
		}
		
		Nodo<E> retorno = null;
		
		List<Nodo<E>> filhos = nodo.getSucessores();
		for (Nodo<E> n:filhos) {
			profundidade++;
			retorno = procurar(n, chave);
			if (retorno != null)
				return retorno;
		}
			
		profundidade--;
		return retorno;
	}
	
}
