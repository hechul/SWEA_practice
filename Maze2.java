import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Maze2 {
    static int[][] arr;
    static boolean[][] TF;
    static int Ex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<=10; i++){
            int x = 0;
            int y = 0;
            Ex = 0;
            arr = new int[100][100];
            TF = new boolean[100][100];
            br.readLine(); // 1, 2, 3, 4

            for(int k = 0; k<100; k++) { // 행 100 개
                String str = br.readLine(); // 행 하나당 값 한 줄 삽입
                for (int j = 0; j < 100; j++) { // 열 100개
                    int num = str.charAt(j) - '0'; // num에 값 하나씩 삽입
                    arr[k][j] = num; // num으로 가져온 값 arr 배열에 삽입
                }
            }
            for(int j=0; j<100; j++){ // 2로 시작하는 지점 찾기
                for(int k=0; k<100; k++) {
                    if (arr[j][k] == 2) {
                        y = j;
                        x = k;
                    }
                }
            }
            dfs(y,x);

            bw.write("#" + i + " " + Ex + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x){
        TF[y][x] = true;
        if((arr[y-1][x] == 0 && TF[y-1][x] != true) || arr[y-1][x] == 3){
            dfs(y-1,x);
        }
        if((arr[y+1][x] == 0 && TF[y+1][x] != true) || arr[y+1][x] == 3){
            dfs(y+1,x);
        }
        if((arr[y][x-1] == 0 && TF[y][x-1] != true) || arr[y][x-1] == 3){
            dfs(y,x-1);
        }
        if((arr[y][x+1] == 0 && TF[y][x+1] != true) || arr[y][x+1] == 3){
            dfs(y,x+1);
        }
        if(arr[y][x] == 3){
            Ex = 1;
            return;
        }
    }
}

