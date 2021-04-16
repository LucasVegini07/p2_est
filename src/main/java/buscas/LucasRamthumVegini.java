package buscas;

import java.util.ArrayList;
import java.util.List;

import arvorenaoordenada.ArvoreNaoOrdenada;
import arvorenaoordenada.Nodo;
import grafos.Aresta;
import grafos.Grafo;
import grafos.Vertice;

public class LucasRamthumVegini<K extends Comparable<K>, V> extends Busca<K, V> {

    private int conta;
    private int[] ordemVertices;
    private Object[] raizes;

    @Override
    public List<Vertice<K, V>> visitarTodosVertices(Grafo<K, V> grafo) {

        doBuscaEmProfundidade(grafo);

        List<Vertice<K, V>> vertices = grafo.getVertices();

        List<Vertice<K, V>> ret = new ArrayList<>();
        for (int i = 1; i <= ordemVertices.length; i++) {
            for (int j = 0; j < ordemVertices.length; j++) {
                if (ordemVertices[j] == i) {
                    ret.add(vertices.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    // questao da prova 2
    public List<ArvoreNaoOrdenada<K>> gerarFloresta(Grafo<K, V> grafo) {
        int i;
        int j;
        List<ArvoreNaoOrdenada<K>> res = new ArrayList<>();
        List grafoList = grafo.getVertices();

        doBuscaEmProfundidade(grafo);

        // resultado que pode ser usado para gerar as arvores
        for (i = 0; i < raizes.length; i++) {

            System.out.println("Raizes: " + raizes[i].toString() + " valor: " + grafoList.get(i).toString());

        }

        //Criação da quantidade de árvores
        for (i = 0; i < raizes.length; i++) {

            if (Integer.parseInt(grafoList.get(i).toString()) == Integer.parseInt(raizes[i].toString())) {

                ArvoreNaoOrdenada arvore = new ArvoreNaoOrdenada(grafoList.get(i));
                System.out.println("Adicionou " + grafoList.get(i) + " como raiz do problema");

                res.add(arvore);

            }

        }

        //Adiciona os elementos na raiz;
        for (ArvoreNaoOrdenada a : res) {

            Nodo n = a.getRaiz();
            Nodo auxiliar = a.getRaiz();

            for (i = 0; i < raizes.length; i++) {

                if (Integer.parseInt(raizes[i].toString()) == Integer.parseInt(n.toString())
                        && i != Integer.parseInt(n.toString())) {
                    auxiliar = a.inserirFilho(n, grafoList.get(i));
                    System.out.println("Adicionou " + grafoList.get(i).toString() + " na folha " + n.toString());
                    this.validaNovaAresta(auxiliar, a, grafo);
                }

            }

        }

        return res;

    }

    //Adiciona os elementos em loop para não faltar nenhum nodo;
    public void validaNovaAresta(Nodo auxiliar, ArvoreNaoOrdenada a, Grafo<K, V> grafo) {

        List grafoList = grafo.getVertices();

        for (int i = 0; i < raizes.length; i++) {

            if (Integer.parseInt(raizes[i].toString()) == Integer.parseInt(auxiliar.toString())) {
                System.out.println("Adicionou " + grafoList.get(i).toString() + " na folha " + auxiliar.toString());
                validaNovaAresta(a.inserirFilho(auxiliar, grafoList.get(i)), a, grafo
                );

            }

        }

    }

    private void doBuscaEmProfundidade(Grafo<K, V> grafo) {
        this.conta = 0;

        List<Vertice<K, V>> vertices = grafo.getVertices();
        this.ordemVertices = new int[vertices.size()];

        this.raizes = new Object[vertices.size()];
        for (int i = 0; i < ordemVertices.length; i++) {
            ordemVertices[i] = -1;
        }

        for (int i = 0; i < vertices.size(); i++) {
            if (ordemVertices[i] == -1) {
                raizes[i] = vertices.get(i);
                doVisitar(vertices, vertices.get(i));
            }
        }

    }

    private void doVisitar(List<Vertice<K, V>> vertices, Vertice<K, V> vertice) {
        this.conta++;
        ordemVertices[vertices.indexOf(vertice)] = conta;

        for (Aresta<K, V> aresta : vertice.getArestas()) {
            Vertice<K, V> w = aresta.getVertices()[0];
            int iW = vertices.indexOf(w);
            if (ordemVertices[iW] == -1) {
                raizes[iW] = vertice;
                doVisitar(vertices, w);
            }
        }

    }

}
