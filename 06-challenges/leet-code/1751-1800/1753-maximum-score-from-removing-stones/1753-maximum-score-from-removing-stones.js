// https://leetcode.com/problems/maximum-score-from-removing-stones/

var maximumScore = function(a, b, c) {
    const total = a + b + c;
    const max = Math.max(a, b, c);
    const rest = total - max;
    return max >= rest ? rest : Math.floor(total / 2);
};
