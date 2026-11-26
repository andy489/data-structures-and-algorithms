// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

var minimumPushes = function(word) {
    const freq = new Array(26).fill(0);
    for (const c of word) freq[c.charCodeAt(0) - 97]++;
    freq.sort((a,b) => b-a);
    let total = 0;
    for (let i = 0; i < 26; i++) total += freq[i] * (Math.floor(i/8) + 1);
    return total;
};
