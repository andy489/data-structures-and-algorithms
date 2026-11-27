// https://leetcode.com/problems/maximize-happiness-of-selected-children/

var maximumHappinessSum = function(happiness, k) {
    happiness.sort((a,b) => b-a);
    let total = 0n;
    for (let i = 0; i < k; i++) total += BigInt(Math.max(0, happiness[i] - i));
    return total;
};
