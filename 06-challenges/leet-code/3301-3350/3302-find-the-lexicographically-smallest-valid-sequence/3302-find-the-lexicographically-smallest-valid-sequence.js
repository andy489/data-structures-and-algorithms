// https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/

/**
 * @param {string} word1
 * @param {string} word2
 * @return {number[]}
 */
var validSequence = function (word1, word2) {
    const n = word1.length, m = word2.length;
    const suf = new Array(n + 1).fill(0);
    let j = m - 1;
    for (let i = n - 1; i >= 0 && j >= 0; i--) {
        if (word1[i] === word2[j]) {
            j--;
        }
        suf[i] = m - 1 - j;
    }
    const ans = [];
    let idx = 0;
    let usedChange = false;
    for (let i = 0; i < n && idx < m; i++) {
        if (word1[i] === word2[idx]) {
            ans.push(i);
            idx++;
        } else if (!usedChange && idx + suf[i + 1] >= m) {
            ans.push(i);
            idx++;
            usedChange = true;
        }
    }
    return idx < m ? [] : ans;
};
