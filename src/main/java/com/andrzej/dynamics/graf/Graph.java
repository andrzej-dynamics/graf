package com.andrzej.dynamics.graf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Integer, Node> graph;

    public Graph() {
        this.graph = new HashMap<Integer, Node>();
    }

    public void addNode(int nodeIndex, String nodeValue, List<Integer> links) {
        final Node nodeFromMap = graph.get(nodeIndex);
        if (nodeFromMap != null) {
            throw new IllegalArgumentException("node already exists");
        }
        final Node node = new Node(nodeValue, links);
        graph.put(nodeIndex, node);
    }

    public Node getNode(int nodeIndex) {
        return graph.get(nodeIndex);
    }

}
