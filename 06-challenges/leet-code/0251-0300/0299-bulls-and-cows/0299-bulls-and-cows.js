// https://leetcode.com/problems/bulls-and-cows/

// Solution: Single Pass with Frequency Count — O(n) time, O(1) space
var getHint = function(secret, guess) {
    let bulls = 0, cows = 0;
    const count = new Array(10).fill(0);
    for (let i = 0; i < secret.length; i++) {
        const s = +secret[i], g = +guess[i];
        if (s === g) {
            bulls++;
        } else {
            if (count[s] < 0) cows++;
            if (count[g] > 0) cows++;
            count[s]++;
            count[g]--;
        }
    }
    return `${bulls}A${cows}B`;
};
