package yasarcan;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

public class LongestCommonSTest {
	@Test
	public void testLcs() {
		assertEquals("", LongestCommonS.lcs("a", "b"));
		assertEquals("b", LongestCommonS.lcs("b", "b"));
		assertEquals("ab", LongestCommonS.lcs("ab", "ab"));
		assertEquals("ab", LongestCommonS.lcs("abc", "adeb"));
		assertEquals("bdg", LongestCommonS.lcs("abcdefg", "cbdgshx"));
		assertEquals("bdg", LongestCommonS.lcs("abcdefg", "cbdgshx"));
		assertEquals("", LongestCommonS.lcs("abcdefg", "tuvyz"));
	}
	
	@Test
	public void testLcsM() {
		assertEquals("", LongestCommonS.LcsMemoized("a", "b"));
		assertEquals("b", LongestCommonS.LcsMemoized("b", "b"));
		assertEquals("ab", LongestCommonS.LcsMemoized("ab", "ab"));
		assertEquals("ab", LongestCommonS.LcsMemoized("abc", "adeb"));
		assertEquals("bdg", LongestCommonS.LcsMemoized("abcdefg", "cbdgshx"));
		assertEquals("bdg", LongestCommonS.LcsMemoized("abcdefg", "cbdgshx"));
		assertEquals("", LongestCommonS.LcsMemoized("abcdefg", "tuvyz"));
	}

	@Test
	public void testLcs1() throws Exception {
	
		BufferedReader br = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test1"));
		BufferedReader br2 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test2"));

		BufferedReader br3 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test3"));
		BufferedReader br4 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test4"));
		BufferedReader br5 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test5"));
		BufferedReader br6 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test6"));
		BufferedReader br7 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test7"));
		assertEquals("x", LongestCommonS.readFromFile(br));
		assertEquals("", LongestCommonS.readFromFile(br2));
		assertEquals("bdg", LongestCommonS.readFromFile(br3));
		assertEquals("x", LongestCommonS.readFromFile(br4));
		assertEquals("", LongestCommonS.readFromFile(br5));
		assertEquals("abcdefghijklm", LongestCommonS.readFromFile(br6));
		assertEquals("", LongestCommonS.readFromFile(br7));

	}

	@Test
	public void testLcs2() throws Exception {
		
		BufferedReader br = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test1"));
		BufferedReader br2 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test2"));

		BufferedReader br3 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test3"));
		BufferedReader br4 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test4"));
		BufferedReader br5 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test5"));
		BufferedReader br6 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test6"));
		BufferedReader br7 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test7"));
		assertEquals("x", LongestCommonS.readForMemoized(br));
		assertEquals("", LongestCommonS.readForMemoized(br2));
		assertEquals("bdg", LongestCommonS.readForMemoized(br3));
		assertEquals("x", LongestCommonS.readForMemoized(br4));
		assertEquals("", LongestCommonS.readForMemoized(br5));
		assertEquals("abcdefghijklm", LongestCommonS.readForMemoized(br6));
		assertEquals("", LongestCommonS.readForMemoized(br7));
	}
	@Test
	public void time() throws Exception{
		BufferedReader br = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test1"));
		BufferedReader br2 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test2"));

		BufferedReader br3 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test3"));
		BufferedReader br4 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test4"));
		BufferedReader br5 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test5"));
		BufferedReader br6 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test6"));
		BufferedReader br7 = new BufferedReader(
				new FileReader(
						"/Users/yasarcan/Documents/eclipseworks/LongestCommonSubsequence/src/yasarcan/test7"));
		
		LongestCommonS.CompareTimefromFile(br5);
		LongestCommonS.CompareTimefromFile(br4);
		LongestCommonS.CompareTimefromFile(br);
		LongestCommonS.CompareTimefromFile(br2);
		LongestCommonS.CompareTimefromFile(br3);
		LongestCommonS.CompareTimefromFile(br6);
		LongestCommonS.CompareTimefromFile(br7);
	}

}
