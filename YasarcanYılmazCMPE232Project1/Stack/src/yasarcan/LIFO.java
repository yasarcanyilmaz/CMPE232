package yasarcan;

public class LIFO implements ILIFO {
	int sizeofarray;
    Object SampleArray[];
    int insert;
	
	public LIFO(int size){
		sizeofarray=size;
		insert=0;
		SampleArray = new Object[sizeofarray];
		
	}

	@Override
	public boolean insert(Object o) {
		if(isFull() == true)
			throw new ArrayIndexOutOfBoundsException(); 
		SampleArray[insert++]=o;
					return true;

	}

	@Override
	public Object extract() {
		if (isEmpty())
			return "Stack is empty";
		return SampleArray[--insert];
	}

	@Override
	public boolean isEmpty() {
		return insert == 0;
	}
	public boolean isFull(){
		return insert == sizeofarray;
	}


}
