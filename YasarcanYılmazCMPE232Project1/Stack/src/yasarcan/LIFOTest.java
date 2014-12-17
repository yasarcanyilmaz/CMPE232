package yasarcan;

import static org.junit.Assert.*;

import org.junit.Test;

public class LIFOTest {

	@Test
	public void testInsert() {
		LIFO myl = new LIFO(2);
		Object o1= new Object();
		assertEquals(true, myl.insert(o1));
	}
	
	@Test
	public void testExtract() {
		LIFO myl = new LIFO(2);
		assertEquals("Stack is empty", myl.extract());
	}
	@Test
	public void testExtract2() {
		LIFO myl = new LIFO(2);
		myl.insert(5);
		assertEquals(5, myl.extract());
	}
	
	@Test
	public void testExtract3() {
		LIFO myl = new LIFO(10);
		myl.insert(5);
		myl.insert(6);
		myl.insert(7);
		myl.insert(8);
		myl.insert(9);
		myl.insert(10);
		assertEquals(10, myl.extract());
	}

	@Test
	public void testIsEmpty() {
		LIFO myl = new LIFO(3);
        assertEquals(true, myl.isEmpty());
	}
	@Test
	public void testIsEmpty2() {
		LIFO myl = new LIFO(2);
		Object o1= new Object();
		myl.insert(o1);
        assertEquals(false, myl.isEmpty());
	}
	@Test
	public void testIsFull() {
		LIFO myl = new LIFO(2);
		Object o1= new Object();
		myl.insert(o1);
		myl.insert(3);
		assertEquals(true, myl.isFull());
	}
	@Test
	public void testIsFull2() {
		LIFO myl = new LIFO(2);
		Object o1= new Object();
		myl.insert(o1);
		//myl.insert(3);
		assertEquals(false, myl.isFull());
	}
	


}
