import java.io.*;
import java.util.*;

public class Solution{

	static int N;
	static boolean[] TF;
	static int[] arr1;
	static int[] arr2;
	static boolean result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		for(int i=1; i<=10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			TF = new boolean[N];
			
			result = false;
			arr1 = new int[N];
			arr2 = new int[N];
			
			
			StringTokenizer stt = new StringTokenizer(br.readLine());
			
			
			// 0 1 0 2 1 4 1 3 4 8 4 3 2 9 2 5 5 6 5 7 7 99 7 9 9 8 9 10 6 10 3 7

			int k = 0;
			for(int j=1; j<=N*2; j++) {
				if(j % 2 == 1) {
					arr1[k] = Integer.parseInt(stt.nextToken());
				}
				else if(j % 2 == 0) {
					arr2[k] = Integer.parseInt(stt.nextToken());
					k++;
				}
			}
			// arr1[0] , arr[0] 이 한 쌍으로 묶임
			
			for(int j=0; j<N; j++) {
				if(arr1[j] == 0) { // arr1을 0부터 N까지 돌아보면서 0과 이어진 간선이 있으면
					TF[j] = true;
					dfs(arr2[j],j); // arr2로 이동
				}
				
			}
			if(result == true) {
				bw.write("#" + i + " " + 1  + "\n");
			}
			else {
				bw.write("#" + i + " " + 0  + "\n");
			}
			
		}
		bw.flush();
		bw.close();
		
	}
	static void dfs(int vertex, int m) { // vertex 현재 좌표의 값
		if(vertex == 99) {
			result = true;
			return;
		}
		TF[m] = true;
		
		for(int i=0; i<N; i++) {
			if(arr1[i] == vertex && TF[i] == false) {
				dfs(arr2[i],i); 
			}
		}
		
		TF[m] = false;
		
	}
	
}