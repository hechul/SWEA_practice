import java.io.*;
import java.util.*;
import java.math.*;

public class Solution{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int count = 0;
			String S = br.readLine();
			int[] arr = new int[S.length()];
			int[] now = new int[S.length()];
			
			
			
			for(int j=0; j<S.length(); j++) {
				arr[j] = S.charAt(j) - '0'; // arr - 0 0 1 1 목표로 하는 비트
				now[j] = 0; // 초기값 초기
			}
	
		
			for(int j=0; j<S.length(); j++) {
				if(arr[j] == 0 && now[j] == 1) { // 배열 첫번째부터 탐색을 하는데 목표로 하는 값이 0이라면 + 지금 현재의 값이 1이라면(0으로 바꿔줘야함)
					for(int k=j; k<S.length(); k++) {
						now[k] = 0;
					}
					count++;
				}
				else if(arr[j] == 1 && now[j] == 0) {// 배열 첫번째부터 탐색을 하는데 목표로 하는 값이 1이라면 + 지금 현재의 값이 0이라면(1로 바꿔줘야함)
					for(int k=j; k<S.length(); k++) {
						now[k] = 1;
					}
					count++;
				}
			}
			
			
		
			
			bw.write("#" + i + " " + count + "\n");
			
		}
		bw.flush();
		bw.close();
		
	}
}