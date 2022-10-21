package october20th;

public class Main {

    public static int uniqueDigits(int n,boolean[] visited,int curr){
        if(n==curr) return 1;
        int res=1;
        for(int i=(curr==0?1:0);i<=9;i++){
            if(visited[i])continue;
            visited[i]=true;
            res+=uniqueDigits(n,visited,curr+1);
            visited[i]=false;
        }
        return res;
    }
    public static String ans="";

    public static void maxDigit(String str, int k){
        if(k==0){
            if(ans.length()==0 || Integer.parseInt(ans)<Integer.parseInt(str)){
                ans=str;
            }
            return;
        }
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i)<str.charAt(j)){
                    maxDigit( swap(str,i,j),k-1);
                    // swap(str,i,j);
                }
            }
        }
    }

    public static String swap(String s,int i,int j){
        char ic=s.charAt(i);
        char jc=s.charAt(j);
        String res=s.substring(0,i)+jc+s.substring(i+1,j)+ic+s.substring(j+1);
        return res;
    }
}
