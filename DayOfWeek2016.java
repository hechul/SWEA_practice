import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int Month = Integer.parseInt(st.nextToken());
			int Day = Integer.parseInt(st.nextToken());
			
			int[][] D = new int[13][32];
			
			// 1/1 -> 금  1/2-> 토 1/3 -> 일 1/4 월 1/5화 1/6수 1/7목 1/8금 
			
			// 4 6 9 11  - 30일 
			// 2 - 29일 
			
			int now = 4;
			
			for(int j=1; j<=12; j++) {
				if(j == 4 || j == 6 || j == 9 || j == 11) {
					for(int k=1; k<=30; k++) {
						if(now  == 7) {
							now = 0;
						}
						D[j][k] = now;
						now++;
					}
				}
				else if(j == 2) {
					for(int k=1; k<=29; k++) {
						if(now  == 7) {
							now = 0;
						}
						D[j][k] = now;
						now++;
					}
				}
				else {
					for(int k=1; k<=31; k++) {
						if(now  == 7) {
							now = 0;
						}
						D[j][k] = now;
						now++;
					}
				}
			}
			
			
			bw.write("#" + i + " " + D[Month][Day] + "\n");
			
			
			
			
			
			
			
		}
		bw.flush();
		bw.close();
	
	}

	

}