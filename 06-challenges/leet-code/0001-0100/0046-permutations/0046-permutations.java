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

// Solution2: Backtracking via in-place swapping with Collections.swap — O(n!·n) time, O(n) space
class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(list, 0, result);
        return result;
    }

    private void backtrack(List<Integer> list, int start, List<List<Integer>> result) {
        if (start == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, start, i);
            backtrack(list, start + 1, result);
            Collections.swap(list, start, i);
        }
    }
}
