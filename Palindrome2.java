import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static char[][] arr;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10; i++) {
			
			N = Integer.parseInt(br.readLine());
			
			arr = new char[100][100];
			max  = 0;
			
			for(int j=0; j<100; j++) { // 배열 채우기
				String S = br.readLine();
				for(int k=0; k<100; k++) {
					arr[j][k] = S.charAt(k);
				}
			}
			
			
			for(int j=0; j<100; j++) { // 모든 좌표를 시작점으로 하여 그 지점에서 회문이 되는 모든 경우를 구하고 그 중에 가장 큰 수를 구한다.
				for(int k=0; k<100; k++) {
					rotate(j,k);
				}
			}
			
			bw.write("#" + N + " " + max + "\n");
			
			
		}
		bw.flush();
		bw.close();

		
	}
	static void rotate(int y, int x) {
		
		String nx = "";
		String Rnx = "";
		String ny = "";
		String Rny = "";
		
		int count = 0;
		
		for(int j=0; j<100; j++) {
			// nx에 값을 더해가면서 회문이면 max와 비교
			if(x+j < 100) {
			nx += arr[y][x+j]; // j가2면
			count++;
				// 0~3 0 1 2
			
			Rnx = "";
				
			for(int k=0; k<j+1; k++) { 
				Rnx += arr[y][x+j-k];
				}
				
				
			if(nx.equals(Rnx)) {
				if(max < count) {
					max = count;
				}
					
			}
			}
		}
		
		count = 0;
		
		for(int j=0; j<100; j++) {
			// nx에 값을 더해가면서 회문이면 max와 비교
			if(y+j < 100) {
			ny += arr[y+j][x]; // j가2면
			count++;
				
			Rny = "";
				
			for(int k=0; k<j+1; k++) { 
				Rny += arr[y+j-k][x];
				}
				
				
			if(ny.equals(Rny)) {
				if(max < count) {
					max = count;
				}
					
			}
			}
				
		}
		
		
	}
}