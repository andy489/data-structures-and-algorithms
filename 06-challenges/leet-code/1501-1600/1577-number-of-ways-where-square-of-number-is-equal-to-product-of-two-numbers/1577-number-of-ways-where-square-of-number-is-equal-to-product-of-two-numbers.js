// https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/

var numTriplets = function(nums1, nums2) {
    const countTrip = (a, b) => {
        const freq = new Map();
        for (const x of b) {
            freq.set(x, (freq.get(x) || 0) + 1);
        }
        let total = 0;
        for (const x of a) {
            const sq = x * x;
            for (const [bv, cnt] of freq) {
                if (sq % bv === 0) {
                    const pair = sq / bv;
                    if (pair !== bv) {
                        total += cnt * (freq.get(pair) || 0);
                    } else {
                        total += cnt * (cnt - 1);
                    }
                }
            }
        }
        return total / 2;
    };

    return countTrip(nums1, nums2) + countTrip(nums2, nums1);
};
