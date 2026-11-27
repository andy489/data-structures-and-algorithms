// https://leetcode.com/problems/create-maximum-number/

// Solution: Monotonic Stack + Merge — O(k*(m+n)) time, O(m+n) space
var maxNumber = function(nums1, nums2, k) {
    function maxSubseq(nums, len) {
        const stack = [];
        let drop = nums.length - len;
        for (const n of nums) {
            while (drop && stack.length && stack[stack.length-1] < n) {
                stack.pop(); drop--;
            }
            stack.push(n);
        }
        return stack.slice(0, len);
    }

    function compare(a, i, b, j) {
        while (i < a.length && j < b.length) {
            if (a[i] !== b[j]) return a[i] - b[j];
            i++; j++;
        }
        return (a.length - i) - (b.length - j);
    }

    function merge(a, b) {
        const result = [];
        let i = 0, j = 0;
        while (i < a.length || j < b.length) {
            result.push(compare(a, i, b, j) >= 0 ? a[i++] : b[j++]);
        }
        return result;
    }

    const m = nums1.length, n = nums2.length;
    let best = [];
    for (let i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
        const candidate = merge(maxSubseq(nums1, i), maxSubseq(nums2, k - i));
        if (compare(candidate, 0, best, 0) > 0) best = candidate;
    }
    return best;
};
