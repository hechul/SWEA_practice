import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    static int N;
    static int K;
    static String text;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine()); //테스트 케이스 개수
        for(int i=1; i<=testcase; i++){ // 테스트 케이스 만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine()); // N과 K를 받음


            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            text = br.readLine(); // N개의 숫자 나열

            int number = Rotate();
            bw.write("#" + i + " " + number + "\n");
        }
        bw.flush();
        bw.close();

    }
    // N이 12라고 친다면
    static int Rotate(){
        TreeSet<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());
        int size = N / 4; // N이 12면 3임 (면은 4개니까 4로 나눔)
        for(int i=0; i<size; i++) {
            for (int j = 0; j < 4; j++) {
                String hex = text.substring(j * size, (j + 1) * size);
                set.add(Integer.parseInt(hex, 16)); // 16진수를 10진수로 바로 변환해서 넣기
            }
            text = text.charAt(N - 1) + text.substring(0, N - 1);
        }
        List<Integer> list = new ArrayList<>(set);
        int number = list.get(K-1);
        return number;
    }
}