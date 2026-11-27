// https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
var executeInstructions = function(n, startPos, s) {
    const m = s.length;
    const answer = new Array(m).fill(0);
    const dirs = { L: [0, -1], R: [0, 1], U: [-1, 0], D: [1, 0] };
    for (let i = 0; i < m; i++) {
        let r = startPos[0], c = startPos[1];
        let count = 0;
        for (let j = i; j < m; j++) {
            const [dr, dc] = dirs[s[j]];
            r += dr;
            c += dc;
            if (r < 0 || r >= n || c < 0 || c >= n) break;
            count++;
        }
        answer[i] = count;
    }
    return answer;
};
