// https://leetcode.com/problems/valid-tic-tac-toe-state/

var validTicTacToe = function(board) {
    const flat = board.join('');
    const xCount = (flat.match(/X/g) || []).length;
    const oCount = (flat.match(/O/g) || []).length;
    if (oCount > xCount || xCount > oCount + 1) return false;
    function wins(c) {
        for (let i = 0; i < 3; i++) {
            if (board[i].split('').every(ch => ch === c)) return true;
            if ([0,1,2].every(j => board[j][i] === c)) return true;
        }
        return (board[0][0]===c&&board[1][1]===c&&board[2][2]===c) ||
               (board[0][2]===c&&board[1][1]===c&&board[2][0]===c);
    }
    const xWins = wins('X'), oWins = wins('O');
    if (xWins && oWins) return false;
    if (xWins && xCount !== oCount + 1) return false;
    if (oWins && xCount !== oCount) return false;
    return true;
};
