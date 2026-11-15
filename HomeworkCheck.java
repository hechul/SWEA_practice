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
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[K];
			
			boolean[] TF = new boolean[N];
					
			StringTokenizer stt = new StringTokenizer(br.readLine());
			
			// 2 5 3
			
			for(int j=0; j<K; j++) {
				arr[j] = Integer.parseInt(stt.nextToken()); // arr[0] 2 arr[1] 5 arr[2] 3
			}
			
			for(int j=0; j<K; j++) {
				TF[arr[j]-1] = true;
			}
			
			
			bw.write("#" + i);
			for(int j=0; j<N; j++) {
				if(TF[j] == false) {
					int jj = j+1;
					bw.write(" " + jj);
				}
			}
			
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
		
		
	}

	

}