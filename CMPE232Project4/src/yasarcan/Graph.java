package yasarcan;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
	private int[][] adjencyMatrix;
	private ArrayList<Vertex> vertices;
	private Vertex startVertex;

	public Graph(int noOfVertex) {
		this.adjencyMatrix = new int[noOfVertex][noOfVertex];
		this.vertices = new ArrayList<Vertex>();
	}

	public void addVertex(Vertex a) throws GraphExceptions {
		if (startVertex == null) {
			startVertex = a;
		}
		if (vertices.size() >= adjencyMatrix.length) {
			throw new GraphExceptions("Probably graph is full! Check it");
		} else {
			vertices.add(a);
		}

	}

	public void addVertex(String b) throws GraphExceptions {
		Vertex a = new Vertex(b);
		if (startVertex == null) {
			startVertex = a;
		}
		if (vertices.size() >= adjencyMatrix.length) {
			throw new GraphExceptions("Probably graph is full! Check it");
		} else {
			vertices.add(a);
		}

	}

	public void addEdge(Vertex a, Vertex b, int weight) {
		int aNo = vertices.indexOf(a);
		int bNo = vertices.indexOf(b);
		adjencyMatrix[aNo][bNo] = weight;
	}

	public void addEdge(Vertex a, Vertex b) {
		addEdge(a, b, 1);
	}

	public ArrayList<Vertex> getNeighbors(Vertex a) {
		ArrayList<Vertex> neighbors = new ArrayList<Vertex>();
		ArrayList<Vertex> vertexes = getVertexesList();
		int k = vertices.indexOf(a);
		int[] adj = adjencyMatrix[k];
		for (int i = 0; i < adj.length; i++) {
			if (adj[i] != 0) {
				neighbors.add(vertexes.get(i));
			}
		}
		return neighbors;
	}

	public ArrayList<Vertex> getVertexesList() {
		ArrayList<Vertex> vertexes = new ArrayList<Vertex>(adjencyMatrix.length);
		for (int[] e : adjencyMatrix) {
			for (Vertex vertex : vertices) {
				vertexes.set(vertices.indexOf(vertex), vertex);
			}
		}
		return vertexes;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}

	public void setStartVertex(String a) {
		Vertex startVertex = new Vertex(a);
		this.startVertex = startVertex;
	}

	public ArrayList<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertex> vertices) {
		this.vertices = vertices;
	}

	public int[][] getAdjencyMatrix() {
		return adjencyMatrix;
	}

	public void setAdjencyMatrix(int[][] adjencyMatrix) {
		this.adjencyMatrix = adjencyMatrix;
	}

	public void readFromMatrix(int[][] adjancyMatrix) {
		this.adjencyMatrix = adjancyMatrix;
	}

	public static Graph readFromFile(BufferedReader reader) throws IOException,
			GraphExceptions {
		String vertexCounter = reader.readLine();
		int noOfVertex = Integer.parseInt(vertexCounter);
		Graph graph = new Graph(noOfVertex);
		String vertexNameScanner = reader.readLine();
		String[] verticesName = vertexNameScanner.split("\\p{Space}+");
		if (verticesName.length != noOfVertex) {
			throw new GraphExceptions(
					"Number of Vertex names and Number of Vertices is not equal!");
		}
		String startVertexName = reader.readLine().trim();
		for (String nameOfvertex : verticesName) {
			try {
				graph.addVertex(nameOfvertex);
			} catch (GraphExceptions e) {
				throw new GraphExceptions("Graph is full!");
			}
		}
		try {
			graph.setStartVertex(startVertexName);
		} catch (Exception e) {
			throw new GraphExceptions("There is no start vertex in Graph!");
		}
		int[][] adjancy = new int[noOfVertex][noOfVertex];
		try {
			for (int i = 0; i < noOfVertex; i++) {
				String numberOfLine = reader.readLine();
				String[] weights = numberOfLine.split("\\p{Space}+");
				for (int j = 0; j < noOfVertex; j++) {
					adjancy[i][j] = Integer.parseInt(weights[j]);
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new GraphExceptions("Can not read Adjancy Matrix!");
		}
		graph.readFromMatrix(adjancy);
		return graph;
	}
	public void BFS(BreadthFirst bfs, Vertex starter){
		bfs.doit(this, starter);
		System.out.println(bfs.Path());
		
	}
}
