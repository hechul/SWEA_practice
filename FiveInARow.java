import java.io.*;
import java.util.*;

public class Solution{
 
	static int N;
	static char[][] arr;
	static boolean real;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new char[N][N];
			
			real = false;
			
			for(int j=0; j<N; j++) {
				String S = br.readLine();
				for(int k=0; k<N; k++) {
					arr[j][k] = S.charAt(k);
				}
			}
			
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					rotate(j,k); // 자신의 위치에서 아래, 오른쪽, 대각선 아래 탐색하는 dfs
					if(real == true) {
						break;
					}
				}
				if(real == true) {
					break;
				}
			}
			
			bw.write("#" + i + " ");
			if(real == true) {
				bw.write("YES");
			}
			else {
				bw.write("NO");
			}
			
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
		
	
	}
	static void rotate(int y, int x) {
		int count = 0;
		for(int k=x; k<N; k++) { // 현재 위치부터 오른쪽으로 탐색
			if(arr[y][k] == 'o') { // o를 만났다면 카운트 + 1
				count++;
			}
			else if(arr[y][k] == '.') { // 중간이든 뭐든 .을 만났다면 카운트 초기화
				count = 0;
			}
			if(count >= 5) { // o가 이어진게 5개 이상이면 그 즉시 프로그램 종료
				real = true;
			}
		}
		
		count = 0;
		
		for(int k=y; k<N; k++) { // 현재 위치부터 오른쪽으로 탐색
			if(arr[k][x] == 'o') { // o를 만났다면 카운트 + 1
				count++;
			}
			else if(arr[k][x] == '.') { // 중간이든 뭐든 .을 만났다면 카운트 초기화
				count = 0;
			}
			if(count >= 5) { // o가 이어진게 5개 이상이면 그 즉시 프로그램 종료
				real = true;
			}
		}
		count = 0;
		int m = 0;
		while(y+m < N && x+m < N) {
			if(arr[y+m][x+m] == 'o') { // o를 만났다면 카운트 + 1
				count++;
			}
			else if(arr[y+m][x+m] == '.') { // 중간이든 뭐든 .을 만났다면 카운트 초기화
				count = 0;
			}
			if(count >= 5) { // o가 이어진게 5개 이상이면 그 즉시 프로그램 종료
				real = true;
			}
			m++;
		}
		// 0 4
		count = 0;
		m = 0;
		while(y+m < N && x-m >= 0) {
			if(arr[y+m][x-m] == 'o') { // o를 만났다면 카운트 + 1
				count++;
			}
			else if(arr[y+m][x-m] == '.') { // 중간이든 뭐든 .을 만났다면 카운트 초기화
				count = 0;
			}
			if(count >= 5) { // o가 이어진게 5개 이상이면 그 즉시 프로그램 종료
				real = true;
			}
			m++;
		}
		
		
		
		
	}

	
}