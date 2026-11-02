import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 암호문 
		
		for(int i=1; i<=10; i++) {
			
			ArrayList<Integer> list = new ArrayList<>();
			
			int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
			
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
	
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken()); // 원본 암호문
			}
			
			int I = Integer.parseInt(br.readLine()); // 명령어의 개수
			
			for(int j=0; j<N; j++){
				list.add(arr[j]);
			}
			
			StringTokenizer stt = new StringTokenizer(br.readLine()); // 명령어
			
			for(int k=0; k<I; k++) {
				String L = stt.nextToken();
				int x = Integer.parseInt(stt.nextToken());
				int y = Integer.parseInt(stt.nextToken());
				int[] s = new int[y];
				for(int j=0; j<y; j++) {
					s[j] = Integer.parseInt(stt.nextToken()); 
				}
				
			
				
				
				// 기존 배열을 y만큼 밀어내야 함.
				for(int j=0; j<y; j++) {
					list.add(x+j,s[j]);
				}
				
			
			}
			
			bw.write("#" + i);
			for(int j=0; j<10; j++) { 
				bw.write(" " + String.valueOf(list.get(j)));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();	
	}
}