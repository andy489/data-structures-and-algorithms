// https://leetcode.com/problems/walking-robot-simulation/

var robotSim = function(commands, obstacles) {
    const blocked = new Set(obstacles.map(([x, y]) => `${x},${y}`));
    const dirs = [[0,1],[1,0],[0,-1],[-1,0]];
    let d = 0, x = 0, y = 0, ans = 0;
    for (const cmd of commands) {
        if (cmd === -2) { d = (d + 3) % 4; }
        else if (cmd === -1) { d = (d + 1) % 4; }
        else {
            const [dx, dy] = dirs[d];
            for (let s = 0; s < cmd; s++) {
                if (blocked.has(`${x+dx},${y+dy}`)) break;
                x += dx; y += dy;
                ans = Math.max(ans, x*x + y*y);
            }
        }
    }
    return ans;
};
