import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10; i++) {
			
			int N = Integer.parseInt(br.readLine()); // 원본 암호문 길이 193
			
			StringTokenizer st = new StringTokenizer(br.readLine()); // 원본 암호문 701633 517247 207227 598...

			int count = 0;
			int[] code = new int[N]; 
			
			ArrayList<Integer> list = new ArrayList<>();
			
			
			
			for(int j=0; j<N; j++) {
				code[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<N; j++) {
				list.add(code[j]);
			}
			
			int D = Integer.parseInt(br.readLine()); // 11
		
			// 1 2 3 4 5
			StringTokenizer stt = new StringTokenizer(br.readLine()); // I 19 4 281822 746265 450734 108373
			
			while(count < D) {
				String command = stt.nextToken();
				if(command.equals("I")) { // i 를 만났다면
					int index = Integer.parseInt(stt.nextToken());
					int size = Integer.parseInt(stt.nextToken());
					for(int j=0; j<size; j++) { // size 만큼 반복 
						// 일단 code 먼저 뒤로 땡기기
						list.add(index+j,Integer.parseInt(stt.nextToken()));
					}
					count++;
				}
				else if(command.equals("D")) {
					int index = Integer.parseInt(stt.nextToken());
					int size = Integer.parseInt(stt.nextToken());
					for(int j=0; j<size; j++) { // size 만큼 반복 
						// 일단 code 먼저 뒤로 땡기기
						list.remove(index);
					}
					count++;
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