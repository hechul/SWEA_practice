import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int M;
    static int C;
    static int[][] arr;
    static int max = 0;
    static int now;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for(int i=1; i<=testcase; i++){ // 테스트케이스 만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine()); // N,M,C 구하기
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            int[][] profit = new int[N][N];
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());


            for(int j=0; j<N; j++) { // 배열에 값 채우기
                StringTokenizer stt = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(stt.nextToken());
                }
            }

            for(int j=0; j<N; j++){ // 탐색을 시작할 시작점 에서
                for(int k=0; k<=N-M; k++){
                    int honey = 0; // 벌통들의 값을 다 더했을때의 합
                    int result = 0; // 벌통들 안의 값들^2 했을때의 값
                    for(int l=0; l<M; l++){ // 벌통의 개수만큼 탐색
                        if(k+l < N) { // 인덱스 넘기 방지
                            honey += arr[j][k + l];
                        }
                    }
                    if(honey <= C){ // 선택된 벌통의 합이 C 보다 작거나 같으면
                        for(int l=0; l<M; l++){ // 벌통의 개수만큼 탐색
                            if(k+l < N) { // 인덱스 넘기 방지
                                result += arr[j][k + l] * arr[j][k + l];
                            }
                        }
                        profit[j][k] = result; // j,k 좌표에서 시작하는 값을 profit 배열에 저장
                    }
                    else{ // 선택된 벌통의 합이 C 보다 크다면
                        // 선택된 벌통들의 모든 값 경우의 수를 구해서
                        // C 보다 크지않고 가장 큰 값 구하기
                        dfs(j,k,0,0,0);
                        profit[j][k] = max;
                        max = 0;
                    }
                }
            } // 시작점마다 최대 값 모두 구했으면
            // 시작점들을 비교해서 가장 큰 값 두개
            int maxAns = 0;
            for(int j=0; j<N; j++){ // 가장 큰 값 구하기
                for(int k=0; k<=N-M; k++){
                    // 2번 일꾼의 위치 (r, c) - 1번 일꾼 이후부터 탐색 시작!
                    for (int r = j; r < N; r++) {
                        // 만약 두 일꾼이 같은 행(j == r)에 있다면,
                        // 1번 일꾼이 끝난 자리(k + M) 이후부터 2번 일꾼이 시작해야 절대 안 겹침!
                        // 다른 행이라면 2번 일꾼은 그 줄의 처음(0)부터 시작해도 됨.
                        int startC = (j == r) ? k + M : 0;

                        for (int c = startC; c <= N - M; c++) {
                            // 두 일꾼의 수익을 더한 값이 기존 최고 기록보다 크면 갱신!
                            int currentSum = profit[j][k] + profit[r][c];
                            if (currentSum > maxAns) {
                                maxAns = currentSum;
                            }
                        }
                    }
                }
            }
            bw.write("#" + i + " " + maxAns + "\n");
        }
        bw.flush();
        bw.close();

    }
    static void dfs(int y, int x, int index, int result, int hap){
        if(hap > C){
            return;
        }
        if(index == M){
            now = result;
            if(now > max){
                max = now;
            }
            return;
        }
        dfs(y,x+1,index+1,result,hap); // 현재 값 더하지 않고 다음 인덱스로 넘어가기 6x
        result += arr[y][x] * arr[y][x]; // 현재 값 더하기
        hap += arr[y][x];
        dfs(y,x+1,index+1,result,hap); // 현재 값 더하고 다음 인덱스로 넘아가기

    }
}
