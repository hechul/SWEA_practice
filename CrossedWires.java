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
			int count = 0;
			for(int j=0; j<N; j++) { // 배열 채우
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			
			// arr[j][0] 과 arr[j][1]이 선 이어져 있는거 한쌍임.
			
			// 1 10
			// 왼쪽값이 1보다 크면 오른쪽값이 10보다 작아야 하고
			// 왼쪽값이 1보다 작으면 오른쪽값이 10보다 커야한다.
			
			for(int j=0; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					if(arr[j][0] > arr[k][0] && arr[j][1] < arr[k][1]) {
						count++;
					}
					else if(arr[j][0] < arr[k][0] && arr[j][1] > arr[k][1]) {
						count++;
					}
				}
			}
			
			
			bw.write("#" + i + " " + count + "\n");
			
			
		}
		bw.flush();
		bw.close();
	}

	
}