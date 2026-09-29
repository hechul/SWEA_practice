import java.io.*;
import java.util.StringTokenizer;

public class Magnetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<=10; i++){ // 케이스 10번

            int table = Integer.parseInt(br.readLine()); // 테이블 크기
            int[][] arr = new int[table][table];
            int deadlock = 0;

            for(int j=0; j<table; j++){ // 배열에 값 넣기
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<table; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 교착상태 찾는 알고리즘
            for(int j=0; j<table; j++){ // 한 열을 뒤지자
                for(int k=0; k<table; k++){
                    if(arr[k][j] == 1){ // 해당 좌표가 N극 일때
                        // 밑으로 가면서 S극이 있는지 찾기
                        // 없으면 넘어가고 있으면 교착상태 발생함.
                        for(int l=k+1; l<table; l++){
                            // 해당 좌표부터 시작해서
                            // 밑으로 내려가면서 S극이 있는지 탐색
                            if(arr[l][j] == 2){
                                deadlock++;
                                break;
                            }
                            else if(arr[l][j] == 1){
                                break;
                            }
                        }
                    }
                }
            }
            bw.write("#" + i + " " + deadlock + "\n");
        }
        bw.flush();
        bw.close();
    }
}

