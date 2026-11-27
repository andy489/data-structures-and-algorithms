// https://leetcode.com/problems/determine-if-string-halves-are-alike/

var halvesAreAlike = function(s) {
    const vowels = new Set('aeiouAEIOU');
    const half = s.length / 2;
    let count = 0;
    for (let i = 0; i < half; i++) {
        if (vowels.has(s[i])) count++;
    }
    for (let i = half; i < s.length; i++) {
        if (vowels.has(s[i])) count--;
    }
    return count === 0;
};
