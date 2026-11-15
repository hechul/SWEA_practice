import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			
			
			int up = 0;
			int down = 0;
			
			
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<N-1; j++) {
				if(arr[j] < arr[j+1]) { // 올라가기
					if(up < arr[j+1] - arr[j]) {
						up = arr[j+1] - arr[j];
					}
				}
				else if(arr[j] > arr[j+1]) {
					if(down < arr[j] - arr[j+1]) {
						down = arr[j] - arr[j+1];
					}
				}
			}
			
			
			bw.write("#" + i + " " + up + " " + down + "\n");
			
			
			
		}
		
		bw.flush();
		bw.close();
	
	}

	

}