// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

var minCost = function(colors, neededTime) {
    let total = 0, i = 0;
    const n = colors.length;
    while (i < n) {
        let j = i, groupSum = 0, groupMax = 0;
        while (j < n && colors[j] === colors[i]) {
            groupSum += neededTime[j];
            groupMax = Math.max(groupMax, neededTime[j]);
            j++;
        }
        total += groupSum - groupMax;
        i = j;
    }
    return total;
};
