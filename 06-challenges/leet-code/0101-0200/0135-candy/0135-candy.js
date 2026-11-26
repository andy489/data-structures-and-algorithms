// https://leetcode.com/problems/candy/

// Solution 1: Two-Pass Greedy — O(n) time, O(n) space
var candy = function(ratings) {
    const n = ratings.length;
    const c = new Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) c[i] = c[i - 1] + 1;
    }
    for (let i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) c[i] = Math.max(c[i], c[i + 1] + 1);
    }
    return c.reduce((s, v) => s + v, 0);
};

// Solution 2: One-Pass Greedy — O(n) time, O(1) space
var candy2 = function(ratings) {
    const n = ratings.length;
    let ans = 1, up = 0, down = 0, peak = 0;
    for (let i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) {
            down = 0; up++; peak = up; ans += up + 1;
        } else if (ratings[i] === ratings[i - 1]) {
            up = 0; down = 0; peak = 0; ans += 1;
        } else {
            up = 0; down++; ans += down + 1;
            if (down >= peak) ans++;
        }
    }
    return ans;
};
