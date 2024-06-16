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
    @Test
    public void calcShortestPathTest1() {
        String word1 = "to";
        String word2 = "neww";
        String words = graph.calcShortestPath(word1, word2);
        assertEquals("One or both of the words are not in the graph.",words);
    }
    @Test
    public void calcShortestPathTest2() {
        String word1 = "to";
        String word2 = "out";
        String words = graph.calcShortestPath(word1, word2);
        assertEquals("Shortest path: to -> seek -> out\n" +
                "Path length: 2 edges.",words);
    }
    @Test
    public void calcShortestPathTest3() {
        String word1 = "to";
        String word2 = "new";
        String words = graph.calcShortestPath(word1, word2);
        assertEquals("Shortest path: to -> explore -> strange -> new\n" +
                "Shortest path: to -> seek -> out -> new\n" +
                "Path length: 3 edges.",words);
    }
    @Test
    public void calcShortestPathTest4() {
        String word1 = "civilizations";
        String word2 = "to";
        String words = graph.calcShortestPath(word1, word2);
        assertEquals("There is no path between the two words.",words);
    }

}