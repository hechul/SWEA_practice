import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr = new int[4][4];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        for(int i = 1;i<=testcase;i++) {

            set = new HashSet<>();

            for (int j = 0; j < 4; j++) { // 격자 숫자 채우기
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<4; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    dfs(j,k,String.valueOf(arr[j][k])); // 모든 시작점에서 시작하는 경우 검토
                }
            }

            bw.write("#" + i + " " + set.size() + "\n");

        }
        bw.flush();
        bw.close();
    }
    static void dfs(int r,int c, String currentStr){
        if(currentStr.length() == 7){
            set.add(currentStr);
            return;
        }

        for(int i=0; i<4; i++){ // 상하좌우 이동했을때의 경우
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nr < 4 && nc >=0 && nc < 4){ // 범위 내에 있을 때
                dfs(nr,nc,currentStr + arr[nr][nc]);
            }

        }
    }

}
