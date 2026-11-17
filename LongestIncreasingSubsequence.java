import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			// 최대 증가 부분 수열의 길이 구하기
			// 1, 3, 2, 5, 4, 7
			// A1 = 1 A2 = 3 A3 =2 A4 = 5 A5 = 4 A6 = 7
			
			// 수열 { A1, A2, ... , AN } 이 주어짐 
			// 부분 수열 B는 다음과 같이 정의된다.
			// { B1, B2, ... , BK }에서  0≤K≤N, B1 < B2 < ... < BK이고,
			
			// B1, B2 ... K 에서 1,2,3,4,5,6 N처럼 있음
			
			// AB1 ≤ AB2 ≤ ... ≤ ABK인 최대 K로 구성된 수열
			
			// 인덱스 0 -> 뒤에 큰게 있으면 거기로
			// 인덱스 1 -> 뒤에 큰게 있으면 거기로
			
			// 10 100 20 30 40 
			
			// 1, 3, 2, 5, 4, 7
			int[] dp = new int[N];
			int max = 0;
			
			// dp 는 지금 위치를 마지막으로 선택했을때 가장 긴 수열의 길이
			for(int j=0; j<N; j++) {
				
				dp[j] = 1; // 현재 숫자 하나만 선택
				
				for(int k=0; k<j; k++) { 
					if(arr[j]>arr[k]) { 
						dp[j] = Math.max(dp[j], dp[k]+1);
					}
				}
				
				if(max < dp[j]) {
					max = dp[j];
				}
				
			}
			
			
			
			
//			for(int j=0; j<N; j++) {
//				dp[j] = arr[j];
//				int count = 1;
//				for(int k=j+1; k<N; k++) {
//					if(dp[j] < arr[k]) { // 뒤에 있는놈이 더 크면
//						dp[j] = arr[k]; // 뒤에놈을 dp[j] 에넣고 그 상태에서 비교
//						count++; // 카운트 증가 
//					}
//				}
//				if(max < count) {
//					max = count;
//				}
//			}
			
			
			bw.write("#" + i + " " + max + "\n");
			
			
			
			
		}
		
		bw.flush();
		bw.close();
		
	}

	

}