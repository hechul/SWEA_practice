import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    static int N;
    static boolean[] visited;
    static int[][] arr;
    static int result;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N];
            min = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);
            bw.write("#" + i + " " + min + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int count, int start) {
        if (count == N / 2) {
            int sumA = 0;
            int sumB = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        sumA += arr[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        sumB += arr[i][j];
                    }
                }
            }

            result = Math.abs(sumA - sumB);

            if (min > result) {
                min = result;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
