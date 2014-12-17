package yasarcan;

import static org.junit.Assert.*;
import org.junit.Test;

public class RodCuttingTest {
	/*
	 * @Test public void testInitilaze() { fail("Not yet implemented"); }
	 */
	@Test
	public void testCutRod() {
		int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		int[] results ={0,1,5,8,10,13,17,18,22,25,30};
		for(int i=0;i<prices.length;i++){
			assertEquals(results[i], RodCutting.cutRod(prices, i));
		}

	}

	@Test
	public void testCutRodMemoized() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		int[] results ={0,1,5,8,10,13,17,18,22,25,30};
		for(int i=0;i<prices.length;i++){
			assertEquals(results[i], RodCutting.cutRodMemoized(prices, i));
		}

	}

	@Test
	public void testBottomUp() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		int[] results ={0,1,5,8,10,13,17,18,22,25,30};
		
		for(int i=0;i<prices.length;i++){
			assertEquals(results[i], RodCutting.BottomUp(prices, i));
		}

	}
	@Test
	public void testAll(){
		int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		int[] results ={0,1,5,8,10,13,17,18,22,25,30};
		for(int i=0;i<prices.length;i++){
			assertEquals(results[i], RodCutting.cutRod(prices, i));
			assertEquals(results[i], RodCutting.cutRodMemoized(prices, i));
			assertEquals(results[i], RodCutting.BottomUp(prices, i));
		}
		
	}

	@Test
	public void testCompare() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		for (int i = 0; i < 11; i++) {
			RodCutting.timeCompare(prices, i);

		}

	}

}
