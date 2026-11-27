// https://leetcode.com/problems/smallest-substring-with-identical-characters-ii/

var minLength = function(s, numOps) {
    const n = s.length;

    const canAchieve = (maxLen) => {
        if (maxLen === 1) {
            let flips0 = 0;
            for (let i = 0; i < n; i++) {
                if (s[i] !== String(i % 2)) { flips0++; }
            }
            return Math.min(flips0, n - flips0) <= numOps;
        }
        let flips = 0, i = 0;
        while (i < n) {
            let j = i;
            while (j < n && s[j] === s[i]) { j++; }
            flips += Math.floor((j - i - 1) / maxLen);
            i = j;
        }
        return flips <= numOps;
    };

    let lo = 1, hi = n;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (canAchieve(mid)) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
};
