// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
var maximumLength = function(s) {
    const n = s.length;
    // Build runs map
    const runs = {};
    let i = 0;
    while (i < n) {
        let j = i;
        while (j < n && s[j] === s[i]) j++;
        const c = s[i];
        if (!runs[c]) runs[c] = [];
        runs[c].push(j - i);
        i = j;
    }
    let result = -1;
    for (const [c, runLengths] of Object.entries(runs)) {
        const maxRun = Math.max(...runLengths);
        for (let len = 1; len <= maxRun; len++) {
            const count = runLengths.reduce((acc, r) => acc + Math.max(0, r - len + 1), 0);
            if (count >= 3) result = Math.max(result, len);
        }
    }
    return result;
};
