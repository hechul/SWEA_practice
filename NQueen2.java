import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static int[][] FN;
	static int count;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			N = Integer.parseInt(br.readLine());
			
			FN = new int[N][N]; // 몇행 몇열에 있는지?
			
			count = 0;
			
			dfs(0);
			
			
			
			bw.write("#" + i + " " + count + "\n");
			
			// 1행
			// 2행
			//  0 1 2 3 4 5
			//0 0 0 0 0 0 0 
			//1 0 0 0 0 0 0
			//2 0 0 0 0 0 0       00 11 22 33 대각선 오른쪽 아래 현재 좌표에서 오른쪽 아래 -> x-1 y-1 왼쪽 위 -> x+1 y+1
			//3 0 0 0 0 0 0		  20 31 42 53 
			//4 0 0 0 0 0 0       33 24 15 대각선 오른쪽 위                오른쪽 위 -> x+1 y-1  왼쪽 아래 -> x-1 y+1
			//5 0 0 0 0 0 0		  23 32 41 50
			
		}

		bw.flush();
		bw.close();
		
	}
	
	// N이 2일때
	static void dfs(int y) { // 0행 0열부터 시작
		
		if(y == N) {
			count++;
			return;
		}
		
			for(int k=0; k<N; k++) { // 0열 1열 2열 3열
				boolean b = false;
				for(int l=0; l<N; l++) { // 지금 퀸넣으려는 곳 x 좌표 위 아래를 보았을 때 1이 존재한다? b = true
					if(FN[l][k] == 1) {
						b = true;
					}
					if(y+l <N && k+l < N) { // 범위를 넘지 않고
						if(FN[y+l][k+l] == 1) { // 이중에서 1을 하나라도 발견한다면
							b = true;
						}
					}
					if(y-l>=0 && k-l >=0) {
						if(FN[y-l][k-l] == 1) {
							b = true;
						}
					}
					if(y+l < N && k-l >=0) {
						if(FN[y+l][k-l] == 1) {
							b = true;
						}
					}
					if(y-l>=0 && k+l < N) {
						if(FN[y-l][k+l] == 1) {
							b = true;
						}
					}
				}
				if(b == false) { // 지금 행에서 지금 x 좌표에 퀸 넣을 수 있으면 다음 dfs로 이동
					FN[y][k] = 1;      // j행 k열에 퀸을 넣음 
					dfs(y+1);        // 1행 밑으로 이동
					FN[y][k] = 0;
				}
			}
	}
	
}