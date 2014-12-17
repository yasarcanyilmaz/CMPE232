package yasarcan;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirst {
	Queue<Vertex> queue = new LinkedList<Vertex>();
	Graph graph;

	public void doit(Graph graph, Vertex starter) {
		this.graph = graph;
		for (Vertex vertex : graph.getVertexesList()) {
			vertex.setColor(Color.WHITE);
			vertex.setPred(null);
			vertex.setDistance(Integer.MAX_VALUE);
		}
		starter.setDistance(0);
		queue.add(starter);
		while (queue.peek() != null) {
			Vertex tmp = queue.remove();
			doForNeighbors(tmp);
			tmp.setColor(Color.BLACK);
		}
	}

	public void doForNeighbors(Vertex a) {
		for (Vertex vertex : graph.getNeighbors(a)) {
			if (vertex.getColor() == Color.WHITE) {
				vertex.setColor(Color.GRAY);
				vertex.setPred(a);
				vertex.setDistance(a.getDistance() + 1);
				queue.add(vertex);
			}
		}
	}

	public Object Path() {
		String tmp = "";
		for (Vertex e : graph.getVertexesList()) {
			String parent = e.getPred() == null ? "Null" : e.getPred()
					.getName().toString();
			tmp = tmp
					+ String.format("e: %s, Parent: %s, Distance: %s\n",
							e.getName(), parent, e.getDistance());
		}
		return tmp;
	}
}
