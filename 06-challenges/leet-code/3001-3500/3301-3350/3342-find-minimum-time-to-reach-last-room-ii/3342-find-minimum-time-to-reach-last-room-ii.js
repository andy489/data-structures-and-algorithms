// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/

// Solution: Dijkstra with Alternating Step Cost — O(n*m*log(n*m)) time, O(n*m) space
var minTimeToReach = function(moveTime) {
    const n = moveTime.length, m = moveTime[0].length;
    const INF = Infinity;
    const dist = Array.from({length: n}, () =>
        Array.from({length: m}, () => [INF, INF])
    );
    dist[0][0][0] = 0;

    // Min-heap: [time, row, col, parity]
    const heap = [[0, 0, 0, 0]];
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];

    const push = (item) => {
        heap.push(item);
        let i = heap.length - 1;
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (heap[p][0] <= heap[i][0]) break;
            [heap[p], heap[i]] = [heap[i], heap[p]];
            i = p;
        }
    };
    const pop = () => {
        const top = heap[0];
        const last = heap.pop();
        if (heap.length > 0) {
            heap[0] = last;
            let i = 0;
            while (true) {
                let s = i, l = 2*i+1, r = 2*i+2;
                if (l < heap.length && heap[l][0] < heap[s][0]) s = l;
                if (r < heap.length && heap[r][0] < heap[s][0]) s = r;
                if (s === i) break;
                [heap[s], heap[i]] = [heap[i], heap[s]];
                i = s;
            }
        }
        return top;
    };

    while (heap.length > 0) {
        const [t, r, c, p] = pop();
        if (t > dist[r][c][p]) continue;
        if (r === n - 1 && c === m - 1) return t;
        const cost = p === 0 ? 1 : 2;
        const np = 1 - p;
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            const arrive = Math.max(t, moveTime[nr][nc]) + cost;
            if (arrive < dist[nr][nc][np]) {
                dist[nr][nc][np] = arrive;
                push([arrive, nr, nc, np]);
            }
        }
    }
    return Math.min(...dist[n-1][m-1]);
};
