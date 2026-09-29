import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class HighShelf {
    static int N = 0;
    static int B = 0;
    static int[] arr;
    static int min;
    static int now;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for(int i=1; i<=testcase; i++){ // 1

            StringTokenizer st = new StringTokenizer(br.readLine()); // 5 16
            N = Integer.parseInt(st.nextToken()); // 5
            B = Integer.parseInt(st.nextToken()); // 16
            arr = new int[N];
            min = Integer.MAX_VALUE;
            now = 0;

            StringTokenizer manager = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(manager.nextToken()); // 1 3 3 5 6
            }
            dfs(0, 0);

            bw.write("#" + i + " " + min + "\n");
        }

        bw.flush();
        bw.close();
    }
    static void dfs(int index, int sum){
        if(index == N ){
            if(B <= sum) {
                now = sum - B;
                if (now < min) {
                    min = now;
                }
            }
            return;
        }

        dfs(index+1,arr[index] + sum); // arr[0] + 0, arr[1] + arr[0], arr[0] + 0
        dfs(index+1,sum); // 0, arr[1] + 0, 0
    }
}

