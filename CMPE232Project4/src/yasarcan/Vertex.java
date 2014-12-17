package yasarcan;

public class Vertex {
	private String name;
	private Color color;
	private Vertex pred;
	private int distance;

	public Vertex(String name) {
		this.name = name;
		color = Color.WHITE;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Vertex getPred() {
		return pred;
	}

	public void setPred(Vertex pred) {
		this.pred = pred;
	}

	public String toString() {
		StringBuffer tmp = new StringBuffer("Vertex:");
		tmp.append(name);
		tmp.append(" (color=");
		tmp.append(color);
		tmp.append(" pred= ");
		tmp.append(pred);
		tmp.append(")");
		return tmp.toString();
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
