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
    static int min;
    static int day;
    static int month1;
    static int month3;
    static int year;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        for(int i=1; i<=testcase; i++){
            arr = new int[12];
            min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine()); // 이용권 가격 입력받기
            day = Integer.parseInt(st.nextToken());
            month1 = Integer.parseInt(st.nextToken());
            month3 = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            StringTokenizer stt = new StringTokenizer(br.readLine()); // 12개월 이용 계획 입력받기
            for(int j=0; j<12; j++){
                arr[j] = Integer.parseInt(stt.nextToken());
            }
            dfs(0,1);
            bw.write("#" + i + " " + min + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int result,int month){
        if(month == 13){ // 모든 달을 다 돌아보었다면
            if(result < min){
                min = result;
            }
            return;
        }
        if (arr[month - 1] == 0){ // 해당 달의 값이 0 이라면 다음달로 넘겨버림
            dfs(result,month+1);
        }
        dfs(result+day*arr[month-1],month+1); // 해당 달을 1일 이용권으로 해결하는 경우
        dfs(result+month1,month+1); // 해당 달을 한달 이용권으로 해결하는 경우
        if(month<11) {
            dfs(result + month3, month + 3); // 해당 달을 세달 이용권으로 해결하는 경우
        }
        if(month==11){
            dfs(result + month3, month + 2);
        }
        if(month==12){
            dfs(result + month3, month + 1);
        }
        if(month == 1) { // 첫달 부터 가격을 매길때만 1년 이용권 사용가능
            dfs(result + year, month + 12); // 해당 달을 1년 이용권으로 해결하는 경우
        }
    }
}