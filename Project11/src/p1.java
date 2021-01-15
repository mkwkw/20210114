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
		int dp[][] = new int[n][100001];
		//dp[i][j]=k ->i��°���� �Էµ� �ۿ��� ���j�� Ȯ���� �� �ִ� �뷮:k
		//i��° ���� Ȱ��ȭ�� ���, ��Ȱ��ȭ�� ��� Ȯ�� �ʿ�
		//���� ��������� ���� ���� ������� ū�� ������ Ȯ�� �ʿ�
		int result=100000;
		
		//����
		//�ʿ��� �뷮 m = 60
		//�� ���� �뷮 30 10 20 35 40
		//�� ���� ��� 3  0  3  5  4
		
		for(int i=0; i<n; i++) {
			int c = cost[i]; //i��° ���� ��� //3 //0
			int s = space[i]; //i��° ���� �뷮 //30 //10
			
			for(int j=0; j<=100000; j++) {
				//��� j
				
				//���� �ϳ��� ��
				if(i==0) {
					
					if(j>=c) //j�� ù��° ���� ��뺸�� ���ų� ũ�� //j=3
						dp[i][j]=s; 
					//ù��° �ۿ��� �뷮s�� ���j ��, ���⼭�� c�� ��� �Ǵ� �Ͱ� ���� //dp[0][3]=30
				}
				else { //���� 2�� �̻��� ��
					if(j>=c)  {
						//0>=0, dp[1][0]=max(dp[0][0]=0, dp[0][0]+10=10)=10
						//3>=0, dp[1][3]=max(dp[0][3]=30, dp[0][3-0]+10=40)=30
						//i��° �� Ȱ��ȭ ���: dp[i-1][j-c]+s ->��ü ���j���� ���� ���� ���� ���c�� ������ ������ ������ �۵鿡 ���� ��ŭ�� �뷮�� ���� �� �� �ִ��� ���� �ű⿡ ���� ���� �뷮�� ���Ѵ�.
						//i��° �� ��Ȱ��ȭ ���: dp[i-1][j] ->��ü ���j���� ���� �۵��� �뷮�� �� �� �ִ� ���
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c]+s);
						
					}
					
					else { 
						dp[i][j] = dp[i-1][j];
						
					}
				}
				//dp���� m���� ũ��
				if(dp[i][j]>=m) //dp[0][3]=30<60 //dp[1][0]=10, dp[1][3]=30
					result = Math.min(result, j);
					
			}
		}
		br.close();
		
		System.out.println(result);

	}

}
