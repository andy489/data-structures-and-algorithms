// https://leetcode.com/problems/surrounded-regions/

// Solution 1: DFS from Border — O(m·n) time, O(m·n) space
var solve = function(board) {
    const m = board.length, n = board[0].length;
    function dfs(i, j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] !== 'O') return;
        board[i][j] = 'S';
        dfs(i + 1, j); dfs(i - 1, j);
        dfs(i, j + 1); dfs(i, j - 1);
    }
    for (let i = 0; i < m; i++) {
        if (board[i][0] === 'O') dfs(i, 0);
        if (board[i][n - 1] === 'O') dfs(i, n - 1);
    }
    for (let j = 0; j < n; j++) {
        if (board[0][j] === 'O') dfs(0, j);
        if (board[m - 1][j] === 'O') dfs(m - 1, j);
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] === 'O') board[i][j] = 'X';
            else if (board[i][j] === 'S') board[i][j] = 'O';
        }
    }
};

// Solution 2: BFS from Border — O(m·n) time, O(m·n) space
var solve2 = function(board) {
    const m = board.length, n = board[0].length;
    const queue = [];
    for (let i = 0; i < m; i++) {
        if (board[i][0] === 'O') { board[i][0] = 'S'; queue.push([i, 0]); }
        if (board[i][n - 1] === 'O') { board[i][n - 1] = 'S'; queue.push([i, n - 1]); }
    }
    for (let j = 1; j < n - 1; j++) {
        if (board[0][j] === 'O') { board[0][j] = 'S'; queue.push([0, j]); }
        if (board[m - 1][j] === 'O') { board[m - 1][j] = 'S'; queue.push([m - 1, j]); }
    }
    const dirs = [[1,0],[-1,0],[0,1],[0,-1]];
    let head = 0;
    while (head < queue.length) {
        const [i, j] = queue[head++];
        for (const [di, dj] of dirs) {
            const ni = i + di, nj = j + dj;
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] === 'O') {
                board[ni][nj] = 'S';
                queue.push([ni, nj]);
            }
        }
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] === 'O') board[i][j] = 'X';
            else if (board[i][j] === 'S') board[i][j] = 'O';
        }
    }
};
