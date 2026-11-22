// https://leetcode.com/problems/combination-sum-iii/

// Solution: Backtracking — O(C(9,k)) time, O(k) space
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int k, int remaining, int start, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            if (remaining == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > remaining) {
                break;
            }
            path.add(i);
            backtrack(k, remaining - i, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
