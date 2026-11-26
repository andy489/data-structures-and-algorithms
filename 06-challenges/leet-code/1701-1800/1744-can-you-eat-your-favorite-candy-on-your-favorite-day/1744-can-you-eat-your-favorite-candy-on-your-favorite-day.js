// https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/

var canEat = function(candiesCount, queries) {
    const n = candiesCount.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + candiesCount[i];
    }
    return queries.map(([type, day, cap]) => {
        return day >= prefix[type] && (day + 1) * cap > prefix[type];
    });
};
