import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i=1; i<=10; i++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[100];
			
			for(int j=0; j<100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			
			while(count < N) {
				int max = 0;
				int min = Integer.MAX_VALUE;
				for(int j=0; j<100; j++) { // 0부터100까지 인덱스중에 가장큰놈의 값, 가장 작은놈의 값 구하기
					if(max < arr[j]) {
						max = arr[j];	
					}
					if(min > arr[j]) {
						min = arr[j];	
					}
				}
				for(int j=0; j<100; j++) { // 가장 큰놈의 값을 가지는 인덱스 값-- 가장 작은놈 값을 가지는 인덱스값++
					if(arr[j] == max) {
						arr[j]--;
						break;
					}
				}
				
				for(int j=0; j<100; j++) { // 가장 큰놈의 값을 가지는 인덱스 값-- 가장 작은놈 값을 가지는 인덱스값++
					if(arr[j] == min) {
						arr[j]++;
						break;
					}
				}
				
				count++;
			}
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			for(int j=0; j<100; j++) {
				if(max < arr[j]) {
					max = arr[j];	
				}
				if(min > arr[j]) {
					min = arr[j];	
				}
			}
			
			int result = max - min;
			
			bw.write("#" + i + " " + result + "\n");
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
	}
		
}
