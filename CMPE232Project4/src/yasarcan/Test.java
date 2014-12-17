package yasarcan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws GraphExceptions, IOException{
		BufferedReader br = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/Cmpe232Project4/src/yasarcan/test.in"));
		Graph testGraph = Graph.readFromFile(br);
		BreadthFirst bfs = new BreadthFirst();
		testGraph.BFS(bfs, testGraph.getStartVertex());
	}

}
