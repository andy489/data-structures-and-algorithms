// https://leetcode.com/problems/concatenated-words/

var findAllConcatenatedWordsInADict = function(words) {
    words.sort((a, b) => a.length - b.length);
    const wordSet = new Set();
    const result = [];

    const canForm = (word) => {
        if (wordSet.size === 0) return false;
        const n = word.length;
        const reachable = new Array(n + 1).fill(false);
        reachable[0] = true;
        for (let i = 1; i <= n; i++) {
            for (let j = 0; j < i; j++) {
                if (reachable[j] && wordSet.has(word.slice(j, i))) {
                    reachable[i] = true;
                    break;
                }
            }
        }
        return reachable[n];
    };

    for (const word of words) {
        if (canForm(word)) result.push(word);
        wordSet.add(word);
    }
    return result;
};
