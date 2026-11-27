// https://leetcode.com/problems/minimum-xor-path-in-a-grid/

/**
 * @param {number[][]} grid
 * @return {number}
 */
var minXorPath = function(grid) {
    const m = grid.length, n = grid[0].length;
    const dist = Array.from({length: m}, () => new Array(n).fill(Infinity));
    dist[0][0] = grid[0][0];
    // min-heap: [xorVal, row, col]
    const pq = [[grid[0][0], 0, 0]];

    function heapPush(heap, item) {
        heap.push(item);
        let i = heap.length - 1;
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (heap[p][0] > heap[i][0]) {
                [heap[p], heap[i]] = [heap[i], heap[p]];
                i = p;
            } else { break; }
        }
    }

    function heapPop(heap) {
        const top = heap[0];
        const last = heap.pop();
        if (heap.length > 0) {
            heap[0] = last;
            let i = 0;
            while (true) {
                let s = i, l = 2 * i + 1, r = 2 * i + 2;
                if (l < heap.length && heap[l][0] < heap[s][0]) { s = l; }
                if (r < heap.length && heap[r][0] < heap[s][0]) { s = r; }
                if (s !== i) { [heap[s], heap[i]] = [heap[i], heap[s]]; i = s; }
                else { break; }
            }
        }
        return top;
    }

    const dirs = [[0, 1], [1, 0]];
    while (pq.length > 0) {
        const [xor, r, c] = heapPop(pq);
        if (xor > dist[r][c]) { continue; }
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr < m && nc < n) {
                const nx = xor ^ grid[nr][nc];
                if (nx < dist[nr][nc]) {
                    dist[nr][nc] = nx;
                    heapPush(pq, [nx, nr, nc]);
                }
            }
        }
    }
    return dist[m - 1][n - 1];
};
