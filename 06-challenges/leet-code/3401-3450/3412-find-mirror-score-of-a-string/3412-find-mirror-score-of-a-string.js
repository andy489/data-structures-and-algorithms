// https://leetcode.com/problems/find-mirror-score-of-a-string/
var calculateScore = function(s) {
    const stacks = Array.from({length: 26}, () => []);
    let score = 0;
    for (let i = 0; i < s.length; i++) {
        const c = s.charCodeAt(i) - 97;
        const mirror = 25 - c;
        if (stacks[mirror].length > 0) {
            score += i - stacks[mirror].pop();
        } else {
            stacks[c].push(i);
        }
    }
    return score;
};
