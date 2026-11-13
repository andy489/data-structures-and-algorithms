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

// Solution2: Bitmask enumeration — O(2^n · n) time, O(k) space
// Enumerate all 2^n subsets of {1..n} via bitmasks; collect those with exactly k bits set.
class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) != k) {
                continue;
            }
            List<Integer> combo = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    combo.add(i + 1); // bit i represents number (i+1)
                }
            }
            result.add(combo);
        }
        return result;
    }
}
