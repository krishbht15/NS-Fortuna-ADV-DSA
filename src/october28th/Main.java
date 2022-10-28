package october28th;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int n = 6;
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        System.out.println(fibonacciDpMemoization(n, dp));
//        System.out.println(fibonacciDpTabluation(n));
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] curr : dp) Arrays.fill(curr, -1);
        System.out.println("minPathSumRec(grid, 0, 0) = "
                + minPathSumRecMemoization(grid, 0, 0, dp));
    }

    public static int fibonacciDpMemoization(int n, int[] dp) {
        if (n == 0 || n == 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fibonacciDpMemoization(n - 1, dp) + fibonacciDpMemoization(n - 2, dp);
    }

    public static int fibonacciDpTabluation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

//    https://leetcode.com/problems/minimum-path-sum/

    public static int minPathSumRec(int[][] mat, int r, int c) {
        if (r == mat.length || c == mat[0].length) return Integer.MAX_VALUE;
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            return mat[r][c];
        }
        int right = minPathSumRec(mat, r, c + 1);
        int down = minPathSumRec(mat, r + 1, c);
        // System.out.println(right+" , "+down+" == >"+ r+","+c);
        return Math.min(right, down) + mat[r][c];
    }

    public static int minPathSumRecMemoization(int[][] mat, int r,
                                               int c, int[][] dp) {
        if (r == mat.length || c == mat[0].length) return Integer.MAX_VALUE;
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            return dp[r][c] = mat[r][c];
        }
        if (dp[r][c] != -1) return dp[r][c];
        int right = minPathSumRecMemoization(mat, r, c + 1, dp);
        int down = minPathSumRecMemoization(mat, r + 1, c, dp);
        // System.out.println(right+" , "+down+" == >"+ r+","+c);
        return dp[r][c] = Math.min(right, down) + mat[r][c];
    }

    public static int minPathSumDpTabulation(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) dp[i][j] = grid[i][j];
                else {
                    int right = j + 1 == grid[0].length ? Integer.MAX_VALUE : grid[i][j + 1];
                    int down = i + 1 == grid.length ? Integer.MAX_VALUE : grid[i + 1][j];
                    dp[i][j] = Math.min(right, down) + grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
