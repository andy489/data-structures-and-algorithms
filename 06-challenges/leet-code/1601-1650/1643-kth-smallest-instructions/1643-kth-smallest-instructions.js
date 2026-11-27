// https://leetcode.com/problems/kth-smallest-instructions/

var kthSmallestPath = function(destination, k) {
    let v = destination[0], h = destination[1];
    const comb = (n, r) => {
        if (r < 0 || r > n) {
            return 0;
        }
        if (r > n - r) {
            r = n - r;
        }
        let res = 1;
        for (let i = 0; i < r; i++) {
            res = res * (n - i) / (i + 1);
        }
        return res;
    };
    let res = '';
    while (h > 0 && v > 0) {
        const cnt = comb(h + v - 1, h - 1);
        if (k <= cnt) {
            res += 'H';
            h--;
        } else {
            k -= cnt;
            res += 'V';
            v--;
        }
    }
    res += 'H'.repeat(h) + 'V'.repeat(v);
    return res;
};
