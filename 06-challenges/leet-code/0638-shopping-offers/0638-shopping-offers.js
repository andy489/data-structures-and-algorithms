// https://leetcode.com/problems/shopping-offers/

var shoppingOffers = function(price, special, needs) {
    const memo = new Map();
    function dfs(remaining) {
        const key = remaining.join(',');
        if (memo.has(key)) return memo.get(key);
        let cost = remaining.reduce((sum, cnt, i) => sum + cnt * price[i], 0);
        for (const offer of special) {
            const next = [];
            let applicable = true;
            for (let i = 0; i < remaining.length; i++) {
                const diff = remaining[i] - offer[i];
                if (diff < 0) { applicable = false; break; }
                next.push(diff);
            }
            if (applicable) {
                cost = Math.min(cost, offer[offer.length - 1] + dfs(next));
            }
        }
        memo.set(key, cost);
        return cost;
    }
    return dfs(needs);
};
