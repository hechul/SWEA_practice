import java.io.*;
import java.util.*;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int gun = 0;
			StringTokenizer stt = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			
			for(int j=0; j<N; j++) { 
				arr[j] = Integer.parseInt(stt.nextToken());
			}
			
			
			// arr[0,1,2,3,4,5] - 1 0 0 0 0 1
			
			// 0이 D개 이상 반복되면 1을 넣어줘야하네 
			
			for(int j=0; j<N; j++) {
				int count = 0;
				if(arr[j] == 0) { // 0을 발견하면 그 위치부터 뒤쪽으로 0이 D번 이상 반복되는지 본다.
					for(int k=j; k<N; k++) {
						if(arr[k] == 0) {
							count++;
						}
						if(arr[k] == 1) {
							j = k;
							break;
						}
						if(count == D) {
							gun++; // 차원문 건설
							j = k; //j는 마지막 0탐색이 끝난 k부터 탐색 
							break;
						}
					}
				}
			}
			
			bw.write("#" + i + " " + gun + "\n");
			
			
			
		}
		
		
		bw.flush();
		bw.close();
		
	}
	
}