// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/
var maximumLength = function(s) {
    const runs = {};
    let i = 0;
    while (i < s.length) {
        let j = i;
        while (j < s.length && s[j] === s[i]) j++;
        const c = s[i];
        if (!runs[c]) runs[c] = [];
        runs[c].push(j - i);
        i = j;
    }
    let result = -1;
    for (const runLengths of Object.values(runs)) {
        const maxRun = Math.max(...runLengths);
        let lo = 1, hi = maxRun;
        while (lo <= hi) {
            const mid = Math.floor((lo + hi) / 2);
            const count = runLengths.reduce((acc, r) => acc + Math.max(0, r - mid + 1), 0);
            if (count >= 3) {
                result = Math.max(result, mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
    }
    return result;
};
