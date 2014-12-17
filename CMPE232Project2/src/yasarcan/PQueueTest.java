package yasarcan;

import static org.junit.Assert.*;

import org.junit.Test;

public class PQueueTest {

	@Test
	public void testInsert() {
		PQueue myq = new PQueue(4);
		myq.insert(5);
		assertEquals(5, myq.extract());
		PQueue myq1 = new PQueue(5);
		myq1.insert(1);
		myq1.insert(2);
		myq1.insert(3);
		myq1.insert(4);
		myq1.insert(5);
		assertEquals(1, myq1.extract());
		PQueue myq2 = new PQueue(18);
		myq2.insert(23);
		myq2.extract();
		myq2.insert(22);
		myq2.insert(21);
		myq2.extract();
		myq2.insert(20);
		myq2.insert(29);
		myq2.insert(28);
		myq2.extract();
		myq2.insert(27);
		myq2.insert(26);
		myq2.insert(25);
		myq2.insert(24);
		myq2.extract();
		assertEquals(29, myq2.extract());
		
		
		
	}

	@Test
	public void testMax(){
		PQueue myq = new PQueue(5);
		myq.insert(5);
		assertEquals(5, myq.max());
		PQueue myq1 = new PQueue(5);
		myq1.insert(5);
		myq1.insert(4);
		assertEquals(4, myq1.max());
		PQueue myq2 = new PQueue(3);
		myq2.insert(5);
		myq2.insert(4);
		myq2.insert(3);
		assertEquals(3, myq2.max());
		
		}
	@Test
	public void testIExtract() {
		PQueue myq = new PQueue(10);
		myq.insert(1);
		myq.insert(2);
		myq.insert(3);
		myq.insert(4);
		myq.insert(5);
		myq.insert(6);
		myq.insert(7);
		myq.insert(8);
		myq.insert(9);
		myq.extract();
		myq.extract();
		assertEquals(8, myq.extract());
		PQueue myq1 = new PQueue(5);
		myq1.insert(1);
		myq1.insert(2);
		assertEquals(1, myq1.extract());
	}

}
