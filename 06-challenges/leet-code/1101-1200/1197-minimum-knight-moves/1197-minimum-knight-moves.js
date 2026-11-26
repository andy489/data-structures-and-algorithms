// https://leetcode.com/problems/minimum-knight-moves/

var minKnightMoves = function(x, y) {
    x = Math.abs(x); y = Math.abs(y);
    const dirs = [[1,2],[1,-2],[-1,2],[-1,-2],[2,1],[2,-1],[-2,1],[-2,-1]];
    const q = [[0, 0, 0]], visited = new Set(['0,0']);
    for (let i = 0; i < q.length; i++) {
        const [cx, cy, dist] = q[i];
        if (cx === x && cy === y) return dist;
        for (const [dx, dy] of dirs) {
            const [nx, ny] = [cx+dx, cy+dy];
            const key = nx+','+ny;
            if (nx >= -2 && ny >= -2 && !visited.has(key)) {
                visited.add(key); q.push([nx, ny, dist+1]);
            }
        }
    }
    return -1;
};
