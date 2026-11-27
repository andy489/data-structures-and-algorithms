// https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/
var wordCount = function(startWords, targetWords) {
    const startMasks = new Set();
    for (const w of startWords) {
        let mask = 0;
        for (const c of w) {
            mask |= 1 << (c.charCodeAt(0) - 97);
        }
        startMasks.add(mask);
    }
    let count = 0;
    for (const w of targetWords) {
        let mask = 0;
        for (const c of w) {
            mask |= 1 << (c.charCodeAt(0) - 97);
        }
        for (let i = 0; i < 26; i++) {
            if (mask & (1 << i)) {
                if (startMasks.has(mask ^ (1 << i))) {
                    count++;
                    break;
                }
            }
        }
    }
    return count;
};
