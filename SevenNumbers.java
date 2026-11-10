import java.io.*;
import java.util.*;

public class Solution{
	static int[] arr;
	static TreeSet<Integer> set;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			
			arr = new int[7];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// hashset은 get이 안되서 탈
			set = new TreeSet<>();
			for(int j=0; j<7; j++) {
				arr[j] = Integer.parseInt(st.nextToken()); 
			}
		
			
			dfs(0,0,0);
			
			list = new ArrayList<>(set);
			bw.write("#" + i + " " + String.valueOf((list.get(list.size()-5))) + "\n");
			
		}
		bw.flush();
		bw.close();
	}
	
	// 1 2 3 4 5 6 7
	static void dfs(int now,int sum,int count) { // 0 0 0
		
		if(count == 3) {
			set.add(sum);
			return;
		}
		
		if(now == 7) {
			return;
		}
		
		
		dfs(now+1,sum,count); // 1,0,0
		
		dfs(now+1,sum+arr[now],count+1); // 1,1,1
		
	}
	
}