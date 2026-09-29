import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MakeNumbers {
    static int N;
    static int[] calculation;
    static int[] number;
    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        for(int i=1; i<=testcase; i++){

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            calculation = new int[4];
            number = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<4; j++){
                calculation[j] = Integer.parseInt(st.nextToken());
            }
            StringTokenizer stt = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                number[j] = Integer.parseInt(stt.nextToken());
            }

            // ------- 데이터 입력 완료
            dfs(1,number[0]);

            bw.write("#" + i + " " + (max-min) + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int index,int cumulative){
        if(index == N){
            if(cumulative > max){
                max = cumulative;
            }
            if(cumulative < min){
                min = cumulative;
            }
            return;
        }

        if(calculation[0] != 0){ // + 의 개수가 0개가 아니라면
            calculation[0] = calculation[0] - 1;
            dfs(index+1, cumulative + number[index]); // index + 1 하고 number[0]에 number[1] 더하기
            calculation[0] = calculation[0] + 1;
        }
        if(calculation[1] != 0){ // - 의 개수가 0개가 아니라면
            calculation[1] = calculation[1] - 1;
            dfs(index+1, cumulative - number[index]); // index + 1 하고 number[0]에 number[1] 빼기
            calculation[1] = calculation[1] + 1;
        }
        if(calculation[2] != 0){ // * 의 개수가 0개가 아니라면
            calculation[2] = calculation[2] - 1;
            dfs(index+1, cumulative * number[index]); // index + 1 하고 number[0]에 number[1] 곱하기
            calculation[2] = calculation[2] + 1;
        }
        if(calculation[3] != 0){ // / 의 개수가 0개가 아니라면
            calculation[3] = calculation[3] - 1;
            dfs(index+1, cumulative / number[index]); // index + 1 하고 number[0]에 number[1] 나누기
            calculation[3] = calculation[3] + 1;
        }
    }
}

