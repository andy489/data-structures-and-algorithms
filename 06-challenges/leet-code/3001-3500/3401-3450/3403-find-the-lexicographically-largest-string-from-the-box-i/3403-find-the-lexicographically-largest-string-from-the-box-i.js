// https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/
var answerString = function(word, numFriends) {
    if (numFriends === 1) {
        return word;
    }
    const n = word.length;
    let best = "";
    for (let i = 0; i < n; i++) {
        const maxLen = n - (numFriends - 1) - i;
        if (maxLen <= 0) {
            break;
        }
        const candidate = word.substring(i, i + maxLen);
        if (candidate > best) {
            best = candidate;
        }
    }
    return best;
};
