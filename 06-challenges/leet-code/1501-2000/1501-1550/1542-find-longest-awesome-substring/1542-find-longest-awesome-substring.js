// https://leetcode.com/problems/find-longest-awesome-substring/

var longestAwesome = function(s) {
    const firstSeen = new Int32Array(1 << 10).fill(-2);
    firstSeen[0] = -1;
    let mask = 0, best = 0;
    for (let i = 0; i < s.length; i++) {
        mask ^= 1 << (s.charCodeAt(i) - 48);
        if (firstSeen[mask] !== -2) {
            best = Math.max(best, i - firstSeen[mask]);
        } else {
            firstSeen[mask] = i;
        }
        for (let d = 0; d < 10; d++) {
            const flipped = mask ^ (1 << d);
            if (firstSeen[flipped] !== -2) {
                best = Math.max(best, i - firstSeen[flipped]);
            }
        }
    }
    return best;
};
