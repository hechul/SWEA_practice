import java.io.*;
import java.util.*;

public class Solution{
	static int[] inyoung;
	static int lost;
	static int win;
	static boolean[] TF;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			inyoung = new int[9]; // 인영이의 카드 배열
			lost = 0;
			win = 0;
			TF = new boolean[19];
			for(int j=0; j<9; j++) { // 인영이 카드 배열 채우기
				inyoung[j] = Integer.parseInt(st.nextToken());
				TF[inyoung[j]] = true;
			}
			
			
			dfs(0,0,0);
			
			bw.write("#" + i + " " + lost + " " + win + "\n");
			
		}
		bw.flush();
		bw.close();
		
	}
	static void dfs(int now,int in,int gyu) {
		// 인영이 카드 0과 1~18 비교
		if(now == 9) {
			if(in > gyu) {
				lost++;
			}
			else if(in < gyu) {
				win++;
			}
			return;
		}
		 
		for(int i=1; i<=18; i++) {
			if(inyoung[now] > i && TF[i] == false) {
				TF[i] = true;
				dfs(now+1,in+i+inyoung[now],gyu);
				TF[i] = false;
			}
			else if(inyoung[now] < i && TF[i] == false) {
				TF[i] = true;
				dfs(now+1,in,gyu+i+inyoung[now]);
				TF[i] = false;
			}
			else if(inyoung[now] == i && TF[i] == false) {
				TF[i] = true;
				dfs(now+1,in,gyu);
				TF[i] = false;
			}
			
		}
		
		
		
	}
}