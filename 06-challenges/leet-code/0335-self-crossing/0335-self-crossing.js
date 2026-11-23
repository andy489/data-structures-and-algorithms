// https://leetcode.com/problems/self-crossing/

// Solution: Case Analysis — O(n) time, O(1) space
var isSelfCrossing = function(distance) {
    const d = distance;
    for (let i = 3; i < d.length; i++) {
        if (d[i] >= d[i-2] && d[i-1] <= d[i-3]) return true;
        if (i >= 4 && d[i-1] === d[i-3] && d[i] + d[i-4] >= d[i-2]) return true;
        if (i >= 5 && d[i-2] >= d[i-4]
                && d[i] + d[i-4] >= d[i-2]
                && d[i-1] <= d[i-3]
                && d[i-1] + d[i-5] >= d[i-3]) return true;
    }
    return false;
};
