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
    static int N;
    static int K;
    static int[][] arr;
    static boolean[][] visited;
    static int ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine()); // 테스트 케이스 몇 번?

        for(int i=1; i<=testcase; i++){ // 테스트케이스 만큼 진행
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            visited = new boolean[N][N];
            ans = 0;
            for(int j=0; j<N; j++){ // 배열 값 초기화
                StringTokenizer stt = new StringTokenizer(br.readLine());
                for(int k=0; k<N; k++){
                    arr[j][k] = Integer.parseInt(stt.nextToken());
                }
            }

            // arr 배열에서 가장 큰 값을 찾기
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(arr[j][k] > max){
                        max = arr[j][k];
                    }
                }
            }

            // 만일 가장 높은 봉우리라면
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(arr[j][k] == max){
                        dfs(j,k,1,false);
                    }
                }
            }
            bw.write("#" + i + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int y,int x,int length, boolean chance){
        if (length > ans) {
            ans = length;
        }
        visited[y][x] = true;
        int[] ny = {-1,1,0,0};
        int[] nx = {0,0,-1,1};

        for(int i=0; i<4; i++){
            int yy = ny[i] + y;
            int xx = nx[i] + x;


            if(yy>=0 && yy < N && xx>=0 && xx < N){ //인덱스 범위 내애 있고
                if(arr[y][x]>arr[yy][xx] && !visited[yy][xx]){ // 이동한 위치의 값이 전 위치보다 작을때 + 방문하지 않은 곳일때
                    dfs(yy,xx,length+1,chance);
                }
                else if(arr[y][x] > arr[yy][xx] - K && !chance && !visited[yy][xx]){ // K를 빼면 조건을 만족한다면 + 찬스를 안 썼다면
                    int originalHeight = arr[yy][xx];

                    arr[yy][xx] = arr[y][x] - 1;

                    dfs(yy, xx, length + 1, true);

                    arr[yy][xx] = originalHeight;
                }

            }
        }
        visited[y][x] = false;
    }
}
