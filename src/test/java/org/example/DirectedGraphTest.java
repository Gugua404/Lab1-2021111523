package org.example;

import org.junit.*;
import java.io.File;
import java.io.IOException;

import static org.example.DirectedGraph.processString;
import static org.example.DirectedGraph.readFileAsString;
import static org.junit.Assert.assertEquals;

public class DirectedGraphTest {
    @BeforeClass
    public static void set_graph() throws IOException {
        String content = readFileAsString("files/1.txt");
        content = processString(content);
        graph = new DirectedGraph(content);
    }
    private static DirectedGraph graph;

    @Test
    public void queryBridgeWords1() {
        String word1 = "new";
        String word2 = "and";
        String test = graph.queryBridgeWords(word1,word2);
        assertEquals("The bridge words from new to and are: life.",test);
    }
    @Test
    public void queryBridgeWords2() {
        String word1 = "132new";
        String word2 = "and";
        String words = graph.queryBridgeWords(word1,word2);
        assertEquals("No 132new or and in the graph!",words);
    }
    @Test
    public void queryBridgeWords3() {
        String word1 = "strange";
        String word2 = "worlds";
        String words = graph.queryBridgeWords(word1,word2);
        assertEquals("The bridge words from strange to worlds are: new.",words);
    }
    @Test
    public void queryBridgeWords4() {
        String word1 = "happy";
        String word2 = "and";
        String words = graph.queryBridgeWords(word1,word2);
        assertEquals("No happy or and in the graph!",words);
    }


}