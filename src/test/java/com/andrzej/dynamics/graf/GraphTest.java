package com.andrzej.dynamics.graf;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GraphTest {

    @Test
    public void testAddNode() {
        final Graph graph = new Graph();
        graph.addNode(0, "ADNRZEJ", Collections.singletonList(1));
        graph.addNode(1, "BREZES", Arrays.asList(2, 3));
        graph.addNode(2, "XYZW", Collections.singletonList(4));
        graph.addNode(3, "ABC", Collections.singletonList(4));
        graph.addNode(4, "123", Collections.<Integer>emptyList());

        final List<String> path = graph.shortestPath(0, 4);
        Assert.assertEquals(path.size(), 3);
        Assert.assertEquals(path.get(0), "ADNRZEJ");
        Assert.assertEquals(path.get(1), "BREZES");
        Assert.assertEquals(path.get(2), "ABC");
    }
}