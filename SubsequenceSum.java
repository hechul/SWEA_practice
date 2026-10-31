import java.io.*;
import java.util.*;

public class Solution{
	static int[] arr;
	static int N;
	static int K;
	static int count;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			count = 0;
			arr = new int[N];
			
			StringTokenizer stt = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) { // 배열 채우기 
				arr[j] = Integer.parseInt(stt.nextToken());
			}
			
			// 4 3
			// 1 2 1 2
			// arr안에 있는 조합들로 K의 완성을 만족하는지 보아야 함
			dfs(0,0);
			bw.write("#" + i + " " + count + "\n");
			
		}
		bw.flush();
		bw.close();
		
	}
	static void dfs(int result,int i) {
		if(result == K) {
			count++;
			return;
		}
		if(i == N) { 
			return;
		}
		// arr 0을 포함할지 안할지 1을 포함할지 안할지 
		dfs(result,i+1); // 현재 위치를 포함하지 않고 인덱스 1증가
		result += arr[i];
		dfs(result,i+1); // 현재 위치를 포함하고 인덱스 1증가 
		
	}
}