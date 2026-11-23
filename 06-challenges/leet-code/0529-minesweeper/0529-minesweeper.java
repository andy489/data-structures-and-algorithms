// https://leetcode.com/problems/minesweeper/

// Solution: DFS — O(m·n) time, O(m·n) space
class Solution {
    private static final int[][] DIRS = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        dfs(board, row, col);
        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (board[row][col] != 'E') {
            return;
        }
        int mineCount = 0;
        for (int[] dir : DIRS) {
            int nr = row + dir[0], nc = col + dir[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'M') {
                mineCount++;
            }
        }
        if (mineCount > 0) {
            board[row][col] = (char)('0' + mineCount);
        } else {
            board[row][col] = 'B';
            for (int[] dir : DIRS) {
                dfs(board, row + dir[0], col + dir[1]);
            }
        }
    }
}

// Solution 2: BFS — O(m·n) time, O(m·n) space
class Solution2 {
    private static final int[][] DIRS = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        board[click[0]][click[1]] = 'B';
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            int mineCount = 0;
            List<int[]> neighbors = new ArrayList<>();
            for (int[] dir : DIRS) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (board[nr][nc] == 'M') {
                        mineCount++;
                    } else if (board[nr][nc] == 'E') {
                        neighbors.add(new int[]{nr, nc});
                    }
                }
            }
            if (mineCount > 0) {
                board[row][col] = (char)('0' + mineCount);
            } else {
                for (int[] neighbor : neighbors) {
                    board[neighbor[0]][neighbor[1]] = 'B';
                    queue.offer(neighbor);
                }
            }
        }
        return board;
    }
}
