package com.andrzej.dynamics.graf;

import java.util.List;

public class Node {
    private String value;
    private List<Integer> links;

    public Node(String value, List<Integer> links) {
        this.value = value;
        this.links = links;
    }
}
