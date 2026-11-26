// https://leetcode.com/problems/number-of-valid-words-in-a-sentence/

// Solution: Manual Parse — O(n) time, O(n) space
var countValidWords = function(sentence) {
    const isValid = (t) => {
        if (!t) return false;
        let hyphens = 0;
        for (let i = 0; i < t.length; i++) {
            const c = t[i];
            if (/\d/.test(c)) return false;
            if (c === '-') {
                hyphens++;
                if (hyphens > 1 || i === 0 || i === t.length-1 || !/[a-z]/.test(t[i-1]) || !/[a-z]/.test(t[i+1])) return false;
            }
            if ('!.,'.includes(c) && i !== t.length - 1) return false;
        }
        return true;
    };
    return sentence.split(/\s+/).filter(isValid).length;
};
