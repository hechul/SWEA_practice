import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static char[][] arr;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int i=1; i<=10; i++) {
			
		    N = Integer.parseInt(br.readLine());
		    
			count = 0;
			arr = new char[8][8];
			
			for(int j=0; j<8; j++) { // 배열 채우기 
				String ar = br.readLine();
				for(int k=0; k<8; k++) {
					arr[j][k] = ar.charAt(k);
				}
			}
			
			
			
			for(int j=0; j<8; j++) { // 각 점을 시작점으로 하여 탐색 시
				for(int k=0; k<8; k++) {
					dfs(j,k);
				}
			}
			
			bw.write("#" + i + " " + count + "\n");
			
		
		}
		bw.flush();
		bw.close();
		
		
	}
	static void dfs(int y, int x) {
	    // 진행방향은 오른쪽, 아래만 탐색하면 됨 
		
		String nx = "";
		String ny = "";
		String Rnx = "";
		String Rny = "";
		
		for(int i=0; i<2; i++) { // nx 에다가 배열 오른쪽으로 N개 만큼 가져옴
			for(int j=0; j<N; j++) {
				if(i == 0 && x+j >= 0 && x+j< 8) {
					nx += arr[y][x+j]; // arr[0][1] arr[0][1]
				}
				if(i == 1 && y+j >= 0 && y+j < 8) {
					ny += arr[y+j][x];
				}
				// x축으로 1씩 이동하면서 nx에다가 값을 누적
				// y축으로 1씩 이동하면서 ny에다가 값을 누적	
			}
		} 
		for(int i=0; i<2; i++) {
			for(int j=0; j<N; j++) {
				if(i == 0 && x+N-1-j >= 0 && x+N-1-j< 8) {
					Rnx += arr[y][x+N-1-j]; // 현재 위치에서 N-1 값을 더하고 거기서 인덱스 만큼을 빼면서 Rnx에 더하기
				}
				if(i == 1 && y+N-1-j >= 0 && y+N-1-j< 8) {
					Rny += arr[y+N-1-j][x]; 
				}
			}
		}
		
		if(nx.equals(Rnx) && nx.length() == N) {
			count++;
		}
		if(ny.equals(Rny) && ny.length() == N) {
			count++;
		}
		
		
	}
	
}