import java.io.*;
import java.util.*;



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10; i++) { // 10개의 테스트 케이스 반복
		
			int[][] arr = new int[100][100];
			
			int col = 0;
			int row = 0;
		    int colmax = 0;
		    int rowmax = 0;
		    int de = 0;
		    int bande = 0;
		    int result = 0;
		    
		    int testcasenumber = Integer.parseInt(br.readLine());
			
			for(int j=0; j<100; j++) { // 배열 채우기 완료 
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j=0; j<100; j++) { 
				row = 0;
				for(int k=0; k<100; k++) { //하나의 행의 최대값 구하
					row += arr[j][k];
				}
				if(rowmax < row) {
					rowmax = row; // rowmax 보다 row가 더 크면 rowmax 는 row임
				}
			}
			if(result < rowmax) {
				result = rowmax;
			}
			
			
			
			
			for(int j=0; j<100; j++) { 
				col = 0;
				for(int k=0; k<100; k++) { //하나의 열의 최대값 구하
					col += arr[k][j];
				}
				if(colmax < col) {
					colmax = col; // rowmax 보다 row가 더 크면 rowmax 는 row임
				}
			}
			if(result < colmax) {
				result = colmax;
			}
			
			
			
			
			
			for(int j=0; j<100; j++) { // 대각선 
				de += arr[j][j];
				bande += arr[j][99-j];
			}
			
			if(de >= bande) {
				if(result < de) {
					result = de;
				}
			}
			else {
				if(result < bande) {
					result = bande;
				}
			}
			
			bw.write("#"+ i + " " + result + "\n");
			
			
		}
		
		bw.flush();
		bw.close();
		
	}
}
