// https://leetcode.com/problems/digit-frequency-score/
/**
 * @param {number} n
 * @return {number}
 */
var digitScore = function(n) {
    const freq = new Array(10).fill(0);
    while (n > 0) {
        freq[n % 10]++;
        n = Math.floor(n / 10);
    }
    let score = 0;
    for (let d = 0; d <= 9; d++) {
        score += d * freq[d];
    }
    return score;
};
