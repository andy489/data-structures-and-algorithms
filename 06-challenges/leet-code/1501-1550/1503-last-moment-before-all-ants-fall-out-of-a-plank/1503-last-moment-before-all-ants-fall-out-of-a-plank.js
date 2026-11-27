// https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/

var getLastMoment = function(n, left, right) {
    let ans = 0;
    for (const pos of left) ans = Math.max(ans, pos);
    for (const pos of right) ans = Math.max(ans, n - pos);
    return ans;
};
