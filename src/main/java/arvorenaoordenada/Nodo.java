package arvorenaoordenada;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Adilson Vahldick
 *
 */
public class Nodo<E> {

	private List<Nodo<E>> sucessores;
	private E info; // Estado de um Nodo
	private Nodo<E> antecessor;
	
	public Nodo(E info, Nodo<E> antecessor) {
		this.info = info;
		this.antecessor = antecessor;
		
		sucessores = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return getInfo().toString();
	}
	
	public E getInfo() {
		return info;
	}
	
	public Nodo<E> getAntecessor() {
		return antecessor;
	}

	public Nodo<E> inserir(E info) {
		Nodo<E> ret = new Nodo<E>(info, this);
		sucessores.add(ret);
		return ret;
	}

	public void removerFilho(Nodo<E> nodo) {
		sucessores.remove(nodo);
	}

	public List<Nodo<E>> getSucessores() {
		return sucessores;
	}
	
	
}
