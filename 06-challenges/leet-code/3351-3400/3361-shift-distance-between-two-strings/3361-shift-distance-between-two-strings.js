// https://leetcode.com/problems/shift-distance-between-two-strings/

// Solution: Prefix Sum on Circular Alphabet — O(n + 26) time, O(26) space
var shiftDistance = function(s, t, nextCost, previousCost) {
    const nextPre = new Array(53).fill(0);
    for (let i = 0; i < 52; i++) {
        nextPre[i + 1] = nextPre[i] + nextCost[i % 26];
    }

    const revPrevPre = new Array(53).fill(0);
    for (let i = 51; i >= 0; i--) {
        revPrevPre[i] = revPrevPre[i + 1] + previousCost[i % 26];
    }

    let ans = 0;
    for (let i = 0; i < s.length; i++) {
        const a = s.charCodeAt(i) - 97;
        const b = t.charCodeAt(i) - 97;
        if (a === b) {
            continue;
        }
        const fwdSteps = (b - a + 26) % 26;
        const fwdCost = nextPre[a + fwdSteps] - nextPre[a];

        const bwdSteps = (a - b + 26) % 26;
        const start = 51 - a;
        const bwdCost = revPrevPre[start] - revPrevPre[start + bwdSteps];

        ans += Math.min(fwdCost, bwdCost);
    }
    return ans;
};
