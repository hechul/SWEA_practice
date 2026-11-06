import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][2];
			
			
			for(int j=0; j<N; j++) { //	노선의 개수 만큼 반복
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
				
			}
			
			int P = Integer.parseInt(br.readLine()); // 몇개의 버스 정류장을 찾을 것인가
			
			int[] Parr = new int[P]; // Parr에 몇번들의 버스 정류장을 찾을 건인지 저장
			for(int j=0; j<P; j++) {
				Parr[j] = Integer.parseInt(br.readLine());
			}
			
			
			int[] PP = new int[5001]; // 찾으려는 범위만큼 반복
			
			for(int j=0; j<P; j++) { // 5번 반복 0,1,2,3,4
				PP[j] = 0;           // PP[0] = 0 --- 모두 0으로 초기화
			}
			
			for(int j=0; j<N; j++) { //	노선의 개수 만큼 반복
				for(int k=arr[j][0]; k<=arr[j][1]; k++) { // 1,3 2,5 1~3 2~5 일시 PP[K-1]증가
					PP[k-1]++; // PP 에는 0부터 P 까지의 각 노선들이 몇번 지나쳤는지 들어가게 된다.
				}
			}
			
			
			bw.write("#" + i);
			for(int j=0; j<P; j++) { // P 만큼 반복
				// 지금 이대로 뽑으면 모든 노선들이 몇번 지나쳤는지 나오게 된다.
				bw.write(" " + PP[Parr[j] - 1]);
			}
			bw.write("\n");
			
			
			
			// 버스 노선이 N개가 있다.
			// i번째 버스 노선은 번호가 Ai 이상이고, Bi 이하인 모든 정류장을 다니는 버스 노선이다. 
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
	}
}