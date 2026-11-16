import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int max = 0;
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			StringTokenizer stt = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[j] = Integer.parseInt(stt.nextToken());
			}
			
			StringTokenizer sttt = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				B[j] = Integer.parseInt(sttt.nextToken());
			}
			
			if(A.length < B.length) {
				// A[0] * B[0] 
				// A[1] * B[1]
				// A[2] * B[2]
				
				// A[0] * B[1]
				
				// 4-3 -> 2
				// 5-3 -> 3 
				// 6-3 -> 4
				
				int n = 0;
				int m = 0;
				for(int j=0; j<M-N+1; j++) { // m 안에 n이 몇번 들어갈 수 있는지 총 반복
					int result = 0;
					n = 0;
					m = j;
					for(int k=0; k<N; k++) { // N의 길이만큼 반복 3/5 일때 인덱스 012 3번만 반복한다는 말임 
						result += A[n] * B[m]; // result = A[0] * B[0] + A[1] * B[1] + A[2] * B[2]
						// 두번째 올때 n은 012 m은 123이 와야함
						n++;
						m++;
					}
					if(max < result) {
						max = result;
					}
				}
				
			}
			else {
				int n = 0;
				int m = 0;
				for(int j=0; j<N-M+1; j++) { // N 안에 M이 몇번 들어갈 수 있는지 총 반복
					int result = 0;
					n = j;
					m = 0;
					for(int k=0; k<M; k++) { 
						result += A[n] * B[m]; 
						n++;
						m++;
					}
					if(max < result) {
						max = result;
					}
				}
			}
			
			bw.write("#" + i + " " + max + "\n");
			
			
			
		}
		bw.flush();
		bw.close();
		
		
		
		
	}
	
}