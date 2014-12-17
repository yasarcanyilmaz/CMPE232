package yasarcan;

/**
 * @author yasarcan
 *
 */

import java.io.BufferedReader;
import java.io.IOException;


public class LongestCommonS {

	
public static String readFromFile(BufferedReader reader) throws IOException{
	String sequence1 = reader.readLine();
	String sequence2 = reader.readLine();
	return lcs(sequence1, sequence2);
	
	
}
public static String readForMemoized(BufferedReader reader) throws IOException{
	String sequence1 = reader.readLine();
	String sequence2 = reader.readLine();
	return LcsMemoized(sequence1, sequence2);	
}
	public static String lcs(String a, String b){
	    int lengthofa = a.length();
	    int lengthofb = b.length();
	    if(lengthofa == 0 || lengthofb == 0){
	        return "";
	    }else if(a.charAt(lengthofa-1) == b.charAt(lengthofb-1)){
	        return lcs(a.substring(0,lengthofa-1),b.substring(0,lengthofb-1))
	            + a.charAt(lengthofa-1);
	    }else{
	        String tmp1 = lcs(a, b.substring(0,lengthofb-1));
	        String tmp2 = lcs(a.substring(0,lengthofa-1), b);
	        return (tmp1.length() > tmp2.length()) ? tmp1 : tmp2;
	    }
	}
	
	public static String LcsMemoized(String a, String b) {
		  int m = a.length();
	      int n = b.length();
        int[][]Memo = new int[m+1][n+1];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j))
                    Memo[i+1][j+1] = Memo[i][j] + 1;
                else 
                    Memo[i+1][j+1] = Math.max(Memo[i+1][j], Memo[i][j+1]);
            }
        }

        StringBuffer sb = new StringBuffer();
      //String sb;
        while(m != 0 && n != 0) {
            if (Memo[m][n] == Memo[m-1][n]) 
            	m--;
            else if (Memo[m][n] == Memo[m][n-1])
            	n--;
            else {
            	assert a.charAt(m-1) == b.charAt(n-1);
            	sb.append(a.charAt(m-1));
            	//sb= sb+a.charAt(m-1);
            	m--;
            	n--;
            }
    }
       
        return sb.reverse().toString();
}
	public static  void CompareTimefromFile(BufferedReader rd) throws Exception{
		String a=rd.readLine();
		String b=rd.readLine();
		long startTime=System.nanoTime();
		lcs(a, b);
		long endtime=System.nanoTime() - startTime;
		
		long startTime2=System.nanoTime();
		LcsMemoized(a, b);
		long endtime2=System.nanoTime() - startTime2;
		System.out.println("Time is "+endtime+" for recursive and "+endtime2+" for memoized, when length of common subsequence is "+LcsMemoized(a, b).length()+
				". Length of sequences are "+a.length()+" and "+b.length());
	}
	
	public static  void CompareTime(String a, String b){
		long startTime=System.nanoTime();
		lcs(a, b);
		long endtime=System.nanoTime() - startTime;
		
		long startTime2=System.nanoTime();
		LcsMemoized(a, b);
		long endtime2=System.nanoTime() - startTime2;
		System.out.println("Time is: "+endtime+" for recursive and time is"+endtime2+" for memoized.");
	}
	 

}
