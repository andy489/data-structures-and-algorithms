// https://leetcode.com/problems/ipo/

var findMaximizedCapital = function(k, w, profits, capital) {
    const projects = capital.map((c, i) => [c, profits[i]]).sort((a, b) => a[0] - b[0]);
    // max-heap via sorted insertion (simple for interview; real code uses a heap library)
    const maxHeap = [];
    let i = 0;
    for (let round = 0; round < k; round++) {
        while (i < projects.length && projects[i][0] <= w) {
            maxHeap.push(projects[i][1]);
            i++;
        }
        if (maxHeap.length === 0) break;
        maxHeap.sort((a, b) => b - a);
        w += maxHeap.shift();
    }
    return w;
};
