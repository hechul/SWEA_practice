import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static boolean[] TF;
	static boolean[] diagonal1; // 
	static boolean[] diagonal2; //
	static int count;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); // 1
		
		for(int i=1; i<=T; i++) {
			
			N = Integer.parseInt(br.readLine()); // 2
			TF = new boolean[N]; 
			
			diagonal1 = new boolean[2 * N - 1];
			diagonal2 = new boolean[2 * N - 1];
			count = 0;
			dfs(0,-1);
			
			
			bw.write("#" + i + " " + count + "\n");
		
		}
		
		bw.flush();
		bw.close();
		
		// 1 0
		// 2 1
		
		// 0 1
		// 1 2 
	}
	static void dfs(int y,int x) { // 0 행부터 시작
		
		if(y == N) {
			count++;
			return;
		}
		
		
		for(int i=0; i<N; i++) { // 0행일때 x값 0,1,2,3,4 로 dfs 
			if(TF[i] == false && diagonal1[y-i+N-1] == false && diagonal2[y+i] == false) { // 지금 열 사용 가능하면
				diagonal1[y-i+N-1] = true;
				diagonal2[y+i] = true;
				TF[i] = true;    // 0행일때 i열 위치에 true 넣기
				dfs(y+1,i); // 0행에 x 자리에 넣고 다음 행으로 넘어가기
				TF[i] = false;
				diagonal1[y-i+N-1] = false;
				diagonal2[y+i] = false;
			}
		}
		
	}
	
}