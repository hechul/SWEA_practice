import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> list = new ArrayList<>();
			int[][] arr = new int[N][N];
			
			
			for(int j=0; j<N; j++) { // 4열 반복 
				for(int k=0; k<j+1; k++) { // 1열에 한번 2열에 2번 3열에 3번 
					if(k == 0) { // 처음 시작은 항상 1임
						arr[j][k] = 1;
					}
					else if(k == j) { // 마지막은 항상 1임
						arr[j][k] = 1;
					}
					else {
						arr[j][k] = arr[j-1][k-1] + arr[j-1][k];
					}
				}
			}
			
			
			//	   1     
			//    1 1   
			//   1 2 1
			//  1 3 3 1
			// 1 4 6 4 1

			
			bw.write("#" + i + "\n");
			
			for(int j=0; j<N; j++) { 
				for(int k=0; k<j+1; k++) {
					bw.write(String.valueOf(arr[j][k]) + " ");					
					
				}
				bw.write("\n");
			}
			
			
		}
		bw.flush();
		bw.close();
		
		
		
		
		
		
	}

}