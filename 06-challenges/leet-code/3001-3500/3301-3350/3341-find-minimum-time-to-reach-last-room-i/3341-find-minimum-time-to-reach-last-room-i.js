// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/

// Solution: Dijkstra's Algorithm — O(n*m*log(n*m)) time, O(n*m) space
var minTimeToReach = function(moveTime) {
    const n = moveTime.length, m = moveTime[0].length;
    const dist = Array.from({length: n}, () => new Array(m).fill(Infinity));
    dist[0][0] = 0;

    // Min-heap: [time, row, col]
    const heap = [[0, 0, 0]];
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
        const [t, r, c] = pop();
        if (t > dist[r][c]) continue;
        if (r === n - 1 && c === m - 1) return t;
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            const arrive = Math.max(t, moveTime[nr][nc]) + 1;
            if (arrive < dist[nr][nc]) {
                dist[nr][nc] = arrive;
                push([arrive, nr, nc]);
            }
        }
    }
    return dist[n-1][m-1];
};
