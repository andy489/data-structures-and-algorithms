// https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/

var longestBeautifulSubstring = function(word) {
    const rank = {a: 0, e: 1, i: 2, o: 3, u: 4};
    let ans = 0, start = 0, distinct = 1;
    for (let i = 1; i < word.length; i++) {
        const cur = rank[word[i]], prev = rank[word[i - 1]];
        if (cur === prev) {
            // same vowel
        } else if (cur === prev + 1) {
            distinct++;
        } else {
            start = i;
            distinct = 1;
        }
        if (distinct === 5) {
            ans = Math.max(ans, i - start + 1);
        }
    }
    return ans;
};
