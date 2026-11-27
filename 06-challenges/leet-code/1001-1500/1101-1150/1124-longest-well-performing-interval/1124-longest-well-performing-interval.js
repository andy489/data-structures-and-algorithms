// https://leetcode.com/problems/longest-well-performing-interval/

var longestWPI = function(hours) {
    const seen = new Map();
    let score = 0, ans = 0;
    for (let i = 0; i < hours.length; i++) {
        score += hours[i] > 8 ? 1 : -1;
        if (score > 0) {
            ans = i + 1;
        } else {
            if (seen.has(score - 1)) {
                ans = Math.max(ans, i - seen.get(score - 1));
            }
        }
        if (!seen.has(score)) {
            seen.set(score, i);
        }
    }
    return ans;
};
