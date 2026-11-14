// https://leetcode.com/problems/word-search/

var exist = function(board, word) {
    const m = board.length, n = board[0].length;
    function dfs(r, c, idx) {
        if (idx === word.length) return true;
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] !== word[idx]) return false;
        const tmp = board[r][c];
        board[r][c] = '#';
        const found = dfs(r + 1, c, idx + 1) || dfs(r - 1, c, idx + 1)
                   || dfs(r, c + 1, idx + 1) || dfs(r, c - 1, idx + 1);
        board[r][c] = tmp;
        return found;
    }
    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (dfs(r, c, 0)) return true;
        }
    }
    return false;
};
