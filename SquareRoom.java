import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SquareRoom {
    static int[][] arr;
    static int[][] CO;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        for(int i=1;i<=testcase;i++){

            int N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            CO = new int[N][N];
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j =0; j < N; j++){ // 배열에 각 점들을 시작점으로 삼았을때 카운트 갯수가 나와있음
                for(int k = 0; k<N;k++){
                    count = 1;
                    CO[j][k] = dfs(j,k,N);
                }
            }

            for (int j =0; j < N; j++){ // 카운트가 가장 높은 수 비교
                for(int k = 0; k<N;k++){
                    if(CO[j][k] > max){
                        max = CO[j][k]; // max는 카운트가 가장 큰 카운트
                    }
                }
            }
            for (int j =0; j < N; j++){ // 카운트가 가장 높은 수가 여러개라면
                for(int k = 0; k<N;k++){
                    if(max == CO[j][k]){
                        if(arr[j][k] < min){ // 배열 값중에 가장 작은 값
                            min = arr[j][k]; // min은 카운트가 가장 큰 것들중 가장 적은 시작점 숫자.
                        }
                    }
                }
            }
            bw.write("#" + i + " " + min + " " + max + "\n");
        }
        bw.flush();
        bw.close();

    }
    static int dfs(int y, int x, int N){ // 0,0
        if(y-1 >= 0 && arr[y-1][x] == arr[y][x] + 1){ //-1,0
            count++;
            dfs(y-1,x,N);
        }
        else if(y+1 < N && arr[y+1][x] == arr[y][x] + 1){ // 1,0
            count++;
            dfs(y+1,x,N);
        }
        else if(x-1 >= 0 && arr[y][x-1] == arr[y][x] + 1){ // 0, -1
            count++;
            dfs(y,x-1,N);
        }
        else if(x+1 < N && arr[y][x+1] == arr[y][x] + 1){ // 0,1
            count++;
            dfs(y,x+1,N);
        }
        return count;
    }
}

