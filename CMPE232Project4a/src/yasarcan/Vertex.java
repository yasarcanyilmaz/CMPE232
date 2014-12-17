/**
 * 
 */
package yasarcan;

/**
 * @author yasarcan
 * 
 */
public class Vertex<A> implements Comparable<Vertex<A>> {
	private A data;
	private Color color = Color.WHITE;
	private Vertex<A> pred;
	private int distance = Integer.MAX_VALUE;
	
	public int compareTo(Vertex<A> other){
		return Double.compare(distance, other.distance);
	}

	public Vertex(A v) {
		this.data = v;
	}

	public A getData() {
		return data;
	}

	public void setData(A data) {
		this.data = data;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Vertex<A> getPred() {
		return pred;
	}

	public void setPred(Vertex<A> pred) {
		this.pred = pred;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	

	public String toString() {
		StringBuffer tmp = new StringBuffer("Vertex ");
		tmp.append(data);
		//tmp.append(" (color=");
		//tmp.append(color);
		//tmp.append(" pred= ");
		//tmp.append(pred);
		//tmp.append(")");
		return tmp.toString();
	}
	
}
