package yasarcan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author yasarcan
 * 
 */

public class Test {

	
	public static void main(String[] args) throws IOException, GraphExceptions {
		BufferedReader br = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/Cmpe232Project4a/src/yasarcan/test.in"));
		Graph<String> testGraph = Graph.readFromFile(br);
		BufferedReader br2 = new BufferedReader(
				new FileReader(
					"/Users/yasarcan/Documents/eclipseworks/Cmpe232Project4a/src/yasarcan/test2.in"));
		Graph<String> testGraph2 = Graph.readFromFile(br2);
		DijkstraAlgorithm<String> dja = new DijkstraAlgorithm<String>();
		
		
		testGraph.Dijkstra(dja, testGraph.findVertexByName("a"), testGraph.findVertexByName("d"));
		testGraph.Dijkstra(dja, testGraph.findVertexByName("a"), testGraph.findVertexByName("c"));
		testGraph.Dijkstra(dja, testGraph.getStartVertex(), testGraph.findVertexByName("c"));
		testGraph.Dijkstra(dja, testGraph.getStartVertex(), testGraph.findVertexByName("b"));
		
		testGraph2.Dijkstra(dja, testGraph2.findVertexByName("a"), testGraph2.findVertexByName("c"));
		
	}
}
