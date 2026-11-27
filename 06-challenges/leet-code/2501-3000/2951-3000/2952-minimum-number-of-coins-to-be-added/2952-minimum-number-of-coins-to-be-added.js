// https://leetcode.com/problems/minimum-number-of-coins-to-be-added/
var minimumAddedCoins = function(coins, target) {
    coins.sort((a, b) => a - b);
    let added = 0;
    let reach = 0;
    let i = 0;
    while (reach < target) {
        if (i < coins.length && coins[i] <= reach + 1) {
            reach += coins[i];
            i++;
        } else {
            reach += reach + 1;
            added++;
        }
    }
    return added;
};
