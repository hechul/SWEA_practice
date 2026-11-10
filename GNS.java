import java.io.*;
import java.util.*;

public class Solution{
	static int N;
	static int[] pos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			ArrayList<String> list = new ArrayList<>();
			String Test = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			String[] arr = new String[N];
			
			StringTokenizer syt = new StringTokenizer(br.readLine());

			
			for(int j=0; j<N; j++) {
				arr[j] = syt.nextToken();
			}
			
			for(int j=0; j<N; j++) {
				if(arr[j].equals("ZRO")) {
					list.add(arr[j]);
				}
			}
			for(int j=0; j<N; j++) {
				if(arr[j].equals("ONE")) {
					list.add(arr[j]);
				}
			}
			for(int j=0; j<N; j++) {
				if(arr[j].equals("TWO")) {
					list.add(arr[j]);
				}
			}
			for(int j=0; j<N; j++) {
				if(arr[j].equals("THR")) {
					list.add(arr[j]);
				}
			}
			for(int j=0; j<N; j++) {
				if(arr[j].equals("FOR")) {
					list.add(arr[j]);
				}
			}
			for(int j=0; j<N; j++) {
				if(arr[j].equals("FIV")) {
					list.add(arr[j]);
				}
			}
			for(int j=0; j<N; j++) {
				if(arr[j].equals("SIX")) {
					list.add(arr[j]);
				}
			}
			for(int j=0; j<N; j++) {
				if(arr[j].equals("SVN")) {
					list.add(arr[j]);
				}
			}
			for(int j=0; j<N; j++) {
				if(arr[j].equals("EGT")) {
					list.add(arr[j]);
				}
			}
			for(int j=0; j<N; j++) {
				if(arr[j].equals("NIN")) {
					list.add(arr[j]);
				}
			}
			
			
			bw.write("#" + i + "\n");
			
			for(int j=0; j<N; j++) {
				bw.write(list.get(j) + " ");
			}
			
			
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
	}
}
