// https://leetcode.com/problems/loud-and-rich/

var loudAndRich = function(richer, quiet) {
    const n = quiet.length;
    const richerThan = Array.from({length: n}, () => []);
    for (const [a, b] of richer) {
        richerThan[b].push(a);
    }
    const answer = new Array(n).fill(-1);

    function dfs(x) {
        if (answer[x] !== -1) return answer[x];
        answer[x] = x;
        for (const r of richerThan[x]) {
            const candidate = dfs(r);
            if (quiet[candidate] < quiet[answer[x]]) {
                answer[x] = candidate;
            }
        }
        return answer[x];
    }

    for (let i = 0; i < n; i++) dfs(i);
    return answer;
};
