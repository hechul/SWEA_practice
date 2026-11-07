import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1(1,1)
		// 2(1,2) 3(2,1)
		// 4(1,3) 5(2,2) 6(3,1)
		// 7(1,4) 8(2,3) 9(3,2) 10
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 1
			int q = Integer.parseInt(st.nextToken()); // 5
		
		
			int[] arrp = new int[2];
			int[] arrq = new int[2];
			int[] arrre = new int[2];
		
			int n1 = 0;
			int n2 = 0;
		
			int real = 0;
			int y = 0;
			int x = 0;
			
			
			while(n2 < p) { // n2 < 1  n2 -> 0 1 3 6
				n1++;     // 1
				n2 += n1; // 1   p 가 이놈보다 크거나 같을때까지 반복
			}
		
		    // n1 번째의 행에 p가 존재한다.
			
			real = n2 - n1 + 1; // 지금 행의 시작점 숫자 1
			y = 1; //1
			x = n1; // 1
			
			for(int j=1; j<=n1; j++) { // 반복 x
				if(j == 1) {
					if(real == p) {
						arrp[0] = y;
						arrp[1] = x;
					}
					continue;
				}
				real++;
				y++;
				x--;
				if(real == p) {
					arrp[0] = y; // 1
					arrp[1] = x; // 1
				}
			}
			
			n1 = 0;
			n2 = 0;
			
			while(n2 < q) { // n2 < 5
				n1++;     // 1 2 3
				n2 += n1; // 1 3 6  p 가 이놈보다 크거나 같을때까지 반복
			}
		
		    // n1 번째의 행에 p가 존재한다.
			
			real = n2 - n1 + 1; // 지금 행의 시작점 숫자 // 6 - 3 +1 = 4
			y = 1; // 1
			x = n1; // 3
			
			for(int j=1; j<=n1; j++) { // 1 2
				if(j == 1) {
					if(real == q) { // 4 == 5
						arrq[0] = y;
						arrq[1] = x;
					}
					continue;
				}
				real++; // 5
				y++; // 2
				x--; // 2
				if(real == q) {
					arrq[0] = y; // 2
					arrq[1] = x; // 2
				}
			}
			
			
			
			arrre[0] = arrp[0] + arrq[0]; // 3
			arrre[1] = arrp[1] + arrq[1]; // 3
			
			

			//(3,3) -> 숫자로 찾는 로직
			
			
			// 1 2 4 7 11
			int nn1 = 0;
			int nn2 = 0;
			real = 0;
			
			
			// 1(1,1)
			// 2(1,2) 3(2,1)
			// 4(1,3) 5(2,2) 6(3,1)
			// 7(1,4) 8(2,3) 9(3,2) 10
			
		
			while(true) {
				nn1++;     // 1 2 3
				nn2 += nn1; // 1 3 6 p 가 이놈보다 크거나 같을때까지 반복
				
				real = nn2 - nn1 + 1; // 지금 행의 시작점 숫자 // 1 2 4
				
				y = 1;   // 1
				x = nn1; // 3
				
				for(int j=1; j<=nn1; j++) {  // 1, 2, 3
					if(j == 1) {
						if(y==arrre[0] && x == arrre[1]) { // 1 == 3, 3 == 3
							break;
						}
					}
					
					real++; // 3 
					y++;    // 2 
					x--;    // 1
					if(y==arrre[0] && x == arrre[1]) { // 2 1
						break;
					}
				}
				
				if(y==arrre[0] && x == arrre[1]) {
					break;
				}
				
			}
			
			bw.write("#" + i + " " + String.valueOf(real)+"\n");
			
			
		}
		bw.flush();
		bw.close();
		
		
		
		
	}
}
