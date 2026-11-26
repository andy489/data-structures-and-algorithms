// https://leetcode.com/problems/longest-subsequence-repeated-k-times/

// Solution: BFS on Candidates — O(n * L^2) time, O(L!) space
var longestSubsequenceRepeatedK = function(s, k) {
    const freq = new Array(26).fill(0);
    for (const c of s) freq[c.charCodeAt(0) - 97]++;
    const cands = [];
    for (let i = 0; i < 26; i++) { if (freq[i] >= k) cands.push(String.fromCharCode(97 + i)); }
    const isSubRep = (t) => {
        let ti = 0, rep = 0;
        for (const c of s) {
            if (c === t[ti]) { ti++; if (ti === t.length) { ti = 0; if (++rep === k) return true; } }
        }
        return false;
    };
    let res = '';
    const q = [''];
    while (q.length) {
        const cur = q.shift();
        for (const c of cands) {
            const nxt = cur + c;
            if (isSubRep(nxt)) {
                if (nxt.length > res.length || (nxt.length === res.length && nxt > res)) res = nxt;
                q.push(nxt);
            }
        }
    }
    return res;
};
