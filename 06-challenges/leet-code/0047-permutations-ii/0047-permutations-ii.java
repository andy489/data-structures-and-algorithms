// https://leetcode.com/problems/permutations-ii/

// Solution: Backtracking with sort + duplicate skip — O(n!·n) time, O(n) space
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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

// Solution2: Backtracking with frequency map — O(n!·n) time, O(k) space (k = distinct values)
class Solution2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(freq, nums.length, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(Map<Integer, Integer> freq, int n, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            path.add(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            backtrack(freq, n, path, result);
            path.remove(path.size() - 1);
            entry.setValue(entry.getValue() + 1);
        }
    }
}
