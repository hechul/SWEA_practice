import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 5    ->      0 0 0 0 0 
			int Q = Integer.parseInt(st.nextToken()); // 2    ->      i가 1일때, 2일때
			
			int[] chest = new int[N]; // -> 0 0 0 0 0
			
			int[][] arr = new int[Q][2];
			
			for(int j=0; j<Q; j++) { // 배열 채우기
				StringTokenizer stt = new StringTokenizer(br.readLine());
				for(int k=0; k<2; k++) {
					arr[j][k] = Integer.parseInt(stt.nextToken());
				}
			}
			
			for(int l=0; l<Q; l++) {
				for(int j=arr[l][0]-1; j<arr[l][1]; j++) {
					chest[j] = l+1;
				}
			}
			
			bw.write("#" + i);
			
			for(int j=0; j<N; j++) {
				bw.write(" " + chest[j]);
			}
			bw.write("\n");
			
			
			
			
			
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
	
	}

	

}