package yasarcan;

public class Edge {
	private Vertex source;
	private Vertex destination;
	private int weight;

	public Edge(Vertex source, Vertex destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public Edge(Vertex source, Vertex destination) {
		this.source = source;
		this.destination = destination;
		this.weight = 1;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}
	
	
	public String toString() {
	    StringBuffer tmp = new StringBuffer("Edge[from: ");
	    tmp.append(source.getName());
	    tmp.append(",to: ");
	    tmp.append(destination.getName());
	    tmp.append(", cost: ");
	    tmp.append(weight);
	    tmp.append("]");
	    return tmp.toString();
	  }


}
