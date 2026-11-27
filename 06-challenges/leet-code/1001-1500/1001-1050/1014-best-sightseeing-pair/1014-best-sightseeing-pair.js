// https://leetcode.com/problems/best-sightseeing-pair/

var maxScoreSightseeingPair = function(values) {
    let maxI = values[0], ans = 0;
    for (let j = 1; j < values.length; j++) {
        ans = Math.max(ans, maxI + values[j] - j);
        maxI = Math.max(maxI, values[j] + j);
    }
    return ans;
};
