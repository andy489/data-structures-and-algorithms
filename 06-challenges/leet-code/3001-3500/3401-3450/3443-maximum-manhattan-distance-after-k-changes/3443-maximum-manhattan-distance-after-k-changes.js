// https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/
var maxDistance = function(s, k) {
    const opp = {N: 'S', S: 'N', E: 'W', W: 'E'};
    let res = 0;
    for (const [t1, t2] of [['N','E'],['N','W'],['S','E'],['S','W']]) {
        let a1 = 0, a2 = 0, changes = 0;
        for (const c of s) {
            if (c === t1) {
                a1++;
            } else if (c === t2) {
                a2++;
            } else if (changes < k) {
                changes++;
                if (c === opp[t1]) {
                    a1++;
                } else {
                    a2++;
                }
            } else {
                if (c === opp[t1]) {
                    a1--;
                } else {
                    a2--;
                }
            }
            res = Math.max(res, a1 + a2);
        }
    }
    return res;
};
