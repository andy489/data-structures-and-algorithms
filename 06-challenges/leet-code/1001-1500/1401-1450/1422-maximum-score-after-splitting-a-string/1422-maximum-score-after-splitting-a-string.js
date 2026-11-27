// https://leetcode.com/problems/maximum-score-after-splitting-a-string/

var maxScore = function(s) {
    const ones = s.split('').filter(c => c === '1').length;
    let score = 0, ans = 0;
    for (let i = 0; i < s.length - 1; i++) {
        score += s[i] === '0' ? 1 : -1;
        ans = Math.max(ans, score + ones);
    }
    return ans;
};
