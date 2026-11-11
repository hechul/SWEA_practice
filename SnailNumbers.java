import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static boolean[][] visited;
	static int[][] arr;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=T; i++) {
			N = Integer.parseInt(br.readLine()); // NxN 배열
			
			count = 0;
			arr = new int[N][N];
			visited = new boolean[N][N];
			dfs(0,0,0);

			
			bw.write("#" + i + "\n");
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					bw.write(String.valueOf(arr[j][k]) + " ");
				}
				bw.write("\n");
			}
			
			
		}
		bw.flush();
		bw.close();
	
	}
	static void dfs(int y,int x,int index) { // 0,0이 시작점, index는 현재 어디로 가고 있는지 방향을 나타냄
		count++;
		visited[y][x] = true;
		arr[y][x] = count;
		if(count == N*N) {
			return;
		}
		
		
		int[] ny = {0,1,0,-1}; // 4개의 방향대로 움직임
		int[] nx = {1,0,-1,0}; // 4개의 방향대로 움직임
		
		// 범위를 만족하고 다음 방문할 지점이 방문하지 않은 지점이라면
		if(y+ny[index]< N && y+ny[index] >=0 && x+nx[index]< N && x+nx[index] >=0 && visited[y+ny[index]][x+nx[index]] == false) {
			// 지금 진행방향으로 진행한다.
			dfs(y+ny[index],x+nx[index],index);
		}
		else {
			if(index+1 == 4) {
				index = -1;
			}
			dfs(y+ny[index+1],x+nx[index+1],index+1);
		}
		
		
		
		
	}
		
	
}