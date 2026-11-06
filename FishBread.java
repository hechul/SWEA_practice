import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 자격을 얻은 사람의 
			int M = Integer.parseInt(st.nextToken()); // M초의 시간을 들인
			int K = Integer.parseInt(st.nextToken()); // 그러면 K개의 붕어빵이 나온다.
			
			int[] arr = new int[N];
						
			StringTokenizer stt = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				 arr[j] = Integer.parseInt(stt.nextToken());
			}
			
			
			int fish = 0;
			int time = 0;
			int count = 0;
			int countF = 0;
			// N명의 사람이 방문함
			// M초의 시간을 들이면 K개의 붕어빵을 만들 수 있음
			
			// 모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별하는 프로그램
			
			// M초의 시간이 흐르기 전에 붕어빵은 0개임 -> M초의 시간이 흐르기 전에 방문하면 impossible
			
			while(true) { // 모든 손님들이 붕어빵을 얻게되면 종료(1초씩 증가)
				
				if(time > 0 && time % M == 0) { // 만일 시간이 M만큼 지났다면 
					fish += K;  // K개의 붕어빵이 나온다.
				}	
				
				
				//2 2 1
				//4 2
				
				for(int k=0; k<N; k++) { // 모든 손님들을 조사
					if(time == arr[k] && fish > 0) { // 시간이 손님들의 붕어빵 제공 시간이 되었고 붕어빵 제공이 가능하다면 + 이전에 검사하지 않은 사람이라면
						fish--;
						countF++;
						// 이미 검색했던 2같은건 제외해야함.
					}
					else if(time == arr[k] && fish <= 0) { // 시간이 손님들의 붕어빵 제공 시간이 되었는데 붕어빵 제공이 불가능 하다 + 이전에 검사하지 않은 사람이라면
						count++;
						break;
					}
				}
				
				time++;
				
				if(count != 0) { // 붕어빵 제공이 하나라도 불가능 하다는 뜻이므로 무한루프 탈출 
					break;
				}
				// 모든 손님들의 붕어빵 제공을 다 돌아봤을때.. 붕어빵 제공이 가능하다면
				if(countF == N) {
					break;
				}
				
			}
			
			if(count != 0) {
				bw.write("#" + i + " " + "Impossible" + "\n");
			}
			if(countF == N) {
				bw.write("#" + i + " " + "Possible" + "\n");
			}
		
		
		
		}
	
		bw.flush();
		bw.close();
		
		
	}
}