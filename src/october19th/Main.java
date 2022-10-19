package october19th;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        ArrayList<String> paths = new ArrayList<>();
        ratInAMaze(m, 0, 0, "", paths);
        System.out.println(paths);
        System.out.println(nQueen(4));

    }

    public static void ratInAMaze(int[][] maze, int r, int c, String path,
                                  ArrayList<String> res) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            res.add(path);
            return;
        }
        maze[r][c] = 0;
        if (r - 1 >= 0 && maze[r - 1][c] == 1) //UP
            ratInAMaze(maze, r - 1, c, path + 'U', res);
        if (c + 1 < maze[0].length && maze[r][c + 1] == 1) //RIGHT
            ratInAMaze(maze, r, c + 1, path + 'R', res);
        if (r + 1 < maze.length && maze[r + 1][c] == 1) //DOWN
            ratInAMaze(maze, r + 1, c, path + 'D', res);
        if (c - 1 >= 0 && maze[r][c - 1] == 1) //LEFT
            ratInAMaze(maze, r, c - 1, path + 'L', res);
        maze[r][c] = 1;
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
}
