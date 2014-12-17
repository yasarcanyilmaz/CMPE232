package yasarcan;

public class FIFO implements INTERFACEFIFO {
	Object[]data;
	int insertPointer;
	int extractPointer;
	
	public FIFO(int size){
		data=new Object[size];
		insertPointer=0;
		extractPointer=0;
	}
	
	public Object Extract() {
		if (isEmpty()) 
			return "Queue is empty!";
		Object tmp= data[extractPointer];
		extractPointer=IncrIndex(extractPointer);
		return tmp;
	}

	public boolean insert(Object o) {
		if(isFull()) 
		return false;
		data[insertPointer]=o;
		insertPointer=IncrIndex(insertPointer);
		return true;
	}

	boolean isFull() {
		return extractPointer == IncrIndex(insertPointer);
	}
	
	int IncrIndex(int num) {
		return (num+1) % data.length;
	}
	
	public boolean isEmpty() {
		return insertPointer == extractPointer;
	}

}
