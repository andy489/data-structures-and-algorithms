// https://leetcode.com/problems/battleships-in-a-board/

var countBattleships = function(board) {
    let count = 0;
    for (let r = 0; r < board.length; r++) {
        for (let c = 0; c < board[0].length; c++) {
            if (board[r][c] === 'X') {
                const precedingAbove = r > 0 && board[r - 1][c] === 'X';
                const precedingLeft = c > 0 && board[r][c - 1] === 'X';
                if (!precedingAbove && !precedingLeft) {
                    count++;
                }
            }
        }
    }
    return count;
};
