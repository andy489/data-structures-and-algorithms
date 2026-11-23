// https://leetcode.com/problems/maximum-product-of-word-lengths/

// Solution: Bitmask — O(n^2 + n*L) time, O(n) space
var maxProduct = function(words) {
    const masks = words.map(w => {
        let mask = 0;
        for (const c of w) mask |= 1 << (c.charCodeAt(0) - 97);
        return mask;
    });
    let max = 0;
    for (let i = 0; i < words.length; i++) {
        for (let j = i + 1; j < words.length; j++) {
            if ((masks[i] & masks[j]) === 0) {
                max = Math.max(max, words[i].length * words[j].length);
            }
        }
    }
    return max;
};
