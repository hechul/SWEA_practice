import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			
			// 일주일에 L분 이상 U분 이하의 운동을 하여야 함
			// 이번 주에 X분만큼 운동을 하였음
			
			if(X < L) {
				bw.write("#" + i + " " + (L-X) + "\n");
			}
			else if(X > U) {
				bw.write("#" + i + " " + -1 + "\n");
			}
			else {
				bw.write("#" + i + " " + 0 + "\n");
			}
		}
		
	bw.flush();
	bw.close();
	}
}