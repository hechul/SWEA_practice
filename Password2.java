import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			String arr = st.nextToken();
			
			
			for(int j=0; j<N; j++) {
				list.add(arr.charAt(j) - '0');
			}
			// 4100112380990844
			
			while(true) {
				int k = 0;
				for(int j=0; j<list.size()-1; j++) {
					if(list.get(j) ==list.get(j+1)) {
						list.remove(j);
						list.remove(j);
						k++;
						break;
					}
				}
				if(k == 0) {
					break;
				}
			}
			
			
			
			bw.write("#" + i + " ");
			for(int j=0; j<list.size(); j++) {
				bw.write(String.valueOf(list.get(j)));
			}
			
			bw.write("\n");
			
			
			
			
			
		}
		
		bw.flush();
		bw.close();
		
	}
	// 4100112380990844
}