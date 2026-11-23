// https://leetcode.com/problems/longest-uncommon-subsequence-ii/

var findLUSlength = function(strs) {
    function isSubseq(s, t) {
        let si = 0;
        for (let ti = 0; ti < t.length && si < s.length; ti++) {
            if (s[si] === t[ti]) { si++; }
        }
        return si === s.length;
    }
    let result = -1;
    for (let i = 0; i < strs.length; i++) {
        const isSubOfOther = strs.some((t, j) => i !== j && isSubseq(strs[i], t));
        if (!isSubOfOther) { result = Math.max(result, strs[i].length); }
    }
    return result;
};
