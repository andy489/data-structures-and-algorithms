// https://leetcode.com/problems/detect-capital/

var detectCapitalUse = function(word) {
    const upCount = word.split('').filter(c => c >= 'A' && c <= 'Z').length;
    return upCount === 0 || upCount === word.length || (upCount === 1 && word[0] >= 'A' && word[0] <= 'Z');
};
