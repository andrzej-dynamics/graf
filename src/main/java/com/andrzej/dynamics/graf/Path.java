package com.andrzej.dynamics.graf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Path implements IPath {
    private Graph g;


    public Graph buildGraph(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        reader.close();
        String rawInputText = stringBuilder.toString();
        String input_lines[] = rawInputText.split("\\r?\\n");
        Integer nodesCount = Integer.parseInt(input_lines[0], 2);
        System.out.println("Graph nodes count: " + nodesCount.toString());
        Graph graph = new Graph();
        System.out.println("[Verbose graph creation info]:");
        for(int i = 0; i < nodesCount; ++i){
            String adj_list[] = input_lines[i+1].split(" ");
            List<Integer> links = new ArrayList<Integer>();
            Integer currentNode = Integer.parseInt(adj_list[0], 2);
            for (int k = 1; k < adj_list.length; k++ ){
                links.add(Integer.parseInt(adj_list[k], 2));
            }
            System.out.println("node string_val: " + currentNode.toString() +" "+ input_lines[i+1+nodesCount]);
            System.out.println("node adjecency: " + currentNode.toString() +" "+ input_lines[i+1]);
//            input_lines[i+nodesCount]

            graph.addNode(currentNode, this.decompress(input_lines[i+nodesCount]), links);
        }
        g = graph;
        return graph;
    }

    public String decompress(String code) {
        String result = "";
        String tmp = new String(code);
        List<String> toMultiply = new ArrayList<String>();

        while(tmp.contains("(")){
            try {
                toMultiply.add(tmp.substring(tmp.indexOf("(") + 1, tmp.indexOf(")")));
                tmp = tmp.substring(tmp.indexOf("(") + 1, tmp.indexOf(")"));
            } catch (Exception e){ }
        }

        result = result + code.substring(0, code.indexOf("("));
        String[] vals = new String[2];
        for(String elem : toMultiply){

            vals = elem.split("\\*");
            int letterCount =  Integer.parseInt(vals[0]);
            int repetitions =  Integer.parseInt(vals[1]);
            String repStr = code.substring(code.indexOf("(") - letterCount, code.indexOf("("));
            for (int i = 0; i < repetitions; i++) {
                result = result + repStr;
            }
        }
        return result;
    }

    public List<String> findPath(Graph graph, int beginingNode, int destinationNode) {
        return g.shortestPathIndexes(beginingNode, destinationNode);
    }

    public List<String> getPathString(Graph graph, int beginingNode, int destinationNode) {
        return g.shortestPath(beginingNode, destinationNode);
    }
}
