import java.io.*;
import java.util.*;

public class Solution{
 
	static int[][] arr;
	static int N;
	static int M;
	static TreeSet<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			
			set = new TreeSet<>();
			for(int j=0; j<N; j++) { // 배열 채우
				StringTokenizer stt = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					arr[j][k] = Integer.parseInt(stt.nextToken());
				}
			}
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					rotate(j,k);
				}
			}
			
			
			
			bw.write("#" + i + " " + set.last() + "\n");
			
			
		}
		bw.flush();
		bw.close();
		
		
		
		
	}
	static void rotate(int y, int x) { // y,x 로부터 밑으로 M -1 만큼 오른쪽으로 -1만큼 
		int sum = 0;
		
		for(int i=y; i<y+M; i++) {
			for(int j=x; j<x+M; j++) {
				if(i<N && j<N)
				sum+= arr[i][j];
			}
		}
		
		
		
		set.add(sum);
		
	}
		
	
}