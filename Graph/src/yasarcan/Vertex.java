package yasarcan;

import java.util.ArrayList;
import java.util.List;

class Vertex<T> {
	private T data;
	private Color color;

	private List<Edge<T>> incomingEdges;

	private List<Edge<T>> outgoingEdges;

	private String name;

	public Vertex(String n) {
		this(n, null);
	}

	public Vertex(String n, T data) {
		incomingEdges = new ArrayList<Edge<T>>();
		outgoingEdges = new ArrayList<Edge<T>>();
		name = n;
		color = Color.WHITE;
		this.data = data;
	}

	public Vertex(T data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public T getData() {
		return this.data;
	}

	public Vertex<T> setColor(Color color) {
		this.color = color;
		return this;
	}

	public Color getColor() {
		return color;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean addEdge(Edge<T> e) {
		if (e.getFrom() == this)
			outgoingEdges.add(e);
		else if (e.getTo() == this)
			incomingEdges.add(e);
		else
			return false;
		return true;
	}

	public void addOutgoingEdge(Vertex<T> to, int cost) {
		Edge<T> out = new Edge<T>(this, to, cost);
		outgoingEdges.add(out);
	}

	public void addIncomingEdge(Vertex<T> from, int cost) {
		Edge<T> out = new Edge<T>(this, from, cost);
		incomingEdges.add(out);
	}

	public boolean hasEdge(Edge<T> e) {
		if (e.getFrom() == this)
			return incomingEdges.contains(e);
		else if (e.getTo() == this)
			return outgoingEdges.contains(e);
		else
			return false;
	}

	public boolean remove(Edge<T> e) {
		if (e.getFrom() == this)
			incomingEdges.remove(e);
		else if (e.getTo() == this)
			outgoingEdges.remove(e);
		else
			return false;
		return true;
	}

	public int getIncomingEdgeCount() {
		return incomingEdges.size();
	}

	public Edge<T> getIncomingEdge(int i) {
		return incomingEdges.get(i);
	}

	public List getIncomingEdges() {
		return this.incomingEdges;
	}

	public int getOutgoingEdgeCount() {
		return outgoingEdges.size();
	}

	public Edge<T> getOutgoingEdge(int i) {
		return outgoingEdges.get(i);
	}

	public List getOutgoingEdges() {
		return this.outgoingEdges;
	}

	public Edge<T> findEdge(Vertex<T> dest) {
		for (Edge<T> e : outgoingEdges) {
			if (e.getTo() == dest)
				return e;
		}
		return null;
	}

	public Edge<T> findEdge(Edge<T> e) {
		if (outgoingEdges.contains(e))
			return e;
		else
			return null;
	}

	public int cost(Vertex<T> dest) {
		if (dest == this)
			return 0;

		Edge<T> e = findEdge(dest);
		int cost = Integer.MAX_VALUE;
		if (e != null)
			cost = e.getCost();
		return cost;
	}

	public boolean hasEdge(Vertex<T> dest) {
		return (findEdge(dest) != null);
	}

	public Boolean visited() {
		return color == Color.WHITE;
	}

	public void clearMark() {
		this.color = Color.WHITE;
	}

	public String toString() {
		StringBuffer tmp = new StringBuffer("Vertex(");
		tmp.append(name);
		tmp.append(", data=");
		tmp.append(data);
		tmp.append("), in:[");
		for (int i = 0; i < incomingEdges.size(); i++) {
			Edge<T> e = incomingEdges.get(i);
			if (i > 0)
				tmp.append(',');
			tmp.append('{');
			tmp.append(e.getFrom().name);
			tmp.append(',');
			tmp.append(e.getCost());
			tmp.append('}');
		}
		tmp.append("], out:[");
		for (int i = 0; i < outgoingEdges.size(); i++) {
			Edge<T> e = outgoingEdges.get(i);
			if (i > 0)
				tmp.append(',');
			tmp.append('{');
			tmp.append(e.getTo().name);
			tmp.append(',');
			tmp.append(e.getCost());
			tmp.append('}');
		}
		tmp.append(']');
		return tmp.toString();
	}
}
