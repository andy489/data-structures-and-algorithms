// https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/

// Solution: Scan for Valid Runs — O(m*n*L) time, O(1) space
var placeWordInCrossword = function(board, word) {
    const m = board.length, n = board[0].length, L = word.length;
    const fits = (cells) => {
        if (cells.length !== L) return false;
        const rev = [...word].reverse().join('');
        for (const w of [word, rev]) {
            if (cells.every((c, i) => c === ' ' || c === w[i])) return true;
        }
        return false;
    };
    for (let r = 0; r < m; r++) {
        let run = [];
        for (let c = 0; c <= n; c++) {
            if (c < n && board[r][c] !== '#') run.push(board[r][c]);
            else { if (fits(run)) return true; run = []; }
        }
    }
    for (let c = 0; c < n; c++) {
        let run = [];
        for (let r = 0; r <= m; r++) {
            if (r < m && board[r][c] !== '#') run.push(board[r][c]);
            else { if (fits(run)) return true; run = []; }
        }
    }
    return false;
};
