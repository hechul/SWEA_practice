import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			
			Queue<Integer> wait = new ArrayDeque<>();
			
			int[] R_i = new int[n]; // 단위 무게당 요금
			int[] W_i = new int[m]; // 차량 i 의 무게
			int[] cha = new int[2*m];
			int[] jari = new int[m]; // 현재 몇번 인덱스가 몇번자리에 있는지 
			
			boolean[] TF = new boolean[n]; // 지금 자리를 차지하고 있는지 안 하고 있는지?
			
			for(int j=0; j<n; j++) {
				R_i[j] = Integer.parseInt(br.readLine()); // 단위 무게당 요금 {2, 3, 5}
			}
			
			for(int j=0; j<m; j++) {
				W_i[j] = Integer.parseInt(br.readLine()); // 차량 i 의 무게 {2, 1, 3, 8}
			}
			
			for(int j=0; j<2*m; j++) {
				cha[j] = Integer.parseInt(br.readLine()); // 차량 들어오고 나온 내역 {3, 2, -3, 1, 4, -4, -2, -1}
			}
			
			
			// R_i에 자리가 n개 만큼 주차자리 존재함
			// {2, 3, 5}
			
			for(int j=0; j<2*m; j++) { // 차량 들어오고 나온 내역대로 수입 계산
				
				if(cha[j] > 0) { // 들어온 값이 0보다 크다면 차량이 들어온 것이다.
					
					boolean parked = false;
					
					for(int k=0; k<n; k++) { // 3개의 자리를 모두 돌아봄
						
						if(TF[k] == false) { // 가장 앞쪽의 자리에서 false인 곳을 찾았다면
							TF[k] = true; // 현재 자리 쓰고있다.
							sum += W_i[cha[j]-1] * R_i[k]; // sum에 해당 차량의 무게 * 현재 남은 가장 앞 번호의 자리
							jari[cha[j]-1] = k;
							parked = true;
							break;
						}
					}
					if (!parked) { // 이 차량이 sum에 반영이 안되고 넘어갔다 라는 말은 자리가 꽉 찼다는 말
					    wait.offer(cha[j] - 1); // 큐에 지금 차량인덱스 넣어주기
					}
					
					
				}
				else if(cha[j] < 0) { // 들어온 값이 0보다 작다면 차량이 나간 것이다. 
					// TF를 false로 비워줘야 한다.
					TF[jari[(cha[j]*(-1))-1]] = false;
					
					if(!wait.isEmpty()) { // 차량이 하나 나갔다면 자리가 난 것이므로 그 자리에 큐 맨 앞에 있는 값 넣어주기
						int spot = wait.poll();
						TF[jari[(cha[j]*(-1))-1]] = true;
						sum += W_i[spot] * R_i[jari[(cha[j]*(-1))-1]];
						jari[spot] = jari[(cha[j]*(-1))-1];
					}
					
					
				}
			}
			
			
			
			bw.write("#" + i + " " + sum + "\n");
			
		}
		
		bw.flush();
		bw.close();
	
	}

	
}
