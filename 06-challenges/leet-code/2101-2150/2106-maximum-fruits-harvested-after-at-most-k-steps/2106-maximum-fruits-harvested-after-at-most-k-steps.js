// https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/

// Solution: Sliding Window — O(n) time, O(1) extra space
var maxTotalFruits = function(fruits, startPos, k) {
    function reachable(L, R) {
        if (R < startPos) return startPos - L <= k;
        if (L > startPos) return R - startPos <= k;
        return (R - L) + Math.min(startPos - L, R - startPos) <= k;
    }

    let left = 0, windowSum = 0, result = 0;

    for (let right = 0; right < fruits.length; right++) {
        windowSum += fruits[right][1];

        while (left <= right && !reachable(fruits[left][0], fruits[right][0])) {
            windowSum -= fruits[left][1];
            left++;
        }

        result = Math.max(result, windowSum);
    }

    return result;
};
