// https://leetcode.com/problems/cat-and-mouse/

var catMouseGame = function(graph) {
    const DRAW = 0, MOUSE = 1, CAT = 2, n = graph.length;
    const color = Array.from({length:n}, () => Array.from({length:n}, () => [0,0,0]));
    const degree = Array.from({length:n}, () => Array.from({length:n}, () => [0,0,0]));
    for (let m = 0; m < n; m++) {
        for (let c = 0; c < n; c++) {
            degree[m][c][1] = graph[m].length;
            degree[m][c][2] = graph[c].filter(x => x !== 0).length;
        }
    }
    const queue = [];
    for (let i = 1; i < n; i++) {
        for (const t of [1, 2]) {
            color[0][i][t] = MOUSE; queue.push([0, i, t]);
            color[i][i][t] = CAT;   queue.push([i, i, t]);
        }
    }
    for (let qi = 0; qi < queue.length; qi++) {
        const [m, c, t] = queue[qi];
        const result = color[m][c][t];
        const prevT = 3 - t;
        if (prevT === 1) {
            for (const pm of graph[m]) {
                if (color[pm][c][1] !== DRAW) continue;
                if (result === MOUSE) { color[pm][c][1] = MOUSE; queue.push([pm, c, 1]); }
                else if (--degree[pm][c][1] === 0) { color[pm][c][1] = CAT; queue.push([pm, c, 1]); }
            }
        } else {
            for (const pc of graph[c]) {
                if (pc === 0 || color[m][pc][2] !== DRAW) continue;
                if (result === CAT) { color[m][pc][2] = CAT; queue.push([m, pc, 2]); }
                else if (--degree[m][pc][2] === 0) { color[m][pc][2] = MOUSE; queue.push([m, pc, 2]); }
            }
        }
    }
    return color[1][2][1];
};
