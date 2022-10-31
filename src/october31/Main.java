package october31;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] arr = {{1, 4},
                {2, 65},
                {45, 56},
                {23, 24},
                {45, 90}};
//        System.out.println(longestChainSubseq(arr));
        System.out.println(lcsString("ADBECF", "DABC"));
    }

    public static int longestChainSubseq(int[][] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            int currMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j][1] < arr[i][0]) {
                    currMax = Math.max(currMax, dp[j]);
                }
            }
            dp[i] += currMax;
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) ans = Math.max(ans, dp[i]);
        return ans;
    }

    public static int lengthOfLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static String lcsString(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        int ansLen = dp[s1.length()][s2.length()];
        char[] tempAns = new char[ansLen];
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0 && ansLen > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                tempAns[--ansLen] = s1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }
        String ans = "";
        for ( i = 0; i < tempAns.length; i++) ans += tempAns[i];
        return ans;
    }

}
