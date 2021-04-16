package arvorenaoordenada;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Adilson Vahldick
 *
 */
public class BuscaLargura<E extends Comparable<E>> extends Busca<E> {

	@Override
	public Nodo<E> procurar(Nodo<E> nodo, E chave) {
		
		// TODO para obter a profundidade precisa criar uma nova estrategia
		this.profundidade = -1;
		
		Queue<Nodo<E>> fila = new LinkedList<>();
		fila.add(nodo);
		while (!fila.isEmpty() ) {
			
			Nodo<E> noh = fila.poll(); // dequeue
			visitados++;
			if (noh.getInfo().compareTo(chave) == 0) {
				return noh;
			}
			
			if (noh.getSucessores() != null) {
				fila.addAll(noh.getSucessores()); // enqueue
			}
			
		}
		
		return null;
	}


}
