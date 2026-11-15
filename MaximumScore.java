import java.io.*;
import java.util.*;


public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // N개의 과목 시험을 
			int K = Integer.parseInt(st.nextToken()); // 성적표에 K개의 과목을 선택해서 넣을 수 있음.
			int result = 0;
			StringTokenizer stt = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(stt.nextToken());
			}
			
			for(int k=0; k<K; k++) {
				int max = 0;
				int x = 0;
				for(int j=0; j<N; j++) {
					if(max < arr[j]) {
						max = arr[j];
						x = j;
					}
				}
				result += max;
				arr[x] = 0;
			}
			
			bw.write("#" + i + " " + result + "\n");
			
			
			
			
			
			
		}
		
		bw.flush();
		bw.close();
		
	}
	
	
}