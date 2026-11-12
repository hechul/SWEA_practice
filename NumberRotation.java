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
			ArrayList<String> list3 = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			
			String[][] kk = new String[N][3];
			
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 90도 180도 270도 회전한 결과를 반환 
			// 90도씩 세번 돌리자

			for(int j=0; j<N; j++) {
				String text = "";
				for(int k=N-1; k>=0; k--) {
					text += String.valueOf(arr[k][j]);
				}
				list1.add(text);
			}
			
			for(int j=0; j<N; j++) {
				kk[j][0] = list1.get(j);
			}
			
			for(int j=N-1; j>=0; j--) {
				String text = "";
				for(int k=N-1; k>=0; k--) {
					text += String.valueOf(arr[j][k]);
				}
				list2.add(text);
			}
			
			for(int j=0; j<N; j++) {
				kk[j][1] = list2.get(j);
			}
			
			for(int j=N-1; j>=0; j--) {
				String text = "";
				for(int k=0; k<N; k++) {
					text += String.valueOf(arr[k][j]);
				}
				list3.add(text);
			}
			
			for(int j=0; j<N; j++) {
				kk[j][2] = list3.get(j);
			}
			
			bw.write("#" + i + "\n");
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<3; k++) {
					bw.write(kk[j][k] + " ");
				}
				bw.write("\n");
			}
			
			
		}
		bw.flush();
		bw.close();
		
	}

	
}