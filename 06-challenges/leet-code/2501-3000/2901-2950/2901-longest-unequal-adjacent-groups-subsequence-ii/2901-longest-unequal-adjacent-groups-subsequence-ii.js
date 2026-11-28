// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/

var getWordsInLongestSubsequence = function(words, groups) {
    const n = words.length;
    const dp = new Array(n).fill(1);
    const prev = new Array(n).fill(-1);

    function hamming(a, b) {
        let dist = 0;
        for (let i = 0; i < a.length; i++) {
            if (a[i] !== b[i]) dist++;
        }
        return dist;
    }

    let best = 0;
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (groups[j] !== groups[i]
                    && words[j].length === words[i].length
                    && hamming(words[j], words[i]) === 1) {
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }
        if (dp[i] > dp[best]) {
            best = i;
        }
    }

    const result = [];
    for (let cur = best; cur !== -1; cur = prev[cur]) {
        result.push(words[cur]);
    }
    return result.reverse();
};
