// https://leetcode.com/problems/count-valid-word-occurrences/

/**
 * @param {string[]} chunks
 * @param {string[]} queries
 * @return {number[]}
 */
var countValidWordOccurrences = function(chunks, queries) {
    const s = chunks.join('');
    const n = s.length;
    const freq = new Map();
    let start = -1;
    for (let i = 0; i <= n; i++) {
        const ch = i < n ? s[i] : ' ';
        if (i < n && ch >= 'a' && ch <= 'z') {
            if (start === -1) {
                start = i;
            }
        } else if (i < n && ch === '-') {
            if (start === -1 || i + 1 >= n || !(s[i + 1] >= 'a' && s[i + 1] <= 'z')) {
                if (start !== -1) {
                    const word = s.slice(start, i);
                    freq.set(word, (freq.get(word) || 0) + 1);
                    start = -1;
                }
            }
            // else joiner hyphen, continue
        } else {
            if (start !== -1) {
                const word = s.slice(start, i);
                freq.set(word, (freq.get(word) || 0) + 1);
                start = -1;
            }
        }
    }
    return queries.map(q => freq.get(q) || 0);
};
