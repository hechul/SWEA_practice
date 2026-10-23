import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    static int N;
    static int W;
    static int H;
    static int min;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());


            int[][] arr = new int[H][W];
            min = Integer.MAX_VALUE;

            for(int j=0; j<H; j++){ // 배열 채우기
                StringTokenizer stt = new StringTokenizer(br.readLine());
                for(int k=0; k<W; k++){
                    arr[j][k] = Integer.parseInt(stt.nextToken());
                }
            }


            dfs(0,arr);
            bw.write("#" + i + " " + min + "\n");
        }
        bw.flush();
        bw.close();



    }
    static void dfs(int count,int[][] map){ // 공을 떨어뜨린 수 0부터 시작

        if (count == N) { //구슬 N 개를 다 던졌다면
            int remain = 0;
            for(int j=0; j<H; j++){
                for(int k=0; k<W;k++){
                    if(map[j][k] != 0) remain++;
                }
            }
            if(min > remain) min = remain;
            return;
        }


        for(int i=0; i<W; i++){
            // 공이 i 위치에 공이 떨어지고 최신화 되는 코드

            // 해당 열에서 가장 위에 있는 벽돌 찾기
            int targetY = -1;
            for (int j = 0; j < H; j++) { // 높이만큼 반복
                if (map[j][i] != 0) { // 위에서 아래로 내려가면서
                    targetY = j; // 0이아닌 벽돌을 찾았으면
                    break; // 멈추고 targetY에 저장
                }
            }
            if (targetY == -1) { // 모든 행이 0이라면
                dfs(count + 1, map); // 폭발할게 없으니 다음으로 넘어감
                continue;
            }

            int[][] copyMap = copy(map);

            explode(copyMap, targetY, i);

            gravity(copyMap);

            dfs(count + 1, copyMap);
            // 최신화 한 배열을 다시 되돌리는 코드
        }

    }

    // 맵 복사 함수
    static int[][] copy(int[][] map) {
        int[][] temp = new int[H][W];
        for (int j = 0; j < H; j++) {
            for (int k = 0; k < W; k++) {
                temp[j][k] = map[j][k];
            }
        }
        return temp;
    }

    static void explode(int[][] map, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        // 타격점 벽돌을 큐에 넣고 맵에서는 0으로 지움
        queue.offer(new int[]{y, x, map[y][x]});
        map[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            int power = cur[2]; // 벽돌에 적힌 숫자

            // 상하좌우로 (power - 1) 칸씩 뻗어나가며 폭발
            for (int d = 0; d < 4; d++) {
                int ny = cy;
                int nx = cx;
                for (int p = 1; p < power; p++) {
                    ny += dy[d];
                    nx += dx[d];

                    // 맵 안쪽이고 빈칸(0)이 아니라면
                    if (ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] != 0) {
                        // 그 벽돌의 파워가 1보다 크면 걔도 연쇄폭발 해야 하니 큐에 추가
                        if (map[ny][nx] > 1) {
                            queue.offer(new int[]{ny, nx, map[ny][nx]});
                        }
                        // 맵에서는 무조건 지움
                        map[ny][nx] = 0;
                    }
                }
            }
        }
    }
    // [기능 3] ArrayList를 이용한 중력 (바닥부터 알맹이만 주워담기)
    static void gravity(int[][] map) {
        for (int x = 0; x < W; x++) { // 모든 열을 하나씩 확인
            ArrayList<Integer> list = new ArrayList<>();

            // 바닥부터 꼭대기로 올라가며 0이 아닌 벽돌만 리스트에 쏙쏙 담기
            for (int y = H - 1; y >= 0; y--) {
                if (map[y][x] != 0) {
                    list.add(map[y][x]);
                    map[y][x] = 0; // 담은 자리는 0으로 초기화
                }
            }

            // 바닥부터 다시 리스트에 있는 알맹이들만 차곡차곡 쌓기
            int bottom = H - 1;
            for (int brick : list) {
                map[bottom][x] = brick;
                bottom--; // 위로 한 칸씩 이동하며 쌓음
            }
        }
    }
}