// https://leetcode.com/problems/robot-bounded-in-circle/

var isRobotBounded = function(instructions) {
    let x = 0, y = 0, dx = 0, dy = 1;
    for (const c of instructions) {
        if (c === 'G') { x += dx; y += dy; }
        else if (c === 'L') { [dx, dy] = [-dy, dx]; }
        else { [dx, dy] = [dy, -dx]; }
    }
    return (x === 0 && y === 0) || !(dx === 0 && dy === 1);
};
