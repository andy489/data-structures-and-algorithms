// https://leetcode.com/problems/number-of-equivalent-domino-pairs/

var numEquivDominoPairs = function(dominoes) {
    const count = new Array(100).fill(0);
    let ans = 0;
    for (const [a, b] of dominoes) {
        const key = Math.min(a, b) * 10 + Math.max(a, b);
        ans += count[key];
        count[key]++;
    }
    return ans;
};
