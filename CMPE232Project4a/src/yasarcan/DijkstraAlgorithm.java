package yasarcan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm<A> {

	public void Paths(Graph<A> graph, Vertex<A> sourceVertex) {

		PriorityQueue<Vertex<A>> verticesQueue = new PriorityQueue<Vertex<A>>();
		sourceVertex.setDistance(0);
		verticesQueue.add(sourceVertex);

		while (!verticesQueue.isEmpty()) {
			Vertex<A> vertex = verticesQueue.poll();

			for (Edge<A> x : graph.getEdges()) {
				if(x.getSource() == vertex){
					Vertex<A> v = x.getDest();
				int weight = x.getWeight();
				int distanceThroughTargetVertex = vertex.getDistance()
						+ weight;
				
				if (distanceThroughTargetVertex < v.getDistance()) {
					verticesQueue.remove(v);
					v.setDistance(distanceThroughTargetVertex);
					v.setPred(vertex);
					verticesQueue.add(v);
				}
				}
			}
		}

	}
	
	public List<Vertex<A>> getShortestPath(Vertex<A> target){
		List<Vertex<A>> path = new ArrayList<Vertex<A>>();
		for (Vertex<A> vertex =target; vertex != null; vertex = vertex.getPred())
			path.add(vertex);
		Collections.reverse(path);
		return path;
	}
	
	public Object printPath(Vertex<A> target) {
		String tmp = "";
		for (Vertex<A> e : getShortestPath(target)) {
			String pred = e.getPred() == null ? "Null" : e.getPred().getData()
					.toString();
			tmp = tmp
					+ String.format("Vertex: %s, Pred: %s, Distance: %s\n",
							e.getData(), pred, e.getDistance());
		}
		return tmp;
	}
	
}
