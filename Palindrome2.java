import java.io.*;
import java.util.*;

public class Solution{
	static char[][] arr;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10; i++) {
			
			int T = Integer.parseInt(br.readLine());
			
			arr = new char[100][100];
			max = 0;
			for(int j=0; j<100; j++) { // 배열 채우기
				String S = br.readLine();
				for(int k=0; k<100; k++) {
					arr[j][k] = S.charAt(k);
				}
			}
			
			for(int j=0; j<100; j++) {
				for(int k=0; k<100; k++) {
					rotate(j,k); // 좌표 하나하나마다의 시작점으로 오른쪽, 아래로 구역을 넓혀가며 탐색
				}
			}
			
	
			bw.write("#" + T + " " + max + "\n");
		}
		bw.flush();
		bw.close();

		
	}
	static void rotate(int y, int x) { //현재 위치를 기준으로 오른쪽으로 얼마나 포함할건지 아래로 얼마나 포함할건지?
		
		// CCBBC 1 - 5  2 - 4가 같아야 함 가운데는 홀수일때 x+count/ 2하면나옴 
		// CCBBCB 1 - 6 2 - 5 3 - 4가 같아야 함 짝수일때는 x / 2 -> 3
		int count = 1; //y,x 좌표로 arr[y][x] 하나만 가지는 경우로 시작
		
		for(int i=x; i<100; i++) { // x는 시작점 좌표임 시작점에서 끝 열까지 반복하겠다는 말
			if(count % 2 == 1) { // 지금 탐색중인 것의 길이가 홀수라면 
				int middle = x+count/2; // middle을 중점으로 왼쪽 오른쪽 같은지 탐색
				int T1 = 0;
				int T2 = 0;
				for(int j=1; j<count/2+1; j++) {
					T1++; // 같지 않던 아니던 더하기
					if(arr[y][middle+j] == arr[y][middle-j]) {
						T2++; // 두개가 같을때만 더하기
					}
				}
				if(T1 == T2) {
					if(max < count) {
						max = count;
					}
				}
			}
			else if(count % 2 == 0) {
				int middle1 =x+count/2-1;
				int middle2 =middle1+1;
				int T1 = 0;
				int T2 = 0;
				//middle1 과 middle 2가 같은지 본다
				if(arr[y][middle1] == arr[y][middle2]) {
					T2++;
				}
				T1++;
				for(int j=1; j<count/2; j++) {
					T1++;
					if(arr[y][middle1-j] == arr[y][middle2+j]) {
						T2++;
					}
				}
				if(T1 == T2) {
					if(max < count) {
						max = count;
					}
				}
			}
			count++;
		}
		
		count = 1;
		
		for(int i=y; i<100; i++) { // y는 시작점 좌표임 시작점에서 끝 열까지 반복하겠다는 말
			if(count % 2 == 1) { // 지금 탐색중인 것의 길이가 홀수라면 
				int middle = y+count/2; // middle을 중점으로 왼쪽 오른쪽 같은지 탐색
				int T1 = 0;
				int T2 = 0;
				for(int j=1; j<count/2+1; j++) {
					T1++; // 같지 않던 아니던 더하기
					if(arr[middle+j][x] == arr[middle-j][x]) {
						T2++; // 두개가 같을때만 더하기
					}
				}
				if(T1 == T2) {
					if(max < count) {
						max = count;
					}
				}
			}
			else if(count % 2 == 0) {
				int middle1 =y+count/2-1;
				int middle2 =middle1+1;
				int T1 = 0;
				int T2 = 0;
				//middle1 과 middle 2가 같은지 본다
				if(arr[middle1][x] == arr[middle2][x]) {
					T2++;
				}
				T1++;
				for(int j=1; j<count/2; j++) {
					T1++;
					if(arr[middle1-j][x] == arr[middle2+j][x]) {
						T2++;
					}
				}
				if(T1 == T2) {
					if(max < count) {
						max = count;
					}
				}
			}
			count++;
		}
		
	}
}