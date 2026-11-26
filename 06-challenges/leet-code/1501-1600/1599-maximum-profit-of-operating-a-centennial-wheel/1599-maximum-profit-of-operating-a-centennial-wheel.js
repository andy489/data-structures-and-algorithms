// https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/

var minOperationsMaxProfit = function(customers, boardingCost, runningCost) {
    let waiting = 0, maxProfit = 0, bestRound = -1, rotation = 0, profit = 0;
    let i = 0;
    while (i < customers.length || waiting > 0) {
        if (i < customers.length) waiting += customers[i];
        const boarded = Math.min(4, waiting);
        waiting -= boarded;
        rotation++;
        profit += boarded * boardingCost - runningCost;
        if (profit > maxProfit) {
            maxProfit = profit;
            bestRound = rotation;
        }
        i++;
    }
    return bestRound;
};
