//���� 7579
//��
//dp
import java.io.*;
public class p1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//n: Ȱ������ �� ��
		//m: �ʿ��� �뷮
		String arr [] = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		
		String arr1 [] = br.readLine().split(" ");
		//�뷮
		int space[] = new int [n];
		
		
		for(int i=0; i<n; i++) {
			space[i] = Integer.parseInt(arr1[i]);
		}
		
		String arr2[] = br.readLine().split(" ");
		//���
		int cost[] = new int [n];
		
		for(int i=0; i<n; i++) {
			cost[i] = Integer.parseInt(arr2[i]);
		}
		
		
		//�ּ� m����Ʈ Ȯ��, ��� �ּ�
		

	}

}
