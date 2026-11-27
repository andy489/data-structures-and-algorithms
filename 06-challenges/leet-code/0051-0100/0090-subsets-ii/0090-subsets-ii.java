// https://leetcode.com/problems/subsets-ii/

// Solution: Sort + Backtracking with Duplicate Skip — O(n·2^n) time, O(n) space
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// Solution 2: Iterative Insertion — O(n·2^n) time, O(1) space
class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        int prevSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = (i > 0 && nums[i] == nums[i - 1]) ? prevSize : 0;
            prevSize = result.size();
            for (int j = start; j < prevSize; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
        }
        return result;
    }
}
