// https://leetcode.com/problems/average-waiting-time/

var averageWaitingTime = function(customers) {
    let totalWait = 0;
    let chefFreeAt = 0;
    for (const [arrival, prepTime] of customers) {
        chefFreeAt = Math.max(chefFreeAt, arrival) + prepTime;
        totalWait += chefFreeAt - arrival;
    }
    return totalWait / customers.length;
};
