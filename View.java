import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10; i++) {
			
			int mmin = 0;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			// 0 0 254 185 76 227 84 175 0 0
			// 254 다 되러면 옆에 0 0 254 185 76 이렇게 되어야 함
			for(int j=0; j<N; j++) { // 각 지점을 시작점으로 하여 앞으로 두칸, 뒤로 두칸씩 -를 하면서 가장 작은 값을 더한다 0보다 작으면 0으로 치부한다.
				int min1 = Integer.MAX_VALUE;
				int min2 = Integer.MAX_VALUE;
				int plu1 = Integer.MAX_VALUE;
				int plu2 = Integer.MAX_VALUE;
				
				if(j>0) {
					min1 = arr[j] - arr[j-1];
					if(min1 < 0) {
						min1 = 0;
					}
				}
				if(j>1) {
					min2 = arr[j] - arr[j-2];
					if(min2 < 0) {
						min2 = 0;
					}
				}
				if(j<N-1) {
					plu1 = arr[j] - arr[j+1];
					if(plu1 < 0) {
						plu1 = 0;
					}
				}
				if(j<N-2) {
					plu2 = arr[j] - arr[j+2];
					if(plu2 < 0) {
						plu2 = 0;
					}
				}
				
				int min = Math.min(min1,min2);
				int plu = Math.min(plu1, plu2);
				int che = Math.min(min, plu);
				mmin += che;
				
			}
			
			bw.write("#" + i + " " + String.valueOf(mmin) + "\n");
			
			
			
			
			
			
			
		}
		bw.flush();
		bw.close();
		
	}
}