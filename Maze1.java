import java.io.*;
import java.util.*;

public class Solution{

	static int[][] arr;
	static boolean[][] visited;
	static boolean result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int i=1; i<=10; i++) {
			int T = Integer.parseInt(br.readLine());
			arr = new int[16][16];
			visited = new boolean[16][16];
			// 시작점과 도착점 미리 찾아놓
			int stx = 0;
			int sty = 0;
			result = false;
			
			for(int j=0; j<16; j++) { // 배열 채우
				String S = br.readLine();
				for(int k=0; k<16; k++) {
					arr[j][k] = S.charAt(k) - '0';
					if(arr[j][k] == 2) {
						sty = j;
						stx = k;
					}
				}
			}
			
			
			dfs(sty, stx);
			
			if(result) {
				bw.write("#" + i + " " + 1 + "\n");
			}
			else if(!result) {
				bw.write("#" + i + " " + 0 + "\n");
			}
			
			
		}
		bw.flush();
		bw.close();
	}
	static void dfs(int y, int x) {
		
		if(arr[y][x] == 3) {
			result = true;
			return;
		}
		
		
		visited[y][x] = true;
		
		int[] ny = {0,0,-1,1};
		int[] nx = {-1,1,0,0};
		
		for(int i=0; i<4; i++) {
			if(!visited[y+ny[i]][x+nx[i]] && arr[y+ny[i]][x+nx[i]] != 1) {
				dfs(y+ny[i],x+nx[i]);
			}
		}
		
	}
}