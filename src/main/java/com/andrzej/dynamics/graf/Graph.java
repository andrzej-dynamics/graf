package com.andrzej.dynamics.graf;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final org.jgrapht.Graph<Integer, String> directedGraph;
    public Graph() {
        directedGraph = new SimpleWeightedGraph<Integer, String>(String.class);
    }

    public void addNode(int nodeIndex, String nodeValue, List<Integer> links) {
        directedGraph.addVertex(nodeIndex);
        for (int link : links) {
            directedGraph.addVertex(link);
            directedGraph.addEdge(nodeIndex, link, nodeIndex + "-" + link + " " + nodeValue);
            directedGraph.setEdgeWeight(nodeIndex, link, nodeValue.length());
        }
    }

    public List<String> shortestPath(int from, int to) {
        System.out.println("Shortest path from i to c:");
        DijkstraShortestPath<Integer, String> dijkstra = new DijkstraShortestPath<Integer, String>(directedGraph);
        final GraphPath<Integer, String> path = dijkstra.getPath(from, to);
        final List<String> edgeList = new ArrayList<String>();
        for (String rawEdgeLabel : path.getEdgeList()) {
            final int splitCharacter = rawEdgeLabel.indexOf(" ");
            final String edgeLabel = rawEdgeLabel.substring(splitCharacter + 1);
            edgeList.add(edgeLabel);
        }
        return edgeList;
    }

    public Node getNode(int nodeIndex) {
        return graph.get(nodeIndex);
    }

}
