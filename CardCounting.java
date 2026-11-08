import java.io.*;
import java.util.*;

public class Solution{
	
	static String[] arr;
	static ArrayList<String> list;
	static boolean ERROR;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
		
			String S = br.readLine();
			
			arr = new String[S.length()/3];
			list = new ArrayList<>();
			ERROR = false;
			
			int SS = 0;
			int DD = 0;
			int HH = 0;
			int CC = 0;
			
			for(int j=0; j<S.length()/3; j++) {
				int k = j*3;
				arr[j] = S.substring(k, k+3);
				for(int l=0; l<list.size(); l++) { // 기존 리스트에 지금 넣으려는 것과 같은 수가 존재하는가?
					if(list.get(l).equals(arr[j])) {
						ERROR = true;
					}
				}
				list.add(arr[j]);
			}
			
			if(ERROR == true) {
				bw.write("#" + i + " " + "ERROR" + "\n");
				continue;
			}
			
			for(int j=0; j<arr.length; j++) {
				if(arr[j].charAt(0) == 'S') {
					SS++;
				}
				else if(arr[j].charAt(0) == 'D') {
					DD++;
				}
				else if(arr[j].charAt(0) == 'H') {
					HH++;
				}
				else if(arr[j].charAt(0) == 'C') {
					CC++;
				}
			}
			
			bw.write("#" + i + " " + String.valueOf(13-SS) + " " + String.valueOf(13-DD) + " " + String.valueOf(13-HH) + " " + String.valueOf(13-CC) + "\n");
			
			
			
			
			
			
		}
		bw.flush();
		bw.close();
		
		
	}
	
}