// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/

// Solution: Sort + Group by Reachability — O(n log n) time, O(n) space
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> nums[a] - nums[b]);

        int[] result = new int[n];
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[indices[j]] - nums[indices[j - 1]] <= limit) {
                j++;
            }
            // group indices[i..j-1]: values sorted, original positions sorted
            List<Integer> groupIdx = new ArrayList<>();
            for (int x = i; x < j; x++) {
                groupIdx.add(indices[x]);
            }
            Collections.sort(groupIdx);
            for (int x = i; x < j; x++) {
                result[groupIdx.get(x - i)] = nums[indices[x]];
            }
            i = j;
        }
        return result;
    }
}
