import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static int M;
	static int[][] arr;
	static boolean[] TF;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N 정점의 수
			M = Integer.parseInt(st.nextToken()); // M 간선의 수
			max = 0;
			arr = new int[M][2];
			TF = new boolean[N];
			
			for(int j=0; j<M; j++) { // 배열 초기화
				StringTokenizer stt = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(stt.nextToken());
				arr[j][1] = Integer.parseInt(stt.nextToken());
			}
			
			for(int j=1; j<=N; j++) { // 모든 정점을 시작점으로 하여 거칠 수 있는 간선의 수를 찾기 
				dfs(j,1);
			}
			
			bw.write("#" + i + " " + max + "\n");
			
		}
		bw.flush();
		bw.close();
		
	}
	static void dfs(int vertex, int count) { // 모든 정점을 시작점으로 하여 dfs 시작
		
		if(max < count) {
			max = count;
		}
		
		TF[vertex-1] = true;
		// 정점이 arr[j][0] 이랑 arr[j][1] 둘중에 하나에라도 존재한다면 
		
		for(int i=0; i<M; i++) { // 모든 간선 탐색 
			if(vertex == arr[i][0] && !(TF[arr[i][1]-1])) { // arr[j][0] 과 vertex가 같다면 arr[i][1]에 간선이 존재한다는 말임 그쪽으로 이동 + 이동하려는 곳이 false 라면
				dfs(arr[i][1],count+1);
			}
			else if(vertex == arr[i][1] && !(TF[arr[i][0]-1])) {
				dfs(arr[i][0],count+1);
			}
		}
		
		TF[vertex-1] = false;
		
	}
}

