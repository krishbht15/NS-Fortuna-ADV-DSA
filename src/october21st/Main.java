package october21st;

public class Main {
    public static void main(String[] args) {

    }
    static int minimumCoins(int target){
//Enter your code here
        int[] arr={1, 2, 5, 10, 20, 50, 100, 200, 500 ,2000};
        int ans=0;
        for(int i=9;i>=0;i--){
            if(target==0)break;
            ans+=target/arr[i];
            target=target%arr[i];
        }
        return ans;
    }

    public static int sol(int[] arr,int i,int t){
        if(t==0)return 0;
        if( t<0 || arr[i]>t || i==arr.length) return Integer.MAX_VALUE;
        int accept= sol(arr,i,t-arr[i]);
        int rejection= sol(arr,i+1,t);
        if(accept == Integer.MAX_VALUE) return rejection;
        return Math.min(accept+1,rejection);
    }
    static int Phone(int N, int K, int M){
//Enter your code here
        if(N*K<M) return -1;
        if(M%K==0)return M/K;
        return (M/K)+1;
    }
    static int recPhone(int n,int k,int m){
        if(n*k<m)return -1;
        if(m<=0)return 0;
        int numOfApps= recPhone(n-1,k,m-k);
        return 1+numOfApps;
    }
}
