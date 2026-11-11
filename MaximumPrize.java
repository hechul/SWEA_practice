import java.io.*;
import java.util.*;

public class Solution{
	
	static int change;
	static int[] arr;
	static TreeSet<Integer> set;
	static int answer;
	static HashSet<String> visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
	
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			change = Integer.parseInt(st.nextToken());
			arr = new int[S.length()];
			set = new TreeSet<>();
			visited = new HashSet<>();
			for(int j=0; j<arr.length; j++) {
				arr[j] = S.charAt(j) - '0';
			}
			
			
			// 32888
			dfs(0);
			
			ArrayList<Integer> list = new ArrayList<>(set);

			bw.write("#" + i + " " + String.valueOf(set.last()) + "\n");
			
			
			
			
			
			
		}
		bw.flush();
		bw.close();
	}
	static void dfs(int count) {
		
		
		
		String key = count + ":" + Arrays.toString(arr);
		if (!visited.add(key)) return;
		
		// 88832
		if(count == change) {
			answer = 0;
			int j = arr.length; //5
			for(int i=0; i<arr.length; i++) { //
				int mid = 1;
				for(int k=0; k<j; k++) { // 0~4
					mid *= 10; // mid = 1*10*10*10*10*10
				}
				answer += arr[i] * mid / 10;
				j--;
			}
			set.add(answer);
			return;
		}
		
		
		for(int i=0; i<arr.length; i++) { // 인덱스 0부터 맨뒤까지 탐색
			for(int j=i+1; j<arr.length; j++) { // 인덱스 i 다음부터 맨 뒤까지 탐
				
				swap(i,j); // 인덱스 i와 인덱스 j를 바꾸기 
				dfs(count+1); // 카운트를 1증가시키고
				swap(i,j); // 인덱스 i와 j를 다시 바꿔서 원복
			}
		}
		
		
		// 인덱스 i랑 인덱스 j랑 교환한다, 교환 안 한다
		
	}
	static void swap(int i,int j) {
		int cg = 0;
		cg = arr[i];
		arr[i] = arr[j];
		arr[j] = cg;
	}
		
	
}