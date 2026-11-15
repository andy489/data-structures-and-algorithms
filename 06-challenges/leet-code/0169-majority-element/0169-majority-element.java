// https://leetcode.com/problems/majority-element/

// Solution: Boyer–Moore Voting — O(n) time, O(1) space
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}

// Solution 2: HashMap Count — O(n) time, O(n) space
class Solution2 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int half = nums.length / 2;
        for (int num : nums) {
            int count = freq.merge(num, 1, Integer::sum);
            if (count > half) {
                return num;
            }
        }
        throw new IllegalStateException();
    }
}

// Solution 3: Sorting — O(n log n) time, O(1) space
class Solution3 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
