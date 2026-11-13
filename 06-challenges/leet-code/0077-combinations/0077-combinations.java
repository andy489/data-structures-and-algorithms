// https://leetcode.com/problems/combinations/

// Solution: Backtracking — O(C(n,k)·k) time, O(k) space
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        // prune: need at least (k - current.size()) more numbers from [i, n]
        int need = k - current.size();
        for (int i = start; i <= n - need + 1; i++) {
            current.add(i);
            backtrack(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
