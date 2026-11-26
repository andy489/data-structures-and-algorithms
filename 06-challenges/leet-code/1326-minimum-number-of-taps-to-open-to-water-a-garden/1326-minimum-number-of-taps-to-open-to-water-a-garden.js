// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/

var minTaps = function(n, ranges) {
    const maxRight = new Array(n+1).fill(0);
    for (let i = 0; i <= n; i++) {
        const left = Math.max(0, i-ranges[i]);
        maxRight[left] = Math.max(maxRight[left], i+ranges[i]);
    }
    let taps=0, curEnd=0, farthest=0;
    for (let i = 0; i <= n; i++) {
        farthest = Math.max(farthest, maxRight[i]);
        if (i === curEnd && i < n) {
            if (farthest === curEnd) return -1;
            taps++; curEnd = farthest;
        }
    }
    return taps;
};
