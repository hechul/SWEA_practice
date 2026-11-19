import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
	
		for(int i=1; i<=T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken()); 
			int A = Integer.parseInt(st.nextToken()); 
			int B = Integer.parseInt(st.nextToken()); 
		
			int count = 0;
			
			
			boolean[] composite = new boolean[1000001];

			
			// 2 3 4 5 6 7 8 9 10 --- 
			for(int j=2; j*j<=1000000; j++) { // j - 지금 몇의 배수를 제거할 것인가? // j = 2
			    if(!composite[j]) { 
			        for(int k=j*j; k<=1000000; k+=j) { // k - 실제로 제거할 숫자는 무엇인가? k = 4, 6, 8, 10 k = 3,6,9,12,15
			            composite[k] = true;
			        }
			    }
			}
			
			composite[1] = true;
			
			// 2 3 5 7 11 13 17
			for(int j = A; j<=B; j++) {


				// 2 3 4 5 6 7 8 9 10 11
				
				if(!composite[j]) {
					String S = String.valueOf(j);
					for(int k=0; k<S.length(); k++) {
						if(S.charAt(k) - '0' == D) { // 소수일때 D 숫자를 하나라도 가지면 count++
							count++;
							break;
						}
					}
				}
				
				
				
				
			}
			
			bw.write("#" + i + " " + count + "\n");
			
		}
			
		bw.flush();
		bw.close();
		
		
	}

}