// https://leetcode.com/problems/hand-of-straights/

var isNStraightHand = function(hand, groupSize) {
    if (hand.length % groupSize !== 0) return false;
    const freq = new Map();
    for (const c of hand) freq.set(c, (freq.get(c) || 0) + 1);
    const keys = [...freq.keys()].sort((a, b) => a - b);
    for (const key of keys) {
        const cnt = freq.get(key);
        if (cnt > 0) {
            for (let i = 0; i < groupSize; i++) {
                const k = key + i;
                if ((freq.get(k) || 0) < cnt) return false;
                freq.set(k, freq.get(k) - cnt);
            }
        }
    }
    return true;
};
