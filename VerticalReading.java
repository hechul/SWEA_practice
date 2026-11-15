import java.io.*;
import java.util.*;


public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			char[][] arr = new char[5][15];
			String sentence = "";
			
			for(int j=0; j<5; j++) { // 배열 채우
				String S = br.readLine();
				for(int k=0; k<S.length(); k++) {
					arr[j][k] = S.charAt(k);
				}
			}
			
			for(int j=0; j<15; j++) {
				for(int k=0; k<5; k++) {
					if(arr[k][j] != 0) {
					sentence += arr[k][j];
					}
				}
			}
			
			bw.write("#" + i + " " + sentence + "\n");
			
			
			
		}
		bw.flush();
		bw.close();
		
		
	}
	
	
}