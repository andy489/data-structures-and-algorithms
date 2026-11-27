// https://leetcode.com/problems/adding-spaces-to-a-string/

// Solution: Two Pointers with Array Join — O(n + m) time, O(n + m) space
var addSpaces = function(s, spaces) {
    const result = [];
    let j = 0;

    for (let i = 0; i < s.length; i++) {
        if (j < spaces.length && i === spaces[j]) {
            result.push(' ');
            j++;
        }
        result.push(s[i]);
    }

    return result.join('');
};
