import java.io.*;
import java.util.*;

public class Solution{
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int i=1; i<=10; i++) {
			int T =Integer.parseInt(br.readLine());
			String search = br.readLine();
			String word = br.readLine();
			int count = 0;
			
			for(int j=0; j<word.length(); j++) {
				String test = "";
				for(int k=0; k<search.length(); k++) {
					if(j+k < word.length()) {
						test += word.charAt(j+k);
					}
				}
				if(test.equals(search)) {
					count++;
				}
			}
			
			bw.write("#" + i + " " + count + "\n");
			
			
			
		}
		
		bw.flush();
		bw.close();
		
	}

	
}