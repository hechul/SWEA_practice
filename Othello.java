import java.io.*;
import java.util.*;

public class Solution{
 
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // NxN 배열
			M = Integer.parseInt(st.nextToken()); // 플레이어가 돌을 놓는 횟수
			arr = new int[N][N];
			
			int B = 0;
			int W = 0;
			// 1이면 흑돌 2면 백돌 
			arr[N/2][N/2] = 2;
			arr[N/2][N/2-1] = 1;
			arr[N/2-1][N/2] = 1;
			arr[N/2-1][N/2-1] = 2;
			
			int[] dol = new int[3];
			
			
			for(int j=0; j<M; j++) {
				StringTokenizer stt = new StringTokenizer(br.readLine());
				dol[0] = Integer.parseInt(stt.nextToken());
				dol[1] = Integer.parseInt(stt.nextToken());
				dol[2] = Integer.parseInt(stt.nextToken());
				
				location(dol[0]-1,dol[1]-1,dol[2]);
				
				
			}
			
			
			for(int k=0; k<N; k++) {
				for(int l=0; l<N; l++) {
					if(arr[k][l] == 1) {
						B++;
					}
					else if(arr[k][l] == 2) {
						W++;
					}
				}
			}
			
			
			bw.write("#" + i + " " + B + " " + W + "\n");
			

		}
		
		bw.flush();
		bw.close();
	
		// 1 흑돌 2 백돌
	}
	static void location(int x, int y, int WB) { // 현재 위치가 돌을 놓을 수 있는 위치인지 판별
		
		int[] ny = {-1,1,0,0,-1,1,-1,1};
		int[] nx = {0,0,-1,1,-1,1,1,-1};
		
		
		for(int i=0; i<8; i++) { // 8방향 탐
			int ty = 0;
			int tx = 0;
			int tty = 0;
			int ttx = 0;
			int meet = 0;
			int count = 0;
			while(y+ty+ny[i] < N && x+tx+nx[i] < N && y+ty+ny[i] >= 0 && x+tx+nx[i] >= 0) { // 배열 범위 안에 있을때
				ty += ny[i]; // 지금방향으로 이동하면서 탐색
				tx += nx[i]; 
				count++;
				if(WB == 1) { // 지금 놓으려는 색이 흑돌이라면 일단 
					if(arr[y+ty][x+tx] == 2) { // 진행하는 방향으로 이동하면서 백돌을 찾는다.
						meet = 2;
					}
					if(arr[y+ty][x+tx] == 0) {
						break;
					}
					if (arr[y+ty][x+tx] == 1 && meet == 0) {
					    break;
					}
					if(arr[y+ty][x+tx] == 1 && meet == 2) { // 백돌을 만났었고 지금 흑돌을 만났다면
						arr[y][x] = 1;
						for(int j=0; j<count; j++) { // 현재 백돌을 거쳐 흑돌을 만나기까지 횟수만큼 탐 
							tty += ny[i];
							ttx += nx[i];
							if(arr[y+tty][x+ttx] != 0) {
								arr[y+tty][x+ttx] = 1;
							}
						}
						break;
					}
				}
				else if(WB == 2) { // 지금 놓으려는 색이 백돌이라면 일단 
					if(arr[y+ty][x+tx] == 1) { // 진행하는 방향으로 이동하면서 흑돌을 찾는다.
						meet = 1;
					}
					if(arr[y+ty][x+tx] == 0) {
						break;
					}
					if (arr[y+ty][x+tx] == 2 && meet == 0) {
					    break;
					}
					if(arr[y+ty][x+tx] == 2 && meet == 1) { // 흑돌을 만났었고 지금 백돌을 만났다면
						arr[y][x] = 2;
						for(int j=0; j<count; j++) { // 현재 흑돌을 거쳐 백돌을 만나기까지 횟수만큼 탐 
							tty += ny[i];
							ttx += nx[i];
							if(arr[y+tty][x+ttx] != 0) {
								arr[y+tty][x+ttx] = 2;
							}
						}
						break;
					}
				}
			}
			
			
			
		}
		
		
		
	}

	
}