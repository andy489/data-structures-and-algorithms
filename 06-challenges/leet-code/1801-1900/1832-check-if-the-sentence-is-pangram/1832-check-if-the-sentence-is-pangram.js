// https://leetcode.com/problems/check-if-the-sentence-is-pangram/

var checkIfPangram = function(sentence) {
    let mask = 0;
    for (const c of sentence) {
        mask |= 1 << (c.charCodeAt(0) - 97);
    }
    return mask === (1 << 26) - 1;
};
