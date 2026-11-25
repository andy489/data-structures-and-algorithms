// https://leetcode.com/problems/orderly-queue/

var orderlyQueue = function(s, k) {
    if (k === 1) {
        let best = s;
        for (let i = 1; i < s.length; i++) {
            const rot = s.slice(i) + s.slice(0, i);
            if (rot < best) best = rot;
        }
        return best;
    }
    return s.split('').sort().join('');
};
