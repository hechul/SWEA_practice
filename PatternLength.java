import java.io.*;
import java.util.*;


public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=1; i<=T; i++) {
			String S = br.readLine();
			
			char[] arr = new char[30];
			
			for(int j=0; j<30; j++) {
				arr[j] = S.charAt(j);
			}
			
			// KOREAKOREAKOREAKOREAKOREAKOREA
			
			// for 문으로 30개를 돌아
			// 0번인덱스 -> 그 다음것들 for문으로 패턴
			// 1번인덱스 -> 0번+1번으로 그 다음것들 for문으로 패턴
			// 2번인덱스 -> 0번+1번+2번으로 그 다음것들 for문으로 패턴
			
			String s1 = "";
			for(int j=0; j<30; j++) {
				s1 += arr[j]; // j = 1 -  KO , j = 2 - KOR
				String s2 = "";
				for(int k=j+1; k<s1.length()+j+1; k++) { // k = 2~4, k = 3~6
					s2 += arr[k]; 
				}
				if(s1.equals(s2)) {
					break;
				}
			}
			
			bw.write("#" + i + " " + s1.length() + "\n");
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
		
		
		
	}
	
	
}