import java.io.*;
import java.util.*;

public class Solution{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10; i++) {
			
			
			int mmax = 0;
			int mmin = Integer.MAX_VALUE;
			int dump = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[100];
			
			for(int j=0; j<100; j++) { // 배열 채우기
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<dump; j++) { // dump번 이동을 반복하기
				int n1 = 0;
				int n2 = 0;
				int max = 0;
				int min = Integer.MAX_VALUE;
				
				for(int k=0; k<100; k++) {
					if(max < arr[k]) { // max 값과 그 위치 저장하기
						max = arr[k];
						n1 = k;
					}
				}
				
				arr[n1] = --max;
				
				for(int k=0; k<100; k++) {
					if(min > arr[k]) { // min 값과 그 위치 저장하기
						min = arr[k];
						n2 = k;
					}
				}
				
				arr[n2] = ++min;
				
			}
			
			for(int j=0; j<100; j++) {
				if(mmax < arr[j]) { // max 값과 그 위치 저장하기
					mmax = arr[j];
				}
			}
			
			for(int j=0; j<100; j++) {
				if(mmin > arr[j]) { // max 값과 그 위치 저장하기
					mmin = arr[j];
				}
			}
			
			bw.write("#" + i + "  " + String.valueOf(mmax-mmin) + "\n" );
			
		}
		bw.flush();
		bw.close();
		
	}
}

