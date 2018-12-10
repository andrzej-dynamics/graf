package com.andrzej.dynamics.graf;

import java.util.List;

public interface IPath {
    /*
       metoda, która jest odpowiedzialna za odczytanie pliku graph.txt, zamiane
       informacji zapisanej w postaci binarnej na dziesietna oraz zbudowanie
       grafu na podstawie odczytanego i rozkodowanego kodu binarnego
       */
    Graph buildGraph(String fileName);

    /*
        metoda dekodujaca i zwracajaca ciag znakow znajdujacy sie w zadanym wezle;
    */
    String decompress(Graph graph, int node, String code);

    /**
     * metoda znajdująca najkrotsza ścieżkę (numry wezlow) pomiędzy dwoma wezlami
     * zadanymi na wejsciu
     * @param graph - {@link Graph}
     * @param beginingNode - startowy node
     * @param destinationNode - końcowy node
     * @return scieżekę, która zawiera najmniej lister
     */
    List<String> findPath(Graph graph, int beginingNode, int destinationNode);

    /*
        metoda zwracajaca rozkodowany ciag znakow, które sa przechowywane przez
        poszczegolne wezly w najkrotszej sciezce pomiedzy dwoma wezlami oznaczonymi
        jako beginingNode oraz destinationNode
    */
    List<String> getPathString(Graph graph, int beginingNode, int destinationNode);
}
