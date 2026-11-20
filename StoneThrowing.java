import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int min = Integer.MAX_VALUE;
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<N; j++) {
				
				if(Math.abs(arr[j]) < min) { // 절댓값으로 바꿔서 지금 최솟값 보다 작으면 최솟값 갱신
					min = Math.abs(arr[j]);
				}
			}
			
			for(int j=0; j<N; j++) {
				if(Math.abs(arr[j]) == min) {
					count++;
				}
			}
			
			bw.write("#" + i + " " + min + " " + count + "\n");
			
			
			
		}
		bw.flush();
		bw.close();
		
		
	}
		
}
