package com.andrzej.dynamics.graf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/*
1. Czy graf został poprawnie odczytany
1.1 Czy poprawnie rozkodowano strukture grafu
1.2. Czy liczba wierzchołków zgadza się
2.1 czy poprawnie rozkodowano ciąg
2.2 [...]
- przyk(2x4)(3x2)l(2x2)ad
-> od lewej do prawej
- tekst
*/

/**
 * Created by jazowski_1150904 on 26.11.18.
 */

public class MainClass {
    public static void main(String[] args) throws IOException {

        String fileName = "/home/farbanie_1115092/IdeaProjects/graf/src/main/resources/basic_input.txt";
        Path path = new Path();
        Graph graph = path.buildGraph(fileName);

//        System.out.println(content);

    }
}
