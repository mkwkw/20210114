//백준 7579
//앱
//dp
import java.io.*;
public class p1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//n: 활성중인 앱 수
		//m: 필요한 용량
		String arr [] = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		
		String arr1 [] = br.readLine().split(" ");
		//용량
		int space[] = new int [n];
		
		
		for(int i=0; i<n; i++) {
			space[i] = Integer.parseInt(arr1[i]);
		}
		
		String arr2[] = br.readLine().split(" ");
		//비용
		int cost[] = new int [n];
		
		for(int i=0; i<n; i++) {
			cost[i] = Integer.parseInt(arr2[i]);
		}
		
		
		//최소 m바이트 확보, 비용 최소
		

	}

}
