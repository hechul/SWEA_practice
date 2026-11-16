import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static int[] arr;
	static boolean TF;
	static int result;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			N = Integer.parseInt(br.readLine());
			
			int count = 0;
			arr = new int[N];
			result = 0;
			
			while(count < N) { 
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					arr[count++] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int s = 0;
			while(true) {
				TF = false;
				String S = String.valueOf(s);
				int size = S.length();
				search(s,size);
				if(TF == true) {
					s++;
				}
				else if(TF == false) {
					result = s;
					break;
				}
			}
			
			
			bw.write("#" + i + " " + result + "\n");
			

			
// 9 8 7 6 5 4 3 2 1 1 0
// 인덱스 붙어있는 수는 만들 수 있음
//			
//
			

			
			
			
		}
		bw.flush();
		bw.close();
		
		
	}
	static void search(int now,int size) { // now -> 0, 1, 2, 3, 4, 5 하나씩 + size -> 현재 찾는 수 몇자리인지?
		
		for(int i=0; i<=N-size; i++) { // 시작점
			String word = "";
			word += arr[i];
			for(int j=1; j<size; j++) { // 에서부터 뒤로 size 만큼
				word += arr[i+j]; // i뒤로 1만큼, 2만큼 , 3만
			}
			int su = Integer.parseInt(word);
			if(su == now) { // 이어 붙여서 나온 수가 지금 찾는수랑 같다면 break;
				TF = true;
				break;
			}
		}
		
		
	}
}