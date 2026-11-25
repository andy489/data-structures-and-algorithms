// https://leetcode.com/problems/shortest-distance-to-a-character/

var shortestToChar = function(s, c) {
    const n = s.length, ans = new Array(n);
    let prev = -Infinity;
    for (let i = 0; i < n; i++) {
        if (s[i] === c) { prev = i; }
        ans[i] = i - prev;
    }
    prev = Infinity;
    for (let i = n - 1; i >= 0; i--) {
        if (s[i] === c) { prev = i; }
        ans[i] = Math.min(ans[i], prev - i);
    }
    return ans;
};
