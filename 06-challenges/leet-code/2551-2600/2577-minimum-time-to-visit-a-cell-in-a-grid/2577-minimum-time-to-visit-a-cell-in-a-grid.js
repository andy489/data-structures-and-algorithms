// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/

/**
 * @param {number[][]} grid
 * @return {number}
 */
var minimumTime = function(grid) {
    const m = grid.length;
    const n = grid[0].length;

    if (grid[0][1] > 1 && grid[1][0] > 1) {
        return -1;
    }

    const dist = Array.from({length: m}, () => new Array(n).fill(Infinity));
    dist[0][0] = 0;

    // Min-heap using sorted array simulation (use a proper min-heap for large inputs)
    // Simple priority queue implementation
    const heap = [[0, 0, 0]]; // [time, row, col]

    function heapPush(item) {
        heap.push(item);
        let i = heap.length - 1;
        while (i > 0) {
            const parent = Math.floor((i - 1) / 2);
            if (heap[parent][0] > heap[i][0]) {
                [heap[parent], heap[i]] = [heap[i], heap[parent]];
                i = parent;
            } else {
                break;
            }
        }
    }

    function heapPop() {
        const top = heap[0];
        const last = heap.pop();
        if (heap.length > 0) {
            heap[0] = last;
            let i = 0;
            while (true) {
                let smallest = i;
                const l = 2 * i + 1;
                const r = 2 * i + 2;
                if (l < heap.length && heap[l][0] < heap[smallest][0]) smallest = l;
                if (r < heap.length && heap[r][0] < heap[smallest][0]) smallest = r;
                if (smallest !== i) {
                    [heap[smallest], heap[i]] = [heap[i], heap[smallest]];
                    i = smallest;
                } else {
                    break;
                }
            }
        }
        return top;
    }

    const dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]];

    while (heap.length > 0) {
        const [t, r, c] = heapPop();
        if (r === m - 1 && c === n - 1) return t;
        if (t > dist[r][c]) continue;
        for (const [dr, dc] of dirs) {
            const nr = r + dr;
            const nc = c + dc;
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            let nt = t + 1;
            if (nt < grid[nr][nc]) {
                const diff = grid[nr][nc] - nt;
                nt = grid[nr][nc] + (diff % 2 === 0 ? 0 : 1);
            }
            if (nt < dist[nr][nc]) {
                dist[nr][nc] = nt;
                heapPush([nt, nr, nc]);
            }
        }
    }

    return -1;
};
