package yasarcan;

public class PQueue implements IPQueue {
	
	int[] Array; //Heap Array
	int size;
	int n;
	// Pointer to the heap array
	// Maximum size of the heap
	// Number of things in heap
	public PQueue(int maxSizeOfArray){
		size=maxSizeOfArray;
		Array=new int[size];
		n=0;
		}

	@Override
	public boolean isLeaf(int position) {
		// TODO Auto-generated method stub
		return (position >= n/2) && (position < n);
	}

	@Override
	public int leftchild(int position) {
		// TODO Auto-generated method stub
		assert position < n/2 : "Position has no left child";
		  return 2*position + 1;
	}

	@Override
	public int rightchild(int position) {
		// TODO Auto-generated method stub
		assert position < (n-1)/2 : "Position has no right child";
		  return 2*position + 2;
	}

	@Override
	public int parent(int position) {
		// TODO Auto-generated method stub
		assert position > 0 : "Position has no parent";
		  return (position-1)/2;
	}
	public static void swap(int[] array, int p1, int p2) { 
	int temp = array[p1];
    array[p1] = array[p2];
    array[p2] = temp;
	}
	
	@Override
	public void insert(int o) {
		// TODO Auto-generated method stub
		assert n < size : "Heap is full!!";
		  int curr = n++;
		  Array[curr] = o;            
		  // Now need to correct the place in array until curr’s parent’s key > curr’s key
		  while ((curr != 0)  && (Array[curr] < (Array[parent(curr)]))) {
		    swap(Array, curr, parent(curr));
		    curr = parent(curr);
		} }
	@Override
	public void corrected(int position) {
		  assert (position >= 0) && (position < n) : "NOT POSSIBLE heap position";
		  while (!isLeaf(position)) {
		    int j = leftchild(position);
		    if ((j<(n-1)) && (Array[j] < (Array[j+1])))
		      j++; 
		    if (Array[position] - (Array[j]) >= 0) return;
		    swap(Array, position, j);
		    position = j;  
		} }

	@Override
	public int extract() {
			// TODO Auto-generated method stub
		assert n > 0 : "Not Able to Remove from an empty heap";
		 swap(Array, 0, --n); // Swap maximum with last value
		  if (n != 0)      // Not on last element
		    corrected(0);   // Put new heap root value in correct place
		  return Array[n];
	}
	public int max(){
		return Array[0];
	}


}
