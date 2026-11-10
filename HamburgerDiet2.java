import java.io.*;
import java.util.*;

public class Solution{
	static int[][] arr;
	static int L;
	static int N;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			list = new ArrayList<>();
			int max = 0;
			for(int j=0; j<N; j++) { // 배열 채우기
				StringTokenizer stt = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(stt.nextToken());
				arr[j][1] = Integer.parseInt(stt.nextToken());
			}
			dfs(0,0,0);
			for(int l=0; l<list.size(); l++) {
				if(list.get(l) > max) {
					max = list.get(l);
				}
			}
			bw.write("#" + i + " " + max + "\n");
		}
		bw.flush();
		bw.close();
	}
	static void dfs(int now, int taste, int cal) {
		if(now == N && cal <= L) {
			list.add(taste);
			return;
		}
		if(now == N) {
			return;
		}
		if(cal > L) { // 칼로리의 합이 지정한 것을 넘었다
			return;
		}
		// x번째 재료를 포함한다
		dfs(now+1,taste,cal);
		// x번째 재료를 포함 안 한다
		// 이거 두개로 나뉨
		dfs(now+1,taste+arr[now][0],cal+arr[now][1]);
	}
}
