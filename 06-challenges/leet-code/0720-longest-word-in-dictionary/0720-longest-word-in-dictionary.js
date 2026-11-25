// https://leetcode.com/problems/longest-word-in-dictionary/

var longestWord = function(words) {
    words.sort();
    const seen = new Set(['']);
    let ans = '';
    for (const word of words) {
        if (seen.has(word.slice(0, -1))) {
            seen.add(word);
            if (word.length > ans.length) {
                ans = word;
            }
        }
    }
    return ans;
};
