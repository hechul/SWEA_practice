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
			
			int[] last = new int[10000];
			
			int result = 0;
			
			boolean pp = false;
			boolean qq = false;
			
			int[] pn = new int[2];
			int[] qn = new int[2];
			
			// 1(1,1)
			// 2(1,2) 3(2,1)
			// 4(1,3) 5(2,2) 6(3,1)
			// 7(1,4) 8(2,3) 9(3,2) 10(4,1)
			
			
			// &(1)
			// &(5)
			
			// 1 -> 3 -> 6 -> 10 +2,+3,+4
			// 1 -> 2 -> 4 -> 7  +1,+2,+3
			
			// 1보다 작거나 같으면 첫번째 행
			// 3보다 작거나 같으면 두번째 행
			// 6보다 작거나 같으면 세번째 행
			
			int k = 1;
			int ar = 0;
			for(int j=1; !pp || !qq; j=j+k) {
				last[ar] = j; // last[0] = 1 last[1] = 3 last[2] = 6 
				// p 가 7이라면  last[0] = 1 last[1] = 3 last[2] = 6 last[3] = 10 이렇게 가게 되는데 
				// 1,3,6은 p보다 작고 last[3] 일때 p보다 커지는데
				
				// ar = 몇번째 행에 존재하는지를 나타냄
				// j = 그 행의 마지막 숫자를 의미함
				if(last[ar] >= p && pp == false) { // last[ar] 이 p보다 크거나 같다면  ar 행에 존재한다는 말임
					// last[3] 값에서 ar개수만큼 뒤로 -1씩 하면서 탐색
					// 이때 x,y 좌표는 (ar+1,1) 이 된다.
					
					int move = j - p;

					pn[0] = ar + 1 - move;
					pn[1] = 1 + move;

					pp = true;
				}
				
				if(last[ar] >= q && qq == false) { // last[ar] 이 q보다 크거나 같다면  ar 행에 존재한다는 말임
					// last[3] 값에서 ar개수만큼 뒤로 -1씩 하면서 탐색
					// 이때 x,y 좌표는 (ar+1,1) 이 된다.
					
					int move = j - q;

					qn[0] = ar + 1 - move;
					qn[1] = 1 + move;

					qq = true;
				}
				if(qq == true && pp == true) {
					break;
				}
				k++;
				ar++;
			}
			
			
			
			
			int nx = pn[0] + qn[0];
			int ny = pn[1] + qn[1];
			
			

						
			
			// 1(1,1)
			// 2(1,2) 3(2,1)
			// 4(1,3) 5(2,2) 6(3,1)
			// 7(1,4) 8(2,3) 9(3,2) 10(4,1)
			// 11 12 13 14 15
			// 3,3
			
			k = 1;
			ar = 0;
			for(int j=1; result==0; j=j+k) { // last[0] = 1(1,1) last[1] = 3(2,1) last[2] = 6(3,1)
				
				last[ar] = j;
				
				int x = ar+1;
				int y = 1;
				int o = j;
				for(int l=0; l<ar; l++) {
					x--;
					y++;
					o--;
					if(x==nx && y == ny) {
						result = o;
						break;
					}
					
				}
				
				k++;
				ar++;
				
			}
			
			
			bw.write("#" + i + " " + result + "\n");
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
	}

}