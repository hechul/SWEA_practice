import java.io.*;
import java.util.*;

public class Solution{
	static int[] arr;
	static int exchange;
	static String N;
	static TreeSet<Integer> set;
	static HashSet<String> visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = st.nextToken();
			
			set = new TreeSet<>();
			exchange = Integer.parseInt(st.nextToken());
			
			arr = new int[N.length()];
			for(int j=0; j<N.length(); j++) {
				arr[j] = N.charAt(j) - '0';
			}
			
			
			// arr - 1 2 3 , exchange - 1
			
			
			
			// 32888
			visited = new HashSet<>();
			dfs(0);
			
			bw.write("#" + i + " " + set.last() + "\n");
			
		}
		bw.flush();
		bw.close();
		
		
	}

	static void dfs(int count) { // 0, 2
		
		String key = count + ":" + Arrays.toString(arr);
		if (!visited.add(key)) return;
		
		if(count == exchange) {
			tree();
			return;
		}
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(i != j) { // i와 j가 같지 않을때
					int ec = arr[i];
					arr[i] = arr[j];
					arr[j] = ec;
					dfs(count+1);
					ec = arr[j];
					arr[j] = arr[i];
					arr[i] = ec;
				}
				
			}
		}
		
		
		
	}
	static void tree() {
		String result = "";
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			result += String.valueOf(arr[i]); // 88832
		}
		int k = 1;
		for(int i=arr.length-1; i>=0; i--) {
			sum += (result.charAt(i) - '0') * k;
			k = k*10;
		}
		
		set.add(sum);
	}
}