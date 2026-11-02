import java.io.*;
import java.util.*;

public class Solution{
	static int[] password;
	static int N;
	static boolean[] TF;
	static int GG;
	static int[] pass;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 1; i<=10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			TF = new boolean[N];
			String S = st.nextToken();
			GG = 0;
			password = new int[N];
			for(int j=0; j<N; j++) {
				password[j] = S.charAt(j) - '0';
			}  
			
			rotate(password);
			
			bw.write("#" + i + " ");
			for(int j=0; j<pass.length; j++) {
				bw.write(String.valueOf(pass[j]));
			}
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
		
		
	} //1238099084  
	static void rotate(int[] password) {
		
		TF = new boolean[password.length];
		GG = 0;
		
		String ss = "";
		
		for(int j=0; j<password.length-1; j++) { // 배열에서 붙어있는데 값이 같은것이 존재한다면
			if(password[j] == password[j+1]) {
				TF[j] = true;
				TF[j+1] = true;
				break;
			}
		}
		
		for(int j=0; j<password.length; j++) { // 삭제되지 않은 패스워드의 길이 구하기
			if(TF[j] == false) {
				GG++;
			}
		}
		
		if(GG == password.length) { // 삭제가 하나도 되지 않았다면 return
			return;
		}
		
		for(int j=0; j<password.length; j++) {  // 위에서 값이 같은 것 존재한다면 새 배열 창조 
			if(TF[j] == false) {
				ss += String.valueOf(password[j]);
			}
		}
		
		pass = new int[ss.length()];
		
		for(int j=0; j<ss.length(); j++) {
			pass[j] = ss.charAt(j) - '0';
		}  
		
		rotate(pass);
		
	}
}