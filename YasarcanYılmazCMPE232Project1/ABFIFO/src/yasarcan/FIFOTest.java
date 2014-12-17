package yasarcan;

import static org.junit.Assert.*;

import org.junit.Test;

public class FIFOTest {
	
	@Test
	public void testExtract2() {
		FIFO myf = new FIFO(4);
	    assertEquals("Queue is empty!", myf.Extract());
	}

	@Test
	public void testExtract() {
		FIFO myf = new FIFO(4);
	    myf.insert(3);
	    myf.insert(5);
	    assertEquals(3, myf.Extract());
	}
	
	@Test
	public void testExtract3() {
		FIFO myf = new FIFO(4);
		myf.insert(1);
		myf.insert(2);
		myf.insert(3);
	    assertEquals(1, myf.Extract());
	}

	@Test
	public void testInsert() { 
	FIFO myf = new FIFO(4);
    Object o1= new Object();
    Object o2= new Object();
    assertEquals(true, myf.insert(o1));
    assertEquals(true, myf.insert(o2));
	}

	@Test
	public void testInsert2() { 
	FIFO myf = new FIFO(4);
    myf.insert(1);
    myf.insert(2);
    myf.insert(3);
    assertEquals(false, myf.insert(6));
    //we create an array with length size-1 to be make it circular. That's why, we can not insert (data.length). item to array.
	}

	@Test
	public void testIsFull() {
		FIFO myf = new FIFO(4);
	    myf.insert(1);
	    myf.insert(2);
	    myf.insert(3);
	    assertEquals(true, myf.isFull());
	}

	@Test
	public void testIncrIndex() {
		FIFO myf = new FIFO(4);
		assertEquals(1,myf.IncrIndex(4));
	}

	@Test
	public void testIsEmpty() {
		FIFO myf = new FIFO(3);
        assertEquals(true, myf.isEmpty());
	}
	
	@Test
	public void testIsEmpty2() {
		FIFO myf = new FIFO(3);
		myf.insert(5);
        assertEquals(false, myf.isEmpty());
	}
	
	@Test
	public void testIsEmpty3() {
		FIFO myf = new FIFO(3);
		myf.insert(5);
		myf.insert(3);
        assertEquals(false, myf.isEmpty());
	}
	
	@Test
	public void testIsEmpty4() {
		FIFO myf = new FIFO(2);
		myf.insert(5);
        assertEquals(false, myf.isEmpty());
	}
	

}
