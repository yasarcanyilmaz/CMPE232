package yasarcan;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yasarcan
 * 
 */
public class Graph<A> {
	private Map<Vertex<A>, Integer> vertexes = new HashMap<Vertex<A>, Integer>();
	private int[][] adjans;
	private Vertex<A> startVertex;

	

	public Graph(int numberOfVertex) {
		this.adjans = new int[numberOfVertex][numberOfVertex];
	}

	public int[][] getAdjans() {
		return adjans;
	}

	public void setAdjans(int[][] adjans) {
		this.adjans = adjans;
	}

	public Vertex<A> getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex<A> startVertex) {
		this.startVertex = startVertex;
	}

	public void setStartVertex(A startVertex) throws GraphExceptions {
		this.startVertex = findVertexByName(startVertex);
	}

	public Vertex<A> findVertexByName(A a) throws GraphExceptions {
		for (Vertex<A> x : vertexes.keySet()) {
			if (x.getData().equals(a)) {
				return x;
			}
		}
		throw new GraphExceptions("Something wrong with Vertexes!");
	}

	public Set<Vertex<A>> getVertexes() {
		return vertexes.keySet();
	}

	public Set<Edge<A>> getEdges() {
		Set<Edge<A>> edges = new HashSet<Edge<A>>();
		ArrayList<Vertex<A>> vertex_array = getVertexAsList();
		for (int i = 0; i < adjans.length; i++) {
			for (int j = 0; j < adjans[i].length; j++) {
				if (adjans[i][j] != 0) {
					edges.add(new Edge<A>(vertex_array.get(i), vertex_array
							.get(j), adjans[i][j]));
				}
			}
		}
		return edges;
	}

	public ArrayList<Vertex<A>> getVertexAsList() {
		ArrayList<Vertex<A>> vertex_array = new ArrayList<Vertex<A>>(
				adjans.length);

		for (int[] x : adjans) {
			vertex_array.add(null);
		}
		for (Vertex<A> vertex : vertexes.keySet()) {
			vertex_array.set(vertexes.get(vertex), vertex);
		}
		return vertex_array;
	}

	public void addVertex(Vertex<A> v) throws GraphExceptions {
		if (startVertex == null) {
			startVertex = v;
		}
		if (vertexes.size() >= adjans.length) {
			throw new GraphExceptions("Graph is Full!");
		} else {
			vertexes.put(v, vertexes.size());
		}
	}

	public void addVertex(A v) throws GraphExceptions {
		addVertex(new Vertex<A>(v));
	}

	public void addEdge(Vertex<A> source, Vertex<A> dest, Integer weight) {
		int keyS = vertexes.get(source);
		int keyD = vertexes.get(dest);
		adjans[keyS][keyD] = weight;
	}

	public void addEdge(Vertex<A> source, Vertex<A> dest) {
		addEdge(source, dest, 1);
	}

	public void addEdge(A source, A dest, Integer weight)
			throws GraphExceptions {
		Vertex<A> nameOfSource = findVertexByName(source);
		Vertex<A> nameOfDest = findVertexByName(dest);
		addEdge(nameOfSource, nameOfDest, weight);
	}

	public Set<Vertex<A>> getNeighbors(Vertex<A> v) {
		Set<Vertex<A>> neighbors = new HashSet<Vertex<A>>();
		ArrayList<Vertex<A>> listOfVertex = getVertexAsList();
		int keyOfVertex = vertexes.get(v);
		int[] adjansList = adjans[keyOfVertex];
		for (int i = 0; i < adjansList.length; i++) {
			// Checking there is an edge or not which means being neighbors or
			// not!
			if (adjansList[i] != 0) {
				neighbors.add(listOfVertex.get(i));
			}
		}
		return neighbors;
	}

	public static Graph<String> readFromFile(BufferedReader reader)
			throws IOException, GraphExceptions {
		String vertexCounter = reader.readLine();
		int noOfVertex = Integer.parseInt(vertexCounter);
		Graph<String> graph = new Graph<String>(noOfVertex);
		String vertexNames = reader.readLine();
		String[] vertexNamesArrray = vertexNames.split("\\p{Space}+");
		String startVertex = reader.readLine().trim();
		for (String nameOfVertex : vertexNamesArrray) {
			try {
				graph.addVertex(nameOfVertex);
			} catch (GraphExceptions e) {
				throw new GraphExceptions("Graph is Full, cannot be added!");
			}
		}
		try {
			graph.setStartVertex(startVertex);
		} catch (GraphExceptions e) {
			throw new GraphExceptions("There is no start vertex in graph!");
		}
		int[][] adjancies = new int[noOfVertex][noOfVertex];
		try {
			for (int j = 0; j < noOfVertex; j++) {
				String noOfLine = reader.readLine();
				String[] weights = noOfLine.split("\\p{Space}+");
				for (int k = 0; k < noOfVertex; k++) {
					adjancies[j][k] = Integer.parseInt(weights[k]);
				}

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new GraphExceptions("Adjancy matrix can not be read!");
		}
		graph.readFromMatrix(adjancies);
		return graph;
	}

	private void readFromMatrix(int[][] adjancies) {
		if ((adjancies.length == adjans.length)
				&& (adjancies[0].length == adjans[0].length))
			adjans = adjancies;
	}

	public void PrintNeighbors(Vertex<A> v) {
		System.out.println("Neighbors of " + v + ": " + getNeighbors(v));

	}

	public void printGraph() {
		for (Vertex<A> a : getVertexAsList())
			PrintNeighbors(a);
	}

	public void BFS(BreadthFirst<A> bfs, Vertex<A> starter) {
		bfs.doit(this, starter);
		bfs.execute();
		System.out.println(bfs.Path());

	}
	public void Dijkstra(DijkstraAlgorithm<A> djks, Vertex<A> source, Vertex<A> target){
		djks.Paths(this, source);
		djks.getShortestPath(target);
		System.out.println(djks.printPath(target));
	}

	
}
