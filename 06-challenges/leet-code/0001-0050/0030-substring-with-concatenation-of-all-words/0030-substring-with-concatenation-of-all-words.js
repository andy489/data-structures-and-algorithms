// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

// Solution: Sliding Window with Frequency Maps — O(n · k) time, O(k) space
var findSubstring = function(s, words) {
    const n = s.length, k = words.length, w = words[0].length;
    const need = new Map();
    for (const word of words) need.set(word, (need.get(word) || 0) + 1);

    const result = [];

    for (let i = 0; i < w; i++) {
        const have = new Map();
        let left = i, matched = 0;

        for (let right = i; right + w <= n; right += w) {
            const cur = s.slice(right, right + w);

            if (!need.has(cur)) {
                have.clear();
                matched = 0;
                left = right + w;
                continue;
            }

            have.set(cur, (have.get(cur) || 0) + 1);
            if (have.get(cur) === need.get(cur)) matched++;

            while (have.get(cur) > need.get(cur)) {
                const leftWord = s.slice(left, left + w);
                if (have.get(leftWord) === need.get(leftWord)) matched--;
                have.set(leftWord, have.get(leftWord) - 1);
                left += w;
            }

            if (matched === need.size) result.push(left);
        }
    }
    return result;
};
