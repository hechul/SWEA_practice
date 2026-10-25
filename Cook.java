import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    static int N;
    static boolean[][] visited;
    static boolean[] have;
    static int[][] arr;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){ // 테스트 케이스 갯수 만큼 반복
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            have = new boolean[N];
            min = Integer.MAX_VALUE;
            for(int j=0; j<N; j++){ // 배열 값 채우기
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<N; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0);
            bw.write("#" + i + " " + min + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int i,int count){

        int suma=0;
        int sumb=0;

        if(count != N/2 && i == N){ // 식재료를 N/2 만큼 못 골랐는데 배열의 끝에 도달 했다면 그냥 리턴
            return;
        }

        if(count == N/2){ // 식재료를 N/2 만큼 골랐다면
            // 고른것들의 모든 조합을 구하기
            for(int j=0; j<N; j++){ //모든 점을 구하기
                if(have[j] == true){ // 식재료 j가 true 일때
                    for(int k=0; k<N; k++){ // 자신을 제외하고 나머지 식재료가 true인지 본다
                        if(have[k] == true && k != j){ //해당 된다면
                            suma += arr[j][k];
                        }
                    }
                }
                else if(have[j] == false){
                    for(int k=0; k<N; k++){ // 자신을 제외하고 나머지 식재료가 false인지 본다
                        if(have[k] == false && k != j){ //해당 된다면
                            sumb += arr[j][k];
                        }
                    }
                }
            }
            int gap = Math.abs(suma - sumb);
            if(min > gap){
                min = gap;
            }
            return;
        }

        dfs(i+1,count); // 식재료 1을 안 가지고 다음으로 넘어감
        have[i] = true;
        dfs(i+1,count+1); // 식재료 1을 가지고 다음으로 넘어감
        have[i] = false;



    }
}