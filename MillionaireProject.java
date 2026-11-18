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

			
			// 1, 2, 3 1,2를 사서 3에 판매하면 3의 이득이 생긴다
			// 최대한의 이득을 얻도록 구성하기
			
			// 1 1 3 1 2
			// 1 7 8 4 2
			// 1에 구매, 1에 구매, 3에 판매, 1에 구매, 2에 판매
			
			// arr[j] < arr[j+1] 이렇다면 j는 무조건 사는게 이득이다.
			
//			int sum = 0;
//			int count = 0;
//			int result = 0;
			
			int max = 0;
			long result = 0;
			
			for(int j=N-1; j>=0; j--) {
				if(arr[j] > max)  max = arr[j];
				else result += max - arr[j];
			}
			
			
			
//			for(int j=0; j<N; j++) {
//				boolean TF = false;
//				for(int k=j+1; k<N; k++) {
//					if(arr[j] < arr[k]) { // 지금 인덱스보다 뒤에 더 큰게 하나라도 있으면 TF = true 
//						TF = true;
//						sum += arr[j];
//						count++;
//						break;
//					}
//					// 지금이 판매시점인지 보기
//					// 만약 지금 인덱스의값 보다 뒤에 큰게 없다면(TF == false 라면) 지금까지 쌓아놓은거 팔고
//					// 다시 반복 
//				}
//				if(TF == false) {
//					result += arr[j]*count - sum;
//					count = 0;
//					sum = 0;
//				}
//			}
			
			bw.write("#" + i + " " + result + "\n");
			

			
			
		}
		bw.flush();
		bw.close();
		
		
	}

	

}