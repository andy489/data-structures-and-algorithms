// https://leetcode.com/problems/contains-duplicate-iii/

// Solution: Bucket Sort — O(n) time, O(min(n, indexDiff)) space
var containsNearbyAlmostDuplicate = function(nums, indexDiff, valueDiff) {
    const size = BigInt(valueDiff) + 1n;

    function getBucket(v) {
        v = BigInt(v);
        return v < 0n ? (v + 1n) / size - 1n : v / size;
    }

    const buckets = new Map();
    for (let i = 0; i < nums.length; i++) {
        const id = getBucket(nums[i]);
        if (buckets.has(id)) return true;
        if (buckets.has(id - 1n) && Math.abs(nums[i] - Number(buckets.get(id - 1n))) <= valueDiff) return true;
        if (buckets.has(id + 1n) && Math.abs(nums[i] - Number(buckets.get(id + 1n))) <= valueDiff) return true;
        buckets.set(id, nums[i]);
        if (i >= indexDiff) buckets.delete(getBucket(nums[i - indexDiff]));
    }
    return false;
};
