import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class KillFlies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine()); // 10
        for(int i=1; i<=testcase; i++){

            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 5  배열의 크기
            int M = Integer.parseInt(st.nextToken()); // 2  파리채의 크기
            int[][] arr = new int[N][N];

            for(int j=0;j<N;j++) { // 배열의 값들을 초기화 하는 for 문
                int y = 0;
                StringTokenizer stt = new StringTokenizer(br.readLine());
                for(int k=0; k<N; k++) {
                    arr[j][y++] = Integer.parseInt(stt.nextToken());
                }
            }

            // 파리채의 크기로 가장 큰 파리를 잡을 수 있는 값 구하기
            for(int j=0; j<N; j++){ // 행 4개
                for(int k=0; k<N; k++){ // 열 4개
                    // (0,0), (0,1)
                    int hap = 0;
                    for(int m=0; m<M; m++){ // 현재 좌표에서 행 어디까지? // 0,1
                        for(int m2=0; m2<M; m2++){ // 현재 좌표에서 열 어디까지? // 0,1
                            if(N-1>=j+m && N-1>=k+m2) {
                                hap += arr[j + m][k + m2];
                            }
                        }
                    }
                    if(max < hap){ // 합이 지금 max보다 크다면 max에 hap값을 넣는다.
                        max = hap;
                    }
                }
            }
            bw.write("#" + i + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }
}

