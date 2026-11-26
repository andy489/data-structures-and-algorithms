// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

var minCostToMoveChips = function(position) {
    const odd = position.filter(p => p % 2 === 1).length;
    return Math.min(odd, position.length - odd);
};
