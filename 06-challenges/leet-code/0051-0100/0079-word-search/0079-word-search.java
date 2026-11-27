// https://leetcode.com/problems/word-search/

// Solution: Backtracking DFS — O(m·n·4^L) time, O(L) space
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if (board[r][c] != word.charAt(idx)) return false;
        char tmp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(board, word, r + 1, c, idx + 1)
                     || dfs(board, word, r - 1, c, idx + 1)
                     || dfs(board, word, r, c + 1, idx + 1)
                     || dfs(board, word, r, c - 1, idx + 1);
        board[r][c] = tmp;
        return found;
    }
}
