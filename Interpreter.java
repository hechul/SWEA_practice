import java.io.*;
import java.util.*;

public class Solution{
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수 
		
		for(int i=1; i<=T; i++) {
			
			int N = Integer.parseInt(br.readLine()); // N개의 문장
			int[] count = new int[N];
			int l = 0;
			
			
			
			StringTokenizer st = new StringTokenizer(br.readLine()); // N개의 문장을 입력받음
			
			
			while(true) {
				  while (!st.hasMoreTokens()) { 
				        st = new StringTokenizer(br.readLine());
				    }
				    String name = st.nextToken();
				if(name.charAt(0) <= 'Z' && name.charAt(0) >= 'A') { // 첫번째 문장의 첫번째 글자가 대문자라면
					int cc = 0;
					for(int k=1; k<name.length(); k++) { // 뒤쪽의 문자가 다 소문자라면
						if(name.charAt(k) >= 'a' && name.charAt(k) <= 'z') {
							cc++;
						}
					}
					if(name.charAt(name.length()-1) == '.' || name.charAt(name.length()-1) == '!' || name.charAt(name.length()-1) == '?') { // 맨 마지막 인덱스를 검사해서 이거라면
						if(cc == name.length()-2) { 
							count[l]++;
						}
					}
					else if(cc == name.length()-1) {
						count[l]++;
					}
					
				}
				if(name.charAt(name.length()-1) == '.' || name.charAt(name.length()-1) == '!' || name.charAt(name.length()-1) == '?') {
					l++;
				}
				if(l == N) {
					break;
				}
			}
			
			
			bw.write("#" + i);
			for(int j=0; j<N; j++) {
				bw.write(" " + count[j]);
			}
			bw.write("\n");
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
		
	
	}

	
}