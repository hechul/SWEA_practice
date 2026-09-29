import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class HamburgerDiet {
    static int num;
    static int calorie;
    static int[][] arr;
    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine()); // 테스트 케이스
        for(int i = 1; i<=testcase; i++){ // 테스트 케이스 만큼 반복

            StringTokenizer st = new StringTokenizer(br.readLine()); // 재료 수 + 칼로리
            num = Integer.parseInt(st.nextToken()); // 재료의 수
            calorie = Integer.parseInt(st.nextToken()); // 제한 칼로리
            int hap = 0;
            max = 0;

            arr = new int[num][2];

            for(int j = 0; j<num; j++){ // 재료의 수 만큼 반복
                StringTokenizer stt = new StringTokenizer(br.readLine()); // 하나의 재료의 맛 + 해당 재료 칼로리
                arr[j][0] = Integer.parseInt(stt.nextToken()); // 재료에 대한 맛
                arr[j][1] = Integer.parseInt(stt.nextToken()); // 해당 재료 칼로리
            }

            // arr[?][0] 이 가장 높은 수 구하는 알고리즘
                dfs(0,0,0);

            bw.write("#" + i + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }
    // index : 현재 탐색 중인 재료의 인덱스
    // taste : 지금까지 누적된 맛 점수
    // cal : 지금까지 누적된 칼로리
    static void dfs(int index, int taste, int cal){ // 0, 100, 200
        if(cal > calorie){
            return;
        }
        if(index == num){ // 재료를 다 돌았을때
            if(max < taste){ // max에 저장된 값보다 누적된 맛 점수가 더 크다면
                max = taste; // max 값 지정
            }
            return;
        }

        dfs(index + 1,taste + arr[index][0],cal + arr[index][1]);

        dfs(index + 1, taste, cal);
    }
}

