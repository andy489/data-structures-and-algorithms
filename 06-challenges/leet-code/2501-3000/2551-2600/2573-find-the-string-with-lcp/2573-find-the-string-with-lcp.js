// https://leetcode.com/problems/find-the-string-with-lcp/

/**
 * @param {number[][]} lcp
 * @return {string}
 */
var findTheString = function(lcp) {
    const n = lcp.length;
    const word = new Array(n).fill('');

    let nextChar = 0;
    for (let i = 0; i < n; i++) {
        if (word[i]) continue;
        if (nextChar >= 26) return '';
        word[i] = String.fromCharCode(97 + nextChar++);
        for (let j = i + 1; j < n; j++) {
            if (lcp[i][j] > 0) {
                if (word[j] && word[j] !== word[i]) return '';
                word[j] = word[i];
            }
        }
    }

    // Validate
    const actual = Array.from({length: n + 1}, () => new Array(n + 1).fill(0));
    for (let i = n - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            if (word[i] === word[j]) {
                actual[i][j] = actual[i + 1][j + 1] + 1;
            } else {
                actual[i][j] = 0;
            }
            if (actual[i][j] !== lcp[i][j]) return '';
        }
    }

    return word.join('');
};
