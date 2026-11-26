// https://leetcode.com/problems/closest-dessert-cost/

var closestCost = function(baseCosts, toppingCosts, target) {
    let ans = Infinity;

    const dfs = (idx, cost) => {
        if (Math.abs(cost - target) < Math.abs(ans - target) ||
            (Math.abs(cost - target) === Math.abs(ans - target) && cost < ans)) {
            ans = cost;
        }
        if (idx === toppingCosts.length || cost >= target) return;
        for (let k = 0; k <= 2; k++) {
            dfs(idx + 1, cost + k * toppingCosts[idx]);
        }
    };

    for (const base of baseCosts) {
        dfs(0, base);
    }
    return ans;
};
