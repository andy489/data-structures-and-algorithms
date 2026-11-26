// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/

var maximumLength = function(nums) {
    const freq = new Map();
    for (const x of nums) freq.set(x, (freq.get(x) || 0) + 1);
    let ans = 1;
    if (freq.has(1)) {
        const f = freq.get(1);
        ans = f % 2 === 1 ? f : f - 1;
    }
    for (const [x] of freq) {
        if (x === 1) continue;
        const sq = Math.round(Math.sqrt(x));
        if (sq * sq === x && (freq.get(sq) || 0) >= 2) continue;
        let len = 0, cur = x;
        while ((freq.get(cur) || 0) >= 2) { len += 2; cur = cur * cur; }
        if ((freq.get(cur) || 0) >= 1) len++;
        ans = Math.max(ans, len);
    }
    return ans;
};
