// https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/

var findNumOfValidWords = function(words, puzzles) {
    const freq = new Map();
    for (const word of words) {
        let mask = 0;
        for (const c of word) {
            mask |= (1 << (c.charCodeAt(0) - 97));
        }
        freq.set(mask, (freq.get(mask) || 0) + 1);
    }
    const result = [];
    for (const puzzle of puzzles) {
        let puzzleMask = 0;
        for (const c of puzzle) {
            puzzleMask |= (1 << (c.charCodeAt(0) - 97));
        }
        const firstBit = 1 << (puzzle.charCodeAt(0) - 97);
        let count = 0;
        for (let sub = puzzleMask; sub > 0; sub = (sub - 1) & puzzleMask) {
            if (sub & firstBit) {
                count += freq.get(sub) || 0;
            }
        }
        result.push(count);
    }
    return result;
};
