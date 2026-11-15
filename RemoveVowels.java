import java.io.*;
import java.util.*;


public class Solution{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			String S = br.readLine();
			char[] arr = new char[S.length()];
			
			ArrayList<String> list = new ArrayList<>();
			
			for(int j=0; j<S.length(); j++) {
				arr[j] = S.charAt(j);
			}
			
			for(int j=0; j<S.length(); j++) {
				if(arr[j] != 'a' && arr[j] != 'e' && arr[j] != 'i' && arr[j] != 'o' && arr[j] != 'u') {
					list.add(String.valueOf(arr[j]));
				}
			}
			
			bw.write("#" + i + " ");
			for(int j=0; j<list.size(); j++) {
				bw.write(list.get(j));
			}
			bw.write("\n");
			

		}
		bw.flush();
		bw.close();
		
		
	}
	
	
}