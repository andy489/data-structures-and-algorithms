// https://leetcode.com/problems/maximum-points-tourist-can-earn/

/**
 * @param {number} n
 * @param {number} k
 * @param {number[][]} stayScore
 * @param {number[][]} travelScore
 * @return {number}
 */
var maxScore = function(n, k, stayScore, travelScore) {
    let dp = Array.from({length: n}, (_, c) => stayScore[0][c]);
    for (let day = 1; day < k; day++) {
        const newDp = new Array(n).fill(0);
        for (let dest = 0; dest < n; dest++) {
            newDp[dest] = dp[dest] + stayScore[day][dest];
            for (let prev = 0; prev < n; prev++) {
                if (prev !== dest) {
                    newDp[dest] = Math.max(newDp[dest], dp[prev] + travelScore[prev][dest]);
                }
            }
        }
        dp = newDp;
    }
    return Math.max(...dp);
};
