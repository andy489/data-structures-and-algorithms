// https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/

var maxNumOfSubstrings = function(s) {
    const n = s.length;
    const first = new Array(26).fill(Infinity);
    const last = new Array(26).fill(-1);
    for (let i = 0; i < n; i++) {
        const c = s.charCodeAt(i) - 97;
        first[c] = Math.min(first[c], i);
        last[c] = Math.max(last[c], i);
    }

    function getRight(i) {
        let r = last[s.charCodeAt(i) - 97];
        for (let j = i; j <= r; j++) {
            const c = s.charCodeAt(j) - 97;
            if (first[c] < i) return -1;
            r = Math.max(r, last[c]);
        }
        return r;
    }

    const result = [];
    let prevEnd = -1;
    for (let i = 0; i < n; i++) {
        const c = s.charCodeAt(i) - 97;
        if (first[c] !== i) continue;
        const r = getRight(i);
        if (r === -1) continue;
        if (i > prevEnd) {
            result.push(s.slice(i, r + 1));
            prevEnd = r;
        } else if (r - i + 1 < result[result.length - 1].length) {
            result[result.length - 1] = s.slice(i, r + 1);
            prevEnd = r;
        }
    }
    return result;
};
