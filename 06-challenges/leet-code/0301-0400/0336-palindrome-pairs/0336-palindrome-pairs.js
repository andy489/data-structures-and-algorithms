// https://leetcode.com/problems/palindrome-pairs/

var palindromePairs = function(words) {
    const wordIdx = new Map(words.map((w, i) => [w, i]));
    const isPalin = s => s === s.split('').reverse().join('');
    const result = [];
    for (let i = 0; i < words.length; i++) {
        const w = words[i];
        for (let k = 0; k <= w.length; k++) {
            const prefix = w.slice(0, k), suffix = w.slice(k);
            if (isPalin(prefix)) {
                const j = wordIdx.get(suffix.split('').reverse().join(''));
                if (j !== undefined && j !== i) result.push([j, i]);
            }
            if (k !== w.length && isPalin(suffix)) {
                const j = wordIdx.get(prefix.split('').reverse().join(''));
                if (j !== undefined && j !== i) result.push([i, j]);
            }
        }
    }
    return result;
};
