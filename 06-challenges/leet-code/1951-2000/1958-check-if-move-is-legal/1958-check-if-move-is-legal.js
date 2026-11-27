// https://leetcode.com/problems/check-if-move-is-legal/
var checkMove = function(board, rMove, cMove, color) {
    board[rMove][cMove] = color;
    const opposite = color === 'W' ? 'B' : 'W';
    const dirs = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]];
    for (const [dr, dc] of dirs) {
        let r = rMove + dr, c = cMove + dc;
        let count = 0;
        while (r >= 0 && r < 8 && c >= 0 && c < 8) {
            if (board[r][c] === opposite) {
                count++;
            } else if (board[r][c] === color) {
                if (count >= 1) {
                    return true;
                }
                break;
            } else {
                break;
            }
            r += dr;
            c += dc;
        }
    }
    return false;
};
