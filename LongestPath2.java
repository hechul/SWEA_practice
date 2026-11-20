import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] TF;
	static boolean[] visited;
	static int max;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[M][2];
			TF = new boolean[N+1][N+1];
			visited = new boolean[N+1];
			max = 0;
			
			for(int j=0; j<M; j++) {
				StringTokenizer stt = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(stt.nextToken());
				arr[j][1] = Integer.parseInt(stt.nextToken());
			}
			
			
			for(int j=1; j<=N; j++) { // 정점 1에서시작 2에서시작 3에서시작 4에서시작해서 쭉 따라갔을때 어디까지 가능한지?
				visited[j] = true; // 정점 j를 방문
				dfs(j,1); 
				visited[j] = false;
			}
			
			
			bw.write("#" + i + " " + max + "\n");
			
			
//			1 2
//			3 2
//          2 1
			
			
		}
		bw.flush();
		bw.close();
	
	}
	static void dfs(int start,int count) { // start 는 현재 정점 위치임
		if(max < count) {
			max = count;
		}
		
		for(int i=0; i<M; i++) {
			if(arr[i][0] == start && visited[arr[i][1]] == false) { // 현재 정점 위치가 탐색 지점에 있다면 
				
				visited[arr[i][1]] = true; // 다음 탐색지점 방문 
				start = arr[i][1];   // 다음 탐색 지점으로 이동하고 카운트 증가
				dfs(start,count+1);
				visited[arr[i][1]] = false;
				start = arr[i][0];		
			}
			else if(arr[i][1] == start && visited[arr[i][0]] == false){
				
				visited[arr[i][0]] = true;
				start = arr[i][0];
				dfs(start,count+1);
				visited[arr[i][0]] = false;
				start = arr[i][1];
			}
		}
		
	}
		
}
