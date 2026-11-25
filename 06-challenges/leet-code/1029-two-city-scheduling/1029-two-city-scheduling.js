// https://leetcode.com/problems/two-city-scheduling/

var twoCitySchedCost = function(costs) {
    costs.sort((a, b) => (a[1] - a[0]) - (b[1] - b[0]));
    const n = costs.length >> 1;
    let total = 0;
    for (let i = 0; i < n; i++) total += costs[i][1];
    for (let i = n; i < 2 * n; i++) total += costs[i][0];
    return total;
};
