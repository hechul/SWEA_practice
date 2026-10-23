import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    static int[] dy = {1,1,-1,-1};
    static int[] dx = {1,-1,-1,1};
    static int N;
    static int dfsmax;
    static boolean[] visited;
    static int[][] arr;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            ArrayList<Integer> list = new ArrayList<>();
            max = 0;
            visited = new boolean[101];
            for(int j=0; j<N; j++) { // 배열에 값 집어넣기
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j=0; j<N; j++){  // 좌표 하나당 우하->좌하->좌상->우상의 패턴으로 돌아올 수 있는
                                     // 최대의 수를 구해오기
                for(int k=0; k<N; k++){
                    dfsmax = 0;
                    visited[arr[j][k]] = true; // 시작점의 수를 true로 박고 시작
                    dfs(j,k,0,j,k,1); // 이게 끝나면 그 좌표에서의 가장 많이 가는 수임
                    visited[arr[j][k]] = false;
                    list.add(dfsmax);
                }
            }
            for(int j=0; j<N*N; j++){
                int bi = list.get(j);
                if(max < bi){
                    max = bi;
                }
            }
            if(max == 0){
                bw.write("#" + i + " " + -1 + "\n");
            }
            else {
                bw.write("#" + i + " " + max + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x,int i,int sty, int stx,int count) {
        if (i == 3 && y == sty && x == stx) { // 마지막이 우상으로 끝났다면 + 원래 좌표로 돌아왔다면
            //카운트를 dfsmax와 비교하여 더 크다면 max에 저장하고 다음 카운트들과 비교한다.
            if (dfsmax < count - 1) {
                dfsmax = count - 1;
            }
            return;
        }

        int ny = y + dy[i];
        int nx = x + dx[i];

        if (ny >= 0 && ny < N && nx >= 0 && nx < N) { // 인덱스를 넘어가지 않는다면
            if (visited[arr[ny][nx]] == true && !(ny == sty && nx == stx)) { //true 로 변경전에 이동할 좌표가 이미 true 라면
                return;
            }
            if (!(ny == sty && nx == stx)) {
                visited[arr[ny][nx]] = true;
            }

            //90도를 꺾는 경우 i의 값을 1증가시킴으로써 ny, nx 좌표가 다음의 좌하로 바뀐다.
            if (i < 3) {
                dfs(ny, nx, i + 1, sty, stx, count + 1);
            }
            //그 방향그대로 진행 i의 값을 그대로 둠으로써 ny,nx의 좌표를 우하로 그대로 사용
            dfs(ny, nx, i, sty, stx, count + 1);

            if (!(ny == sty && nx == stx)) {
                visited[arr[ny][nx]] = false;
            }

        }
    }


}
