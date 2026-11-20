import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			
			// 1(1,1) 	
			// 2(1,2) 3(2,1)
			// 4(1,3) 5(2,2) 6(3,1)
			// 7(1,4) 8(2,3) 9(3,2) 10(4,1)
			
			// 두개의 덧셈 합이 2 3 4 5 6
			
			// 1->3->6->10 1+2+3+4
			// 1->2->4->7
			
			
			int result = 0;
			
			int x1 = 0;
			int y1 = 0;
			boolean[] pq = new boolean[2];
			int x2 = 0;
			int y2 = 0;
			
			int n = 0;
			int up = 1;
			
			while(true) { // n = 6 up = 3
				n = n+up; // n = 1 + 2 + 3 + 4
				if(n >= p && !pq[0]) { // p가 n보다 작거나 같아지는 순간 up 행에 존재한다.
					x1 = up; // 3
					y1 = 1;  // 1
					for(int j=n; j>p; j--) { // j = 6 p = 5 6->5
						x1--;
						y1++;
					}
					pq[0] = true;
				}
				
				if(n >= q && !pq[1]) { // q가 n보다 작거나 같아지는 순간 up 행에 존재한다.
					x2 = up;
					y2 = 1;
					for(int j=n; j>q; j--) { // j = 6 p = 5 6->5
						x2--;
						y2++;
					}
					pq[1] = true;
				}
				
				if(pq[0] == true && pq[1] == true) {
					break;
				}
				up++;
				
			}
			
			int rex = x1 + x2; // 3
			int rey = y1 + y2; // 3
			
			// 이제 #(rex,rey) 를 구하면 된다.
			
			n = 0;
			up = 1;
			int count = 1;
			
			while(true) { // rex + rey -1 의 행에 이 값은 존재함 rex+rey - 1 = 4
				n = n + up; // n = 7 up = 3 count = 4
				
				if(rex+rey-1 == count) { // count 행에 존재한다는 말임
					int rrex = 1; // (1,4)
					int rrey = count;
					while(rrex != rex && rrey != rey) { // 3, 2
						rrex++; // rrex = 3
						rrey--; // rrex = 2
						n++;    // n = 9
					}
					result = n; // 9
				}
				if(result != 0) {
					break;
				}
				
				
				if(n == 1) {
					count++;
					continue;
				}
				up++;
				count++;
				
			}
			
			bw.write("#" + i + " " + result + "\n");
			
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
		
		
	}
		
}
