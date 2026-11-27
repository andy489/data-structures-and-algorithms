// https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function(nums) {
    const n = nums.length;
    const sorted = Array.from({length: n}, (_, i) => i);

    function isSorted(arr) {
        for (let i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    if (isSorted(nums)) {
        return 0;
    }

    function rotationOf(arr, target) {
        const startVal = target[0];
        for (let start = 0; start < n; start++) {
            if (arr[start] !== startVal) {
                continue;
            }
            let valid = true;
            for (let i = 0; i < n; i++) {
                if (arr[(start + i) % n] !== target[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return start;
            }
        }
        return -1;
    }

    const sortedAsc = Array.from({length: n}, (_, i) => i);
    const sortedDesc = Array.from({length: n}, (_, i) => n - 1 - i);

    const posAsc = rotationOf(nums, sortedAsc);
    const posDesc = rotationOf(nums, sortedDesc);

    if (posAsc === -1 && posDesc === -1) {
        return -1;
    }

    let ans = Infinity;
    if (posAsc !== -1) {
        ans = Math.min(ans, posAsc);
    }
    if (posDesc !== -1) {
        ans = Math.min(ans, 1 + posDesc);
        ans = Math.min(ans, 1 + (n - posDesc) % n);
    }
    return ans;
};
