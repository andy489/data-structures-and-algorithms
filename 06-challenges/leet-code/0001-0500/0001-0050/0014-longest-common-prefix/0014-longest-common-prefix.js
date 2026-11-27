// https://leetcode.com/problems/longest-common-prefix/

var longestCommonPrefix = function(strs) {
    strs.sort();
    const first = strs[0];
    const last = strs[strs.length - 1];
    let i = 0;

    while (i < first.length && first[i] === last[i]) {
        i++;
    }

    return first.substring(0, i);
};
