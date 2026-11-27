// https://leetcode.com/problems/count-the-number-of-consistent-strings/

var countConsistentStrings = function(allowed, words) {
    let mask = 0;
    for (const c of allowed) {
        mask |= (1 << (c.charCodeAt(0) - 97));
    }
    let count = 0;
    for (const word of words) {
        let consistent = true;
        for (const c of word) {
            if (!(mask & (1 << (c.charCodeAt(0) - 97)))) {
                consistent = false;
                break;
            }
        }
        if (consistent) {
            count++;
        }
    }
    return count;
};
