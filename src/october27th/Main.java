package october27th;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int[] arr = {10};
        test(arr);
        System.out.println("second " + arr[0]);
    }

    public static void test(int[] a) {
        a[0] = 0;
        System.out.println("first " + a[0]);
    }

    public static List<List<String>> nQueen(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        nQueenSol(board, 0, 0, ans);
        return ans;
    }

    public static void nQueenSol(boolean[][] board, int r, int c, List<List<String>> ans) {
        if (r == board.length) {
            ArrayList<String> currList = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String currString = "";
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]) currString += 'Q';
                    else currString += '.';
                }
                currList.add(currString);
            }
            ans.add(currList);
            return;
        }
        if (canQueenBePlaced(board, r, c)) {
            board[r][c] = true;
            nQueenSol(board, r + 1, 0, ans);
            board[r][c] = false;
        }
        if (c + 1 < board.length) nQueenSol(board, r, c + 1, ans);
    }

    public static boolean canQueenBePlaced(boolean[][] board, int r, int c) {
        //to move up - r-1
        // to move up-right = r-1,c+1
        //to move up-left = r-1,c-1
        int nr = r;
        int nc = c;
        while (nr >= 0) {
            if (board[nr][nc]) return false;
            nr--;
        }
        nr = r;
        while (nr >= 0 && nc >= 0) {
            if (board[nr][nc]) return false;
            nr--;
            nc--;
        }
        nr = r;
        nc = c;
        while (nr >= 0 && nc < board[0].length) {
            if (board[nr][nc]) return false;
            nr--;
            nc++;
        }
        return true;
    }

    public boolean sudokuSolve(char[][] board, int count) {
        if (count == 81) return true;
        int r = count / 9;
        int c = count % 9;
        if (board[r][c] != '.') {
            return sudokuSolve(board, count + 1);
        }
        for (int i = 1; i <= 9; i++) {
            char curr = (char) (i + '0');
            if (canNumBePlaced(board, r, c, curr)) {
                board[r][c] = curr;
                boolean recRes = sudokuSolve(board, count + 1);
                if (recRes) return true;
                board[r][c] = '.';
            }
        }
        return false;
    }

    public boolean canNumBePlaced(char[][] board, int r, int c, char num) {
        for (int i = 0; i < 9; i++) if (board[i][c] == num) return false;
        for (int i = 0; i < 9; i++) if (board[r][i] == num) return false;
        int sr = r - (r % 3);
        int sc = c - (c % 3);
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}
