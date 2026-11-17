import java.io.*;
import java.util.*;

public class Solution{
	static String S;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			S = br.readLine(); // apa
			
			// aaa, aap, apa, app, paa, pap, ppa, ppp
			
			char[] arr = new char[S.length()];
			
			for(int j=0; j<S.length(); j++) {
				arr[j] = S.charAt(j);
			
			}
			
			
			
			// 첫째자리는 지금 유지, 뒤에꺼로 바꾸기 둘중하나밖에 안됨
			// 마지막자리는 지금 유지, 앞에껄 바꾸기 둘중하나밖에 안됨
			
			// apa
			
			
			// aaca
			
			// a
			// 0a00
			
			long result = 1; 
			for(int j=0; j<S.length(); j++) {
				int cnt = 1;
				if(j > 0 && S.charAt(j-1) != S.charAt(j)) cnt++; // j가 0보다 크고 앞에꺼랑 지금꺼랑 같지 않으면 cnt++;
				if(j+1 < S.length() && S.charAt(j+1) != S.charAt(j) && (j == 0 || S.charAt(j+1) != S.charAt(j-1))) {
					// 뒤에꺼랑 지금꺼랑 같지 않으면 ++, 
					cnt++;
				}
				result = result * cnt % 1000000007;
				
			}
			
			bw.write("#" + i + " " + result + "\n");
			
			
			
			
			
		}
		bw.flush();
		bw.close();
		
	}

}