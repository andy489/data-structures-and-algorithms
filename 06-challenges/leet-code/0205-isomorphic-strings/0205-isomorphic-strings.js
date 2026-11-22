// https://leetcode.com/problems/isomorphic-strings/

// Solution: Bidirectional Map — O(n) time, O(1) space
var isIsomorphic = function(s, t) {
    const sToT = new Array(128).fill(0);
    const tToS = new Array(128).fill(0);

    for (let i = 0; i < s.length; i++) {
        const cs = s.charCodeAt(i);
        const ct = t.charCodeAt(i);

        if (sToT[cs] !== 0 && sToT[cs] !== ct) {
            return false;
        }

        if (tToS[ct] !== 0 && tToS[ct] !== cs) {
            return false;
        }

        sToT[cs] = ct;
        tToS[ct] = cs;
    }

    return true;
};
