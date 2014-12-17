/**
 * 
 */
package yasarcan;

/**
 * @author yasarcan
 * 
 */
public class Edge<A> {
	private Vertex<A> source;
	private Vertex<A> dest;
	private Integer weight;

	public Edge(Vertex<A> source, Vertex<A> dest, int weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}

	public Edge(Vertex<A> source, Vertex<A> dest) {
		this.source = source;
		this.dest = dest;
		this.weight = 1;
	}

	public Vertex<A> getSource() {
		return source;
	}

	public void setSource(Vertex<A> source) {
		this.source = source;
	}

	public Vertex<A> getDest() {
		return dest;
	}

	public void setDest(Vertex<A> dest) {
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
