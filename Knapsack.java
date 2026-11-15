import java.io.*;
import java.util.*;


public class Solution{
	static int[][] arr;
	static int[][] dp;
	static int N;
	static int K;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 물건의 개수
			K = Integer.parseInt(st.nextToken()); // 가방의 부피
			
			arr = new int[N][2];
			dp = new int[N+1][K+1];
			
			for(int j=0; j<N; j++) {
				StringTokenizer stt = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(stt.nextToken());
				arr[j][1] = Integer.parseInt(stt.nextToken());
			}
			// 가방 부피 - 5
			// arr = 1 2 부피와 가치
//         부피 가치
//			1 2
//			3 2
//			4 4
//			2 3
			//     1   2    3    4    5
			// dp- 2   2    2    2    2
			//     2   2    2    4    4
			//     2   2    2    4    6
			//     2   3    5    5    6
			//
			
			for(int j=0; j<N; j++) { // 이물건으로 이 부피를 가질때 최대가치는 이 정도이다.
				for(int k=0; k<=K; k++) {
					dprotate(j,k);

				}
			}
			bw.write("#" + i + " " + dp[N][K] + "\n");
			
			
			
			
			
			
		}
		
	
		
		bw.flush();
		bw.close();
		
	}
	static void dprotate(int j, int k) {
		dp[j+1][k] = dp[j][k];  // 현재 물건을 넣지 않는 경우
		
		if(k >= arr[j][0]) { // 지금 물건의 부피가 허용되는 크기에 있을 때
			dp[j+1][k] = Math.max(dp[j][k], dp[j][k-arr[j][0]] + arr[j][1]); // 
		}
		
		
		
		
	}
	
	
}