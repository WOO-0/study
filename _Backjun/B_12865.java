import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다이나믹 프로그래밍
// 배낭 문제
public class B_12865{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int W[] = new int[N];
        int V[] = new int[N];
        int dp[][] = new int[N+1][K+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int w=1;w<=K;w++){
                if(w<W[i-1]){
                    dp[i][w] = dp[i-1][w];
                }
                else{
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-W[i-1]]+V[i-1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}