import java.io.*;
import java.util.*;

public class Solution{
	static int[] arr;
	static int N;
	static int K;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			count = 0;
			StringTokenizer stt = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(stt.nextToken());
			}
			
			dfs(0,0);

			bw.write("#" + i + " " + count + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	// 1 2 1 2
	
	static void dfs(int index,int result) {
		if(result == K) {
			count++;
			return;
		}
		if(index == N) {
			return;
		}		
		dfs(index+1,result);                // arr[0] 을 넣지 않고 다음으로
		
		dfs(index+1,result + arr[index]);   // arr[0] 을 넣고 다음으로 
		
	}
	

}