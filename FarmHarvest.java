import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static int result;
	static int[][] arr;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			result = 0;
			
			for(int j=0; j<N; j++) { // 배열 채우기
				String S = br.readLine();
				for(int k=0; k<N; k++) {
					arr[j][k] = S.charAt(k) - '0';
				}
			}
			
			// 00 11 22 33
			// (N+1/2) - 1 -> 이놈이 중심점 좌표
			int middle = N/2;
			bruteforce(middle);
			
			
			bw.write("#" + i + " " + result + "\n");
			
		}
		bw.flush();
		bw.close();
		
	}
	static void bruteforce(int middle){
		 int i = 0; // 왼쪽 오른쪽으로 얼만큼 벌어질지 정하는 놈
		 int y = 0; // 행의 위치를 정하는 
		 
		 while(y < N) {// 행 수 만큼 반복 y - 0 y - 1 y - 2 y - 3 y - 4
			result += arr[y][middle]; // 현재 행에서 중간 위치 더하기
			
			
			for(int j=1; j<i+1; j++) { // 중간에서 i가 1이면 1증가 i가 2면 1,2증가
				result += arr[y][middle+j]; 
			}
			for(int j=1; j<i+1; j++) { // 현재 행에서 왼쪽으로 가면서 더하기	
				result += arr[y][middle-j];
			}
			
			if(y<N/2) { // y가 N/2 보다 작다면 확장 하고 있다는 의미		
				i++;
			}
			else if(y >= N/2) {
				i--;
			}
			
			y++;
		 }
		
	}
}
