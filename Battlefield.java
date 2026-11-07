import java.io.*;
import java.util.*;

public class Solution{
	static int direction = 0;
	static char[][] arr;
	static char[] define;
	static int N;
	static int sty;
	static int stx;
	static int H;
	static int W;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			arr = new char[H][W];
			
			sty = 0;
			stx = 0;
			
			
			
			for(int j=0; j<H; j++) { // 배열 채우기
				String S = br.readLine();
				for(int k=0; k<W; k++) {
					arr[j][k] = S.charAt(k);
					if(arr[j][k] == '>') {
						sty = j;
						stx = k;
						direction = 1;       // 1이면 오른쪽 보고 있음
					}
					else if(arr[j][k] == '<') {
						sty = j;
						stx = k;
						direction = -1;      // -1이면 왼쪽보고있음
					}
					else if(arr[j][k] == '^') {
						sty = j;
						stx = k;
						direction = 2;       // 2이면 위쪽 보고 있음
					}
					else if(arr[j][k] == 'v') {
						sty = j;
						stx = k;
						direction = -2;      // -2이면 아래쪽 보고 있음
					}
					
				}
			}
			
			N = Integer.parseInt(br.readLine());
			String SS = br.readLine();
			define = new char[N];
			for(int j=0; j<N; j++) {
				define[j] = SS.charAt(j);
			}
			
			
			
			rules();
			
			
			bw.write("#" + i + " ");
			for(int j=0; j<H; j++) {
				for(int k=0; k<W; k++) {
					bw.write(arr[j][k]);
				}
				bw.write("\n");
			}
			
			
		}
		bw.flush();
		bw.close();
		
	}
	static void rules() {
		
		for(int i=0; i<N; i++) { // N개의 명령을 반복
			if(define[i] == 'S') {
				int l = 1;
				if(direction == 1) { // 오른쪽으로 포탄을 쏜다.
					// 현재 위치에서 오른쪽으로 x 좌표 증가하면서 
					while(stx + l < W) {
						if(arr[sty][stx + l] == '*') {
							arr[sty][stx + l] = '.';
							break;
						}
						else if(arr[sty][stx + l] == '#') {
							break;
						}
						l++;
					}
				}
				else if(direction == -1) {
					while(stx - l >= 0) {
						if(arr[sty][stx - l] == '*') {
							arr[sty][stx - l] = '.';
							break;
						}
						else if(arr[sty][stx - l] == '#') {
							break;
						}
						l++;
					}
				}
				else if(direction == 2) {
					while(sty - l >= 0) {
						if(arr[sty - l][stx] == '*') {
							arr[sty - l][stx] = '.';
							break;
						}
						else if(arr[sty - l][stx] == '#') {
							break;
						}
						l++;
					}
				}
				else if(direction == -2) {
					while(sty + l < H) {
						if(arr[sty + l][stx] == '*') {
							arr[sty + l][stx] = '.';
							break;
						}
						else if(arr[sty + l][stx] == '#') {
							break;
						}
						l++;
					}
				}
			}
			else if(define[i] == 'U') {
				direction = 2;
				arr[sty][stx] = '^';	
				if(sty-1 >= 0 && arr[sty-1][stx] == '.') {
					arr[sty][stx] = '.';
					sty--;
					arr[sty][stx] = '^';
				}
			}
			else if(define[i] == 'D') {
				direction = -2;
				arr[sty][stx] = 'v';
				if(sty+1 < H && arr[sty+1][stx] == '.') {
					arr[sty][stx] = '.';
					sty++;
					arr[sty][stx] = 'v';
				}
			}
			else if(define[i] == 'L') {
				direction = -1;
				arr[sty][stx] = '<';
				if(stx-1 >= 0 && arr[sty][stx-1] == '.') {
					arr[sty][stx] = '.';
					stx--;
					arr[sty][stx] = '<';
				}
			}
			else if(define[i] == 'R') {
				direction = 1;
				arr[sty][stx] = '>';
				if(stx+1 < W && arr[sty][stx+1] == '.') {
					arr[sty][stx] = '.';
					stx++;
					arr[sty][stx] = '>';
				}
			}
			
			
		}
		
		
//		.	평지(전차가 들어갈 수 있다.)
//		*	벽돌로 만들어진 벽
//		#	강철로 만들어진 벽
//		-	물(전차는 들어갈 수 없다.)
//		^	위쪽을 바라보는 전차(아래는 평지이다.)
//		v	아래쪽을 바라보는 전차(아래는 평지이다.)
//		<	왼쪽을 바라보는 전차(아래는 평지이다.)
//		>	오른쪽을 바라보는 전차(아래는 평지이다.)
//		전차가 이동을 하려고 할 때, 만약 게임 맵 밖이라면 전차는 당연히 이동하지 않는다.
//
//		전차가 포탄을 발사하면, 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.
//
//		만약 포탄이 벽에 부딪히면 포탄은 소멸하고, 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.
//
//		강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.
//
//		게임 맵 밖으로 포탄이 나가면 아무런 일도 일어나지 않는다.

		
		
		
	}
}
