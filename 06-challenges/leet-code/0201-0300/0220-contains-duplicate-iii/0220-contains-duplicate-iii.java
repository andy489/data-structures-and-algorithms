// https://leetcode.com/problems/contains-duplicate-iii/

// Solution: Bucket Sort — O(n) time, O(min(n, indexDiff)) space
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        long size = (long) valueDiff + 1;
        Map<Long, Long> buckets = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long id = getBucket(nums[i], size);
            if (buckets.containsKey(id)) {
                return true;
            }
            if (buckets.containsKey(id - 1) && Math.abs(nums[i] - buckets.get(id - 1)) <= valueDiff) {
                return true;
            }
            if (buckets.containsKey(id + 1) && Math.abs(nums[i] - buckets.get(id + 1)) <= valueDiff) {
                return true;
            }
            buckets.put(id, (long) nums[i]);
            if (i >= indexDiff) {
                buckets.remove(getBucket(nums[i - indexDiff], size));
            }
        }
        return false;
    }

    private long getBucket(long v, long size) {
        return v < 0 ? (v + 1) / size - 1 : v / size;
    }
}
