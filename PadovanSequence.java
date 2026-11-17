import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			for(int j=0; j<N; j++) {
				if(j < 3) {
					arr[j] = 1;
				}
				else {
					arr[j] = arr[j-2] + arr[j-3];
				}
			}
			
			bw.write("#" + i + " " + arr[N-1] + "\n");
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
		
	}

	

}