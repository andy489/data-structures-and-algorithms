// https://leetcode.com/problems/permutations/

// Solution: Backtracking with used-set — O(n!·n) time, O(n) space
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

// Solution2: Backtracking via in-place swapping — O(n!·n) time, O(n) space
class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            Integer[] boxed = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                boxed[i] = nums[i];
            }
            result.add(Arrays.asList(boxed));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            backtrack(nums, start + 1, result);
            tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
        }
    }
}
