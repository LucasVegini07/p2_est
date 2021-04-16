/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscas;

import arvorenaoordenada.ArvoreNaoOrdenada;
import buscas.Busca;
import buscas.LucasRamthumVegini;
import grafos.Grafo;
import grafos.Vertice;
import grafosmatriz.GrafoDirecionadoMatrizAdjacencia;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Teste {

    public static void main(String[] args) {

        List<ArvoreNaoOrdenada<String>> ret = null;

        Busca<String, Integer> b = new LucasRamthumVegini<>();

        Grafo<String, Integer> grafo = null;
        List<Vertice<String, Integer>> lvertices = null;
        List<ArvoreNaoOrdenada<String>> larvore = null;
        grafo = criarTesteG();

        lvertices = b.visitarTodosVertices(grafo);
        larvore = b.gerarFloresta(grafo);

//        b.gerarFloresta(grafo);
    }

    private static Grafo<String, Integer> criarTesteG() {
        GrafoDirecionadoMatrizAdjacencia<String, Integer> grafo = new GrafoDirecionadoMatrizAdjacencia<>(6);

        grafo.inserirVertice("0");
        grafo.inserirVertice("1");
        grafo.inserirVertice("2");
        grafo.inserirVertice("3");
        grafo.inserirVertice("4");
        grafo.inserirVertice("5");

        grafo.inserirArestaPelaChave("2", "0", 0);
        grafo.inserirArestaPelaChave("2", "4", 0);
        grafo.inserirArestaPelaChave("2", "3", 0);
        grafo.inserirArestaPelaChave("0", "4", 0);
        grafo.inserirArestaPelaChave("3", "4", 0);
        grafo.inserirArestaPelaChave("4", "1", 0);
        grafo.inserirArestaPelaChave("4", "5", 0);
        grafo.inserirArestaPelaChave("4", "1", 0);
        grafo.inserirArestaPelaChave("5", "1", 0);
        grafo.inserirArestaPelaChave("1", "0", 0);

        return grafo;
    }

}
