// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/

var minimumPushes = function(word) {
    let total = 0;
    for (let i = 0; i < word.length; i++) total += Math.floor(i/8) + 1;
    return total;
};
