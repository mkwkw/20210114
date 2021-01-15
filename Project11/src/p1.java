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
		int dp[][] = new int[n][100001];
		//dp[i][j]=k ->i번째까지 입력된 앱에서 비용j로 확보할 수 있는 용량:k
		//i번째 앱을 활성화한 경우, 비활성화한 경우 확인 필요
		//기존 결과값보다 새로 구한 결과값이 큰지 작은지 확인 필요
		int result=100000;
		
		//예제
		//필요한 용량 m = 60
		//각 앱의 용량 30 10 20 35 40
		//각 앱의 비용 3  0  3  5  4
		
		for(int i=0; i<n; i++) {
			int c = cost[i]; //i번째 앱의 비용 //3 //0
			int s = space[i]; //i번째 앱의 용량 //30 //10
			
			for(int j=0; j<=100000; j++) {
				//비용 j
				
				//앱이 하나일 때
				if(i==0) {
					
					if(j>=c) //j가 첫번째 앱의 비용보다 같거나 크면 //j=3
						dp[i][j]=s; 
					//첫번째 앱에서 용량s를 비용j 즉, 여기서는 c로 사게 되는 것과 같음 //dp[0][3]=30
				}
				else { //앱이 2개 이상일 때
					if(j>=c)  {
						//0>=0, dp[1][0]=max(dp[0][0]=0, dp[0][0]+10=10)=10
						//3>=0, dp[1][3]=max(dp[0][3]=30, dp[0][3-0]+10=40)=30
						//i번째 앱 활성화 경우: dp[i-1][j-c]+s ->전체 비용j에서 지금 현재 앱의 비용c를 제외한 값으로 이전의 앱들에 대해 얼만큼의 용량의 앱을 살 수 있는지 보고 거기에 현재 앱의 용량을 더한다.
						//i번째 앱 비활성화 경우: dp[i-1][j] ->전체 비용j에서 이전 앱들의 용량을 살 수 있는 경우
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c]+s);
						
					}
					
					else { 
						dp[i][j] = dp[i-1][j];
						
					}
				}
				//dp값이 m보다 크면
				if(dp[i][j]>=m) //dp[0][3]=30<60 //dp[1][0]=10, dp[1][3]=30
					result = Math.min(result, j);
					
			}
		}
		br.close();
		
		System.out.println(result);

	}

}
