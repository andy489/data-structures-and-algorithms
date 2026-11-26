// https://leetcode.com/problems/distinct-echo-substrings/

var distinctEchoSubstrings = function(text) {
    const n = text.length, seen = new Set();
    for (let k = 1; k*2 <= n; k++) {
        for (let i = 0; i+2*k <= n; i++) {
            const sub = text.slice(i, i+2*k);
            if (sub.slice(0,k) === sub.slice(k)) seen.add(sub);
        }
    }
    return seen.size;
};
