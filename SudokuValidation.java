import java.io.*;
import java.util.*;

public class Solution{
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			
			boolean emergency = false;
			int[][] arr = new int[9][9];
			
			for(int j=0; j<9; j++) { // 배열 채우기
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<9; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
		
			
			
			for(int j=0; j<9; j++) { // 가로로 모든 행이 충족하는지 
				boolean[] TF = new boolean[10]; // 9개의 숫자 true false;
				for(int k=0; k<9; k++) {
					if(TF[arr[j][k]] == true) {
						emergency = true;
						break;
					}
					TF[arr[j][k]] = true;
				}
				if(emergency == true) {
					break;
				}
			}
			
			if(emergency == false) {
				for(int j=0; j<9; j++) { // 세로로 모든 열이 충족하는지
					boolean[] TF = new boolean[10]; // 9개의 숫자 true false;
					for(int k=0; k<9; k++) {
						if(TF[arr[k][j]] == true) {
							emergency = true;
							break;
						}
						TF[arr[k][j]] = true;
					}
					if(emergency == true) {
						break;
					}
				}
			}
			
			
//			7 3 6 4 2 9 5 8 1
//			5 8 9 1 6 7 3 2 4
//			2 1 4 5 8 3 6 9 7
//			8 4 7 9 3 6 1 5 2
//			1 5 3 8 4 2 9 7 6
//			9 6 2 7 5 1 8 4 3
//			4 2 1 3 9 8 7 6 5
//			3 9 5 6 7 4 2 1 8
//			6 7 8 2 1 5 4 3 9
			
			// 0,0 각 시작점들
			// 0,3
			// 0,6
			// 3,0
			// 3,3
			// 3,6
			
			if(emergency == false) {
				for(int j=0; j<9; j+=3) {
					for(int k=0; k<9; k+=3) {
						boolean[] TF = new boolean[10]; // 9개의 숫자 true false;
						for(int l=j; l<j+3; l++) {
							for(int p=k; p<k+3; p++) {
								if(TF[arr[l][p]] == true) {
									emergency = true;
									break;
								}
								TF[arr[l][p]] = true;
							}
							if(emergency == true) {
								break;
							}
						}
						if(emergency == true) {
							break;
						}
					}
					if(emergency == true) {
						break;
					}
				}
				
			}
			
			if(emergency == true) {
				bw.write("#" + i + " " + 0 + "\n");
			}
			else {
				bw.write("#" + i + " " + 1 + "\n");
			}
						
			
			
			
			
		}
		bw.flush();
		bw.close();
	
	}

	
}