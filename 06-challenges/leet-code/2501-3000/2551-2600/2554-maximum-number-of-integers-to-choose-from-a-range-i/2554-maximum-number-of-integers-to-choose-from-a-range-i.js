// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/

// Solution: Greedy with HashSet — O(n + b) time, O(b) space
var maxCount = function(banned, n, maxSum) {
    const bannedSet = new Set(banned);
    let count = 0, sum = 0;
    for (let i = 1; i <= n; i++) {
        if (bannedSet.has(i)) {
            continue;
        }
        if (sum + i > maxSum) {
            break;
        }
        sum += i;
        count++;
    }
    return count;
};
