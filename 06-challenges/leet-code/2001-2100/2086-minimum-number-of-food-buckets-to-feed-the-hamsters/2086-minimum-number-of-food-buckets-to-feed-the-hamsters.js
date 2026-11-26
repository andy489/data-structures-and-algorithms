// https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/

// Solution: Greedy — O(n) time, O(1) space
var minimumBuckets = function(hamsters) {
    const h = [...hamsters];
    let count = 0;
    for (let i = 0; i < h.length; i++) {
        if (h[i] === 'H') {
            if (i + 1 < h.length && h[i+1] === '#') { h[i+1] = 'B'; count++; }
            else if (i - 1 >= 0 && h[i-1] === '#') { count++; }
            else return -1;
        }
    }
    return count;
};
