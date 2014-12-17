package yasarcan;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yasarcan
 * @param <A>
 * 
 */
public class BreadthFirst<A> {
	Queue<Vertex<A>> queue = new LinkedList<Vertex<A>>();
	Graph<A> graph;

	public void doit(Graph<A> graph, Vertex<A> starter) {
		this.graph = graph;
		for (Vertex<A> x : graph.getVertexAsList()) {
			x.setColor(Color.WHITE);
			x.setDistance(Integer.MAX_VALUE);
			x.setPred(null);
		}
		starter.setDistance(0);
		queue.add(starter);
	}

	public void execute() {
		while (queue.peek() != null) {
			Vertex<A> vertex = queue.remove();
			executeForNeighbors(vertex);
			vertex.setColor(Color.BLACK);
		}
	}

	public void executeForNeighbors(Vertex<A> pred) {
		for (Vertex<A> x : graph.getNeighbors(pred)) {
			if (x.getColor() == Color.WHITE) {
				x.setColor(Color.GRAY);
				x.setPred(pred);
				x.setDistance(pred.getDistance() + 1);
				queue.add(x);
			}
		}
	}

	public Object Path() {
		String tmp = "";
		for (Vertex<A> e : graph.getVertexAsList()) {
			String pred = e.getPred() == null ? "Null" : e.getPred().getData()
					.toString();
			tmp = tmp
					+ String.format("Vertex: %s, Pred: %s, Distance: %s\n",
							e.getData(), pred, e.getDistance());
		}
		return tmp;
	}

}
