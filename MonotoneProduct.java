import java.io.*;
import java.util.*;


public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); // 1
		
		for(int i=1; i<=T; i++) {
			
			int N = Integer.parseInt(br.readLine()); //4
			int max = -1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			int gop = 0;
			
			for(int j=0; j<N; j++) { // 2 4 7 10
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					gop = arr[j] * arr[k];
					if(gop <= max) {
						continue;
					}
					if(String.valueOf(gop).length() == 1) { // 일의자리일때
						if(gop > max) {
							max = gop;
						}
					}
					else { // 십의자리 백의자리 --- 일때
						boolean danjo = false;
						for(int l=0; l<String.valueOf(gop).length()-1; l++) { // 289
							if(String.valueOf(gop).charAt(l) > String.valueOf(gop).charAt(l+1)) {
								danjo = true;
								break;
							}
						}
						if(danjo == false) {
							if(gop > max) {
								max = gop;
							}
						}
					}
				}
			}

				bw.write("#" + i + " " + max + "\n");
			
			
			
		}
		bw.flush();
		bw.close();
		
		
		
	}
	
	
}