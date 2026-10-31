import java.io.*;
import java.util.*;

public class Solution{
	static int[] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10; i++) {
			int T = Integer.parseInt(br.readLine());
			
			arr = new int[8];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<8; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			rotate();
			
			bw.write("#" + i);
			for(int j=0; j<8; j++) {
				bw.write(" " + String.valueOf(arr[j]));
			}
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
		
	}
	static void rotate() {
		int m = 0;
		int count = 1;
		int save = 0;
		
		// // 9550 9556 9550 9553 9558 9551 9551 9551
		
		while(m < 1) { // 지정된 조건가지 무한반복
			// 인덱스 0에 있는놈을 -count 만큼 하고 save에 저장을 해둔다음
			// 인덱스의 값들을 1->0 2->1 이런식으로 땡겨오기 + 마지막 인덱스 7에 save값 박기
			// 주의할점은 8번 진행하고 count를 초기화 시키는 것 
			
			if(count == 6) {
				count = 1;
			}
			
			save = arr[0] - count; // save에 맨 앞값 - count 저장
			
			if(save <= 0) {
				for(int i=0; i<7; i++) { // 인덱스 한칸씩 땡기기
					arr[i] = arr[i+1];   
				}
				arr[7] = 0;
				m = 1;
				return;
			}
			
			for(int i=0; i<7; i++) { // 인덱스 한칸씩 땡기기
				arr[i] = arr[i+1];   
			}
			arr[7] = save;           // 마지막에 정해진 값 넣기
			count++;
			
		}
		
	}
}