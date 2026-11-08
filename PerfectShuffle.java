import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			ArrayList<String> list1 = new ArrayList<>();
			ArrayList<String> list2 = new ArrayList<>();
			
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String[] cards = new String[N];
			 
			for(int j=0; j<N; j++) { // 배열 채우기
				cards[j] = st.nextToken();
			}
			
			int middle = N/2; // 6 -> 3 0 1 2
			                  // 5 -> 2 0 1 2 3 4
			if(N % 2 == 1) { // N이 홀수개 있다면
				for(int j=0; j<middle+1; j++) {
					list1.add(cards[j]);
				}
				for(int j=middle+1; j<N; j++) {
					list2.add(cards[j]);
				}
				
			}
			else if(N % 2 == 0) {
				for(int j=0; j<middle; j++) {
					list1.add(cards[j]);
				}
				for(int j=middle; j<N; j++) {
					list2.add(cards[j]);
				}
			}
			
			// arr1 -> A B C
			// arr2 -> D E F
			bw.write("#" + i);
			int k = 0;
			for(int j=0; j<N; j++) {
				if(j % 2 == 0) {
					bw.write(" " + String.valueOf(list1.get(k)));
				}
				else {
					bw.write(" " + String.valueOf(list2.get(k)));
					k++;
				}
			}
			bw.write("\n");
			
			
			
		}
		bw.flush();
		bw.close();
		
		
	}
}

