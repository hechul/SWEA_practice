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
    static int M;
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for(int i=1; i<=testcase; i++) {
            StringTokenizer sttt = new StringTokenizer(br.readLine());
            N = Integer.parseInt(sttt.nextToken());
            M = Integer.parseInt(sttt.nextToken());
            int mmax = 0;
            arr = new int[N][N];

            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<N; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for(int j=1; j<=N+1; j++){ // K가 1일때 2일때 3일때 --- K+1 일때까지 반복
                int max = Manhattan(j);
                if(max > mmax){
                    mmax = max;
                }
            }
            bw.write("#" + i + " " + mmax + "\n");

        }
        bw.flush();
        bw.close();
    }
    static int Manhattan(int K){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int max = 0;
        for(int i=0; i<N; i++){ // 현재 위치 나타냄 arr[j][k] == 현재 위치
            for(int j=0; j<N; j++){
                int count = 0;

                for(int k=0; k<N; k++){ // 현재 위치에서 1이 있는 위치를 찾기
                    for(int l=0; l<N; l++){ // 현재 위치에서 1이 있는 좌표가 현재 도달 가능한 거리라면?
                        if(arr[k][l] == 1 && Math.abs(i-k) + Math.abs(j-l) <= K-1){
                            count++;
                        }
                    }
                }
                // 현재 위치가 이동할때마다 진행해주고
                // M * 범위에 들어간 집의 수 - 운영 비용이 -가 아니라면
                if(M * count - (K*K + (K-1) * (K-1)) >= 0){
                    arrayList.add(count);
                }
                else{
                    arrayList.add(0);
                }
            }
        }
        // 모든 위치를 현재위치로서 탐색을 끝냈다면 어레이리스트중에 가장 큰거 찾으면 댐.
        for(int i=0; i< N*N; i++){
            if(arrayList.get(i) > max){
                max = arrayList.get(i);
            }
        }
        return max;
        // arraylist 중에서 가장 큰 값을 찾았으니 max를 main으로 넘겨주고
    }
}