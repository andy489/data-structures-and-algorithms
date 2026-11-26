// https://leetcode.com/problems/word-search-ii/

// Solution: Trie + DFS Backtracking
var findWords = function(board, words) {
    const root = { children: {}, word: null };
    for (const w of words) {
        let node = root;
        for (const c of w) {
            if (!node.children[c]) node.children[c] = { children: {}, word: null };
            node = node.children[c];
        }
        node.word = w;
    }

    const m = board.length, n = board[0].length;
    const result = [];

    function dfs(r, c, node) {
        if (r < 0 || r >= m || c < 0 || c >= n) return;
        const ch = board[r][c];
        if (ch === '#' || !node.children[ch]) return;
        node = node.children[ch];
        if (node.word) {
            result.push(node.word);
            node.word = null;
        }
        board[r][c] = '#';
        dfs(r + 1, c, node);
        dfs(r - 1, c, node);
        dfs(r, c + 1, node);
        dfs(r, c - 1, node);
        board[r][c] = ch;
    }

    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            dfs(r, c, root);
        }
    }
    return result;
};
