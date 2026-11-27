// https://leetcode.com/problems/surrounded-regions/

// Solution 1: DFS from Border — O(m·n) time, O(m·n) space
class Solution {
    private char[][] board;
    private int m, n;

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0);
            if (board[i][n - 1] == 'O') dfs(i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j);
            if (board[m - 1][j] == 'O') dfs(m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        board[i][j] = 'S';
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}

// Solution 2: BFS from Border — O(m·n) time, O(m·n) space
class Solution2 {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') { board[i][0] = 'S'; queue.offer(new int[]{i, 0}); }
            if (board[i][n - 1] == 'O') { board[i][n - 1] = 'S'; queue.offer(new int[]{i, n - 1}); }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') { board[0][j] = 'S'; queue.offer(new int[]{0, j}); }
            if (board[m - 1][j] == 'O') { board[m - 1][j] = 'S'; queue.offer(new int[]{m - 1, j}); }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int ni = cell[0] + d[0], nj = cell[1] + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] == 'O') {
                    board[ni][nj] = 'S';
                    queue.offer(new int[]{ni, nj});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }
}
