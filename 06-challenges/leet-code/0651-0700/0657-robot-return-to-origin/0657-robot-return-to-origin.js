// https://leetcode.com/problems/robot-return-to-origin/

var judgeCircle = function(moves) {
    let x = 0, y = 0;
    for (const c of moves) {
        if (c === 'L') x--;
        else if (c === 'R') x++;
        else if (c === 'U') y++;
        else y--;
    }
    return x === 0 && y === 0;
};
