package com.andrzej.dynamics.graf;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String value;
    private List<Integer> links;

    public Node(String value, List<Integer> links) {
        this.value = value;
        this.links = links;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getValueDistance() {
        return value.length();
    }

    public List<Integer> getLinks() {
        return new ArrayList<Integer>(links);
    }
}
