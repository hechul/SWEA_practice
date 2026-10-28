import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			ArrayList<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			int sum = 0;
			
			for(int j=0; j<N; j++) { // 배열 채우
				StringTokenizer stt = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					arr[j][k] = Integer.parseInt(stt.nextToken());
				}
			}
			
		    // 검은색 부분은 0  흰색 부분은 1 
			// 1이 연속으로 K개 이어져 있는지 보면 되는데 
			// 딱 K개 만큼 연속되어야 하고 그 이상,이하로 연속되면 안된다.
			
		
		    for(int j=0; j<N; j++) {
		    	int count = 0;
		    	for(int k=0; k<N; k++) {// 0이면 넘어가고 1이면 카운트 + 1
		    		if(count != 0 && arr[j][k] == 0) { // 만일 1의 개수 숫자를 세다가 0을 만났다면
		    		    list.add(count); // 연속되는 1의 개수를 넣고
		    			count = 0; // 카운트 0으로 초기화 
		    		}
		    		if(arr[j][k] == 1) {
		    			count++;
		    		}
		    		if(k == N-1 && arr[j][k] == 1) { //마지막 배열에 도달했고 1이라면
		    			list.add(count);
		    		}
		    	}
		    }
			
		    for(int j=0; j<N; j++) {
		    	int count = 0;
		    	for(int k=0; k<N; k++) {// 0이면 넘어가고 1이면 카운트 + 1
		    		if(count != 0 && arr[k][j] == 0) { // 만일 1의 개수 숫자를 세다가 0을 만났다면
		    		    list.add(count); // 연속되는 1의 개수를 넣고
		    			count = 0; // 카운트 0으로 초기화 
		    		}
		    		if(arr[k][j] == 1) {
		    			count++;
		    		}
		    		if(k == N-1 && arr[k][j] == 1) { //마지막 배열에 도달했고 1이라면
		    			list.add(count);
		    		}
		    	}
		    }
		    
		    for(int j=0; j<list.size(); j++) {
		    	if(list.get(j) == K) {
		    		sum++;
		    	}
		    }
			
		    bw.write("#" + i + " " + sum + "\n" );
					
		}
		bw.flush();
		bw.close();
		
		
	}
}
