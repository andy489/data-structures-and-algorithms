// https://leetcode.com/problems/escape-a-large-maze/

var isEscapePossible = function(blocked, source, target) {
    const blockedSet = new Set(blocked.map(([r,c]) => r * 1000000 + c));
    const maxEnclosed = blocked.length * blocked.length >> 1;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    const bfs = (start, end) => {
        const visited = new Set([start[0]*1000000+start[1]]);
        const q = [start];
        for (let i = 0; i < q.length; i++) {
            const [r, c] = q[i];
            if (r === end[0] && c === end[1]) return true;
            if (visited.size > maxEnclosed) return true;
            for (const [dr, dc] of dirs) {
                const [nr, nc] = [r+dr, c+dc];
                const key = nr*1000000+nc;
                if (nr>=0&&nr<1000000&&nc>=0&&nc<1000000&&!blockedSet.has(key)&&!visited.has(key)) {
                    visited.add(key); q.push([nr,nc]);
                }
            }
        }
        return false;
    };
    return bfs(source, target) && bfs(target, source);
};
