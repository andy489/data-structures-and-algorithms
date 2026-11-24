// https://leetcode.com/problems/2-keys-keyboard/

var minSteps = function(n) {
    let steps = 0;
    for (let factor = 2; factor * factor <= n; factor++) {
        while (n % factor === 0) {
            steps += factor;
            n = Math.floor(n / factor);
        }
    }
    if (n > 1) steps += n;
    return steps;
};
