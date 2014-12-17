package yasarcan;

public interface IPQueue {
	public boolean isLeaf(int position);
	public int leftchild(int position);
	public int rightchild(int position);
	public int parent(int position);
	public void insert(int o);
	public void corrected(int position);
	public int extract();
	

}
