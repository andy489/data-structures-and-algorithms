// https://leetcode.com/problems/strange-printer-ii/

var isPrintable = function(targetGrid) {
    const m = targetGrid.length, n = targetGrid[0].length;
    const C = 60;
    const top = new Array(C + 1).fill(m);
    const bottom = new Array(C + 1).fill(-1);
    const left = new Array(C + 1).fill(n);
    const right = new Array(C + 1).fill(-1);
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const c = targetGrid[i][j];
            top[c] = Math.min(top[c], i);
            bottom[c] = Math.max(bottom[c], i);
            left[c] = Math.min(left[c], j);
            right[c] = Math.max(right[c], j);
        }
    }
    const deps = Array.from({length: C + 1}, () => new Set());
    for (let c = 1; c <= C; c++) {
        if (bottom[c] === -1) continue;
        for (let i = top[c]; i <= bottom[c]; i++) {
            for (let j = left[c]; j <= right[c]; j++) {
                if (targetGrid[i][j] !== c) deps[c].add(targetGrid[i][j]);
            }
        }
    }
    const indegree = new Array(C + 1).fill(0);
    for (let c = 1; c <= C; c++) indegree[c] = deps[c].size;
    const queue = [];
    for (let c = 1; c <= C; c++) {
        if (bottom[c] !== -1 && indegree[c] === 0) queue.push(c);
    }
    let processed = 0, head = 0;
    while (head < queue.length) {
        const cur = queue[head++];
        processed++;
        for (let c = 1; c <= C; c++) {
            if (deps[c].has(cur)) {
                indegree[c]--;
                if (indegree[c] === 0) queue.push(c);
            }
        }
    }
    const usedColors = [...Array(C).keys()].filter(c => bottom[c + 1] !== -1).length;
    return processed === usedColors;
};
